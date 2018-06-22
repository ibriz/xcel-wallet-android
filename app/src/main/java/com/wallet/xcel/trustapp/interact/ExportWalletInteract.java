package com.wallet.xcel.trustapp.interact;

import com.wallet.xcel.trustapp.entity.Wallet;
import com.wallet.xcel.trustapp.repository.PasswordStore;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ExportWalletInteract {

    private final WalletRepositoryType walletRepository;
    private final PasswordStore passwordStore;

    public ExportWalletInteract(WalletRepositoryType walletRepository, PasswordStore passwordStore) {
        this.walletRepository = walletRepository;
        this.passwordStore = passwordStore;
    }

    public Single<String> export(Wallet wallet, String backupPassword) {
        return passwordStore
                .getPassword(wallet)
                .flatMap(password -> walletRepository
                    .exportWallet(wallet, password, backupPassword))
                .observeOn(AndroidSchedulers.mainThread());
    }
}
