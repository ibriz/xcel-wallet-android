package com.wallet.xcel.trustapp.di;


import com.wallet.xcel.trustapp.interact.CreateTransactionInteract;
import com.wallet.xcel.trustapp.interact.FetchGasSettingsInteract;
import com.wallet.xcel.trustapp.interact.FindDefaultWalletInteract;
import com.wallet.xcel.trustapp.repository.PasswordStore;
import com.wallet.xcel.trustapp.repository.PreferenceRepositoryType;
import com.wallet.xcel.trustapp.repository.TransactionRepositoryType;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;
import com.wallet.xcel.trustapp.router.GasSettingsRouter;
import com.wallet.xcel.trustapp.viewmodel.ConfirmationViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ConfirmationModule {
    @Provides
    public ConfirmationViewModelFactory provideConfirmationViewModelFactory(
            FindDefaultWalletInteract findDefaultWalletInteract,
            FetchGasSettingsInteract fetchGasSettingsInteract,
            CreateTransactionInteract createTransactionInteract,
            GasSettingsRouter gasSettingsRouter
    ) {
        return new ConfirmationViewModelFactory(findDefaultWalletInteract, fetchGasSettingsInteract, createTransactionInteract, gasSettingsRouter);
    }

    @Provides
    FindDefaultWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }

    @Provides
    FetchGasSettingsInteract provideFetchGasSettingsInteract(PreferenceRepositoryType preferenceRepositoryType) {
        return new FetchGasSettingsInteract(preferenceRepositoryType);
    }

    @Provides
    CreateTransactionInteract provideCreateTransactionInteract(TransactionRepositoryType transactionRepository, PasswordStore passwordStore) {
        return new CreateTransactionInteract(transactionRepository, passwordStore);
    }

    @Provides
    GasSettingsRouter provideGasSettingsRouter() {
        return new GasSettingsRouter();
    }
}
