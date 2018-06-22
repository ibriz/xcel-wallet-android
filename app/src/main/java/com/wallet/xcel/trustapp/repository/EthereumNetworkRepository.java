package com.wallet.xcel.trustapp.repository;

import android.text.TextUtils;

import com.wallet.xcel.trustapp.entity.NetworkInfo;
import com.wallet.xcel.trustapp.entity.Ticker;
import com.wallet.xcel.trustapp.service.TickerService;
import com.wallet.xcel.trustapp.C;

import java.util.HashSet;
import java.util.Set;

import io.reactivex.Single;

public class EthereumNetworkRepository implements EthereumNetworkRepositoryType {

	private final NetworkInfo[] NETWORKS = new NetworkInfo[] {
			new NetworkInfo(C.ETHEREUM_NETWORK_NAME, C.ETH_SYMBOL,
                    "https://mainnet.infura.io/llyrtzQ3YhkdESt2Fzrk",
                    "https://api.trustwalletapp.com/",
                    "https://etherscan.io/",1, true),
            new NetworkInfo(C.CLASSIC_NETWORK_NAME, C.ETC_SYMBOL,
                    "https://mewapi.epool.io/",
                    "https://classic.trustwalletapp.com",
                    "https://gastracker.io",61, true),
            new NetworkInfo(C.POA_NETWORK_NAME, C.POA_SYMBOL,
                    "https://core.poa.network",
                    "https://poa.trustwalletapp.com","poa", 99, false),
			new NetworkInfo(C.KOVAN_NETWORK_NAME, C.ETH_SYMBOL,
                    "https://kovan.infura.io/llyrtzQ3YhkdESt2Fzrk",
                    "https://kovan.trustwalletapp.com/",
                    "https://kovan.etherscan.io", 42, false),
			new NetworkInfo(C.ROPSTEN_NETWORK_NAME, C.ETH_SYMBOL,
                    "https://ropsten.infura.io/llyrtzQ3YhkdESt2Fzrk",
                    "https://ropsten.trustwalletapp.com/",
                    "https://ropsten.etherscan.io",3, false),
	};

	private final PreferenceRepositoryType preferences;
    private final TickerService tickerService;
    private NetworkInfo defaultNetwork;
    private final Set<OnNetworkChangeListener> onNetworkChangedListeners = new HashSet<>();

    public EthereumNetworkRepository(PreferenceRepositoryType preferenceRepository, TickerService tickerService) {
		this.preferences = preferenceRepository;
		this.tickerService = tickerService;
		defaultNetwork = getByName(preferences.getDefaultNetwork());
		if (defaultNetwork == null) {
			defaultNetwork = NETWORKS[0];
		}
	}

	private NetworkInfo getByName(String name) {
		if (!TextUtils.isEmpty(name)) {
			for (NetworkInfo NETWORK : NETWORKS) {
				if (name.equals(NETWORK.name)) {
					return NETWORK;
				}
			}
		}
		return null;
	}

	@Override
	public NetworkInfo getDefaultNetwork() {
		return defaultNetwork;
	}

	@Override
	public void setDefaultNetworkInfo(NetworkInfo networkInfo) {
		defaultNetwork = networkInfo;
		preferences.setDefaultNetwork(defaultNetwork.name);

		for (OnNetworkChangeListener listener : onNetworkChangedListeners) {
		    listener.onNetworkChanged(networkInfo);
        }
	}

	@Override
	public NetworkInfo[] getAvailableNetworkList() {
		return NETWORKS;
	}

	@Override
	public void addOnChangeDefaultNetwork(OnNetworkChangeListener onNetworkChanged) {
        onNetworkChangedListeners.add(onNetworkChanged);
	}

    @Override
    public Single<Ticker> getTicker() {
        return Single.fromObservable(tickerService
                .fetchTickerPrice(getDefaultNetwork().symbol));
    }
}
