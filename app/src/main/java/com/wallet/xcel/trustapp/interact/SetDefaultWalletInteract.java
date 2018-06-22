package com.wallet.xcel.trustapp.interact;

import com.wallet.xcel.trustapp.entity.Wallet;
import com.wallet.xcel.trustapp.repository.WalletRepositoryType;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SetDefaultWalletInteract {

	private WalletRepositoryType accountRepository;

	public SetDefaultWalletInteract(WalletRepositoryType walletRepositoryType) {
		this.accountRepository = walletRepositoryType;
	}

	public Completable set(Wallet wallet) {
		return accountRepository
				.setDefaultWallet(wallet)
				.observeOn(AndroidSchedulers.mainThread());
	}
}
