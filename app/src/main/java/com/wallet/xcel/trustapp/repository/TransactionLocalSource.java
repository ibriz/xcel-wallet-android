package com.wallet.xcel.trustapp.repository;

import com.wallet.xcel.trustapp.entity.Transaction;
import com.wallet.xcel.trustapp.entity.Wallet;

import io.reactivex.Single;

public interface TransactionLocalSource {
	Single<Transaction[]> fetchTransaction(Wallet wallet);

	void putTransactions(Wallet wallet, Transaction[] transactions);

    void clear();
}
