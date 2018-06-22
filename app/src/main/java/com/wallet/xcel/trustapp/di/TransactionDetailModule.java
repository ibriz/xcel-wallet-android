package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.interact.FindDefaultNetworkInteract;
import com.wallet.xcel.trustapp.interact.FindDefaultWalletInteract;
import com.wallet.xcel.trustapp.repository.EthereumNetworkRepositoryType;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;
import com.wallet.xcel.trustapp.router.ExternalBrowserRouter;
import com.wallet.xcel.trustapp.viewmodel.TransactionDetailViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class TransactionDetailModule {

    @Provides
    TransactionDetailViewModelFactory provideTransactionDetailViewModelFactory(
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            FindDefaultWalletInteract findDefaultWalletInteract,
            ExternalBrowserRouter externalBrowserRouter) {
        return new TransactionDetailViewModelFactory(
                findDefaultNetworkInteract, findDefaultWalletInteract, externalBrowserRouter);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumNetworkRepositoryType ethereumNetworkRepository) {
        return new FindDefaultNetworkInteract(ethereumNetworkRepository);
    }

    @Provides
    ExternalBrowserRouter externalBrowserRouter() {
        return new ExternalBrowserRouter();
    }

    @Provides
    FindDefaultWalletInteract findDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }
}
