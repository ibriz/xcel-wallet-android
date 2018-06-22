package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.interact.FindDefaultWalletInteract;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;
import com.wallet.xcel.trustapp.router.ManageWalletsRouter;

import dagger.Module;
import dagger.Provides;

@Module
class SettingsFragmentModule {
    @Provides
    FindDefaultWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }

    @Provides
    ManageWalletsRouter provideManageWalletsRouter() {
        return new ManageWalletsRouter();
    }
}
