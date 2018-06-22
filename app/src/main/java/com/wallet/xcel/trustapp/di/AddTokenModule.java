package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.interact.AddTokenInteract;
import com.wallet.xcel.trustapp.interact.FindDefaultWalletInteract;
import com.wallet.xcel.trustapp.repository.TokenRepositoryType;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;
import com.wallet.xcel.trustapp.router.MyTokensRouter;
import com.wallet.xcel.trustapp.viewmodel.AddTokenViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class AddTokenModule {

    @Provides
    AddTokenViewModelFactory addTokenViewModelFactory(
            AddTokenInteract addTokenInteract,
            FindDefaultWalletInteract findDefaultWalletInteract,
            MyTokensRouter myTokensRouter) {
        return new AddTokenViewModelFactory(
                addTokenInteract, findDefaultWalletInteract, myTokensRouter);
    }

    @Provides
    AddTokenInteract provideAddTokenInteract(
            TokenRepositoryType tokenRepository,
            WalletRepositoryType walletRepository) {
        return new AddTokenInteract(walletRepository, tokenRepository);
    }

    @Provides
    FindDefaultWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }

    @Provides
    MyTokensRouter provideMyTokensRouter() {
        return new MyTokensRouter();
    }
}
