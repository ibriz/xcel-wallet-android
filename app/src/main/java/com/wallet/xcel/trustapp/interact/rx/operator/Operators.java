package com.wallet.xcel.trustapp.interact.rx.operator;

import com.wallet.xcel.trustapp.entity.Wallet;
import com.wallet.xcel.trustapp.repository.PasswordStore;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;

import io.reactivex.CompletableOperator;
import io.reactivex.SingleTransformer;

public class Operators {

    public static SingleTransformer<Wallet, Wallet> savePassword(
            PasswordStore passwordStore, WalletRepositoryType walletRepository, String password) {
        return new SavePasswordOperator(passwordStore, walletRepository, password);
    }

    public static CompletableOperator completableErrorProxy(Throwable throwable) {
        return new CompletableErrorProxyOperator(throwable);
    }
}
