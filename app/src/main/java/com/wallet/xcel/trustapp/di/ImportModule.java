package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.interact.ImportWalletInteract;
import com.wallet.xcel.trustapp.repository.PasswordStore;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;
import com.wallet.xcel.trustapp.viewmodel.ImportWalletViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class ImportModule {
    @Provides
    ImportWalletViewModelFactory provideImportWalletViewModelFactory(
            ImportWalletInteract importWalletInteract) {
        return new ImportWalletViewModelFactory(importWalletInteract);
    }

    @Provides
    ImportWalletInteract provideImportWalletInteract(
            WalletRepositoryType walletRepository, PasswordStore passwordStore) {
        return new ImportWalletInteract(walletRepository, passwordStore);
    }
}
