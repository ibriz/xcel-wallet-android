package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.interact.FetchTokensInteract;
import com.wallet.xcel.trustapp.interact.FindDefaultNetworkInteract;
import com.wallet.xcel.trustapp.repository.EthereumNetworkRepositoryType;
import com.wallet.xcel.trustapp.repository.TokenRepositoryType;
import com.wallet.xcel.trustapp.router.AddTokenRouter;
import com.wallet.xcel.trustapp.router.SendTokenRouter;
import com.wallet.xcel.trustapp.router.TransactionsRouter;
import com.wallet.xcel.trustapp.viewmodel.TokensViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class TokensModule {

    @Provides
    TokensViewModelFactory provideTokensViewModelFactory(
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            FetchTokensInteract fetchTokensInteract,
            AddTokenRouter addTokenRouter,
            SendTokenRouter sendTokenRouter,
            TransactionsRouter transactionsRouter) {
        return new TokensViewModelFactory(
                findDefaultNetworkInteract,
                fetchTokensInteract,
                addTokenRouter,
                sendTokenRouter,
                transactionsRouter);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumNetworkRepositoryType networkRepository) {
        return new FindDefaultNetworkInteract(networkRepository);
    }

    @Provides
    FetchTokensInteract provideFetchTokensInteract(TokenRepositoryType tokenRepository) {
        return new FetchTokensInteract(tokenRepository);
    }

    @Provides
    AddTokenRouter provideAddTokenRouter() {
        return new AddTokenRouter();
    }

    @Provides
    SendTokenRouter provideSendTokenRouter() {
        return new SendTokenRouter();
    }

    @Provides
    TransactionsRouter provideTransactionsRouter() {
        return new TransactionsRouter();
    }
}
