package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.router.ConfirmationRouter;
import com.wallet.xcel.trustapp.viewmodel.SendViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class SendModule {
    @Provides
    SendViewModelFactory provideSendViewModelFactory(ConfirmationRouter confirmationRouter) {
        return new SendViewModelFactory(confirmationRouter);
    }

    @Provides
    ConfirmationRouter provideConfirmationRouter() {
        return new ConfirmationRouter();
    }
}
