package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.interact.FetchWalletsInteract;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;
import com.wallet.xcel.trustapp.viewmodel.SplashViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    @Provides
    SplashViewModelFactory provideSplashViewModelFactory(FetchWalletsInteract fetchWalletsInteract) {
        return new SplashViewModelFactory(fetchWalletsInteract);
    }

    @Provides
    FetchWalletsInteract provideFetchWalletInteract(WalletRepositoryType walletRepository) {
        return new FetchWalletsInteract(walletRepository);
    }
}
