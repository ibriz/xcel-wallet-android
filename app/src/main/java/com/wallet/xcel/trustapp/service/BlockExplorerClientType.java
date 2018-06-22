package com.wallet.xcel.trustapp.service;

import com.wallet.xcel.trustapp.entity.Transaction;

import io.reactivex.Observable;

public interface BlockExplorerClientType {
	Observable<Transaction[]> fetchTransactions(String forAddress);
}
