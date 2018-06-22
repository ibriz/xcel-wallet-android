package com.wallet.xcel.trustapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.wallet.xcel.trustapp.interact.CreateTransactionInteract;
import com.wallet.xcel.trustapp.interact.FetchGasSettingsInteract;
import com.wallet.xcel.trustapp.interact.FindDefaultWalletInteract;
import com.wallet.xcel.trustapp.router.GasSettingsRouter;

public class ConfirmationViewModelFactory implements ViewModelProvider.Factory {

    private FindDefaultWalletInteract findDefaultWalletInteract;
    private FetchGasSettingsInteract fetchGasSettingsInteract;
    private CreateTransactionInteract createTransactionInteract;
    private GasSettingsRouter gasSettingsRouter;

    public ConfirmationViewModelFactory(FindDefaultWalletInteract findDefaultWalletInteract,
                                        FetchGasSettingsInteract fetchGasSettingsInteract,
                                        CreateTransactionInteract createTransactionInteract,
                                        GasSettingsRouter gasSettingsRouter) {
        this.findDefaultWalletInteract = findDefaultWalletInteract;
        this.fetchGasSettingsInteract = fetchGasSettingsInteract;
        this.createTransactionInteract = createTransactionInteract;
        this.gasSettingsRouter = gasSettingsRouter;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ConfirmationViewModel(findDefaultWalletInteract, fetchGasSettingsInteract, createTransactionInteract, gasSettingsRouter);
    }
}
