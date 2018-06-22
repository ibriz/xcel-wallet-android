package com.wallet.xcel.trustapp.repository;

import com.wallet.xcel.trustapp.entity.NetworkInfo;
import com.wallet.xcel.trustapp.entity.Ticker;

import io.reactivex.Single;

public interface EthereumNetworkRepositoryType {

	NetworkInfo getDefaultNetwork();

	void setDefaultNetworkInfo(NetworkInfo networkInfo);

	NetworkInfo[] getAvailableNetworkList();

	void addOnChangeDefaultNetwork(OnNetworkChangeListener onNetworkChanged);

	Single<Ticker> getTicker();
}
