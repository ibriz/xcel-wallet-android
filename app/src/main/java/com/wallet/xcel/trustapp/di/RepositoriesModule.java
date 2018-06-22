package com.wallet.xcel.trustapp.di;

import android.content.Context;

import com.google.gson.Gson;
import com.wallet.xcel.trustapp.repository.EthereumNetworkRepository;
import com.wallet.xcel.trustapp.repository.EthereumNetworkRepositoryType;
import com.wallet.xcel.trustapp.repository.PreferenceRepositoryType;
import com.wallet.xcel.trustapp.repository.RealmTokenSource;
import com.wallet.xcel.trustapp.repository.SharedPreferenceRepository;
import com.wallet.xcel.trustapp.repository.TokenLocalSource;
import com.wallet.xcel.trustapp.repository.TokenRepository;
import com.wallet.xcel.trustapp.repository.TokenRepositoryType;
import com.wallet.xcel.trustapp.repository.TransactionInMemorySource;
import com.wallet.xcel.trustapp.repository.TransactionLocalSource;
import com.wallet.xcel.trustapp.repository.TransactionRepository;
import com.wallet.xcel.trustapp.repository.TransactionRepositoryType;
import com.wallet.xcel.trustapp.repository.WalletRepository;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;
import com.wallet.xcel.trustapp.service.AccountKeystoreService;
import com.wallet.xcel.trustapp.service.BlockExplorerClient;
import com.wallet.xcel.trustapp.service.BlockExplorerClientType;
import com.wallet.xcel.trustapp.service.EthplorerTokenService;
import com.wallet.xcel.trustapp.service.GethKeystoreAccountService;
import com.wallet.xcel.trustapp.service.TickerService;
import com.wallet.xcel.trustapp.service.TokenExplorerClientType;
import com.wallet.xcel.trustapp.service.TrustWalletTickerService;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class RepositoriesModule {
	@Singleton
	@Provides
	PreferenceRepositoryType providePreferenceRepository(Context context) {
		return new SharedPreferenceRepository(context);
	}

	@Singleton
	@Provides
	AccountKeystoreService provideAccountKeyStoreService(Context context) {
        File file = new File(context.getFilesDir(), "keystore/keystore");
		return new GethKeystoreAccountService(file);
	}

	@Singleton
    @Provides
    TickerService provideTickerService(OkHttpClient httpClient, Gson gson) {
	    return new TrustWalletTickerService(httpClient, gson);
    }

	@Singleton
	@Provides
	EthereumNetworkRepositoryType provideEthereumNetworkRepository(
            PreferenceRepositoryType preferenceRepository,
            TickerService tickerService) {
		return new EthereumNetworkRepository(preferenceRepository, tickerService);
	}

	@Singleton
	@Provides
    WalletRepositoryType provideWalletRepository(
            OkHttpClient okHttpClient,
			PreferenceRepositoryType preferenceRepositoryType,
			AccountKeystoreService accountKeystoreService,
			EthereumNetworkRepositoryType networkRepository) {
		return new WalletRepository(
		        okHttpClient, preferenceRepositoryType, accountKeystoreService, networkRepository);
	}

	@Singleton
	@Provides
    TransactionRepositoryType provideTransactionRepository(
			EthereumNetworkRepositoryType networkRepository,
			AccountKeystoreService accountKeystoreService,
			BlockExplorerClientType blockExplorerClient) {
		TransactionLocalSource inMemoryCache = new TransactionInMemorySource();
		TransactionLocalSource inDiskCache = null;
		return new TransactionRepository(
				networkRepository,
				accountKeystoreService,
				inMemoryCache,
				inDiskCache,
				blockExplorerClient);
	}

	@Singleton
	@Provides
	BlockExplorerClientType provideBlockExplorerClient(
			OkHttpClient httpClient,
			Gson gson,
			EthereumNetworkRepositoryType ethereumNetworkRepository) {
		return new BlockExplorerClient(httpClient, gson, ethereumNetworkRepository);
	}

	@Singleton
    @Provides
    TokenRepositoryType provideTokenRepository(
            OkHttpClient okHttpClient,
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            TokenExplorerClientType tokenExplorerClientType,
            TokenLocalSource tokenLocalSource) {
	    return new TokenRepository(
	            okHttpClient,
	            ethereumNetworkRepository,
	            tokenExplorerClientType,
                tokenLocalSource);
    }

	@Singleton
    @Provides
    TokenExplorerClientType provideTokenService(OkHttpClient okHttpClient, Gson gson) {
	    return new EthplorerTokenService(okHttpClient, gson);
    }

    @Singleton
    @Provides
    TokenLocalSource provideRealmTokenSource() {
	    return new RealmTokenSource();
    }
}
