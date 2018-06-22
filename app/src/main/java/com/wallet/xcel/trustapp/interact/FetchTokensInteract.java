package com.wallet.xcel.trustapp.interact;

import com.wallet.xcel.trustapp.entity.Token;
import com.wallet.xcel.trustapp.entity.Wallet;
import com.wallet.xcel.trustapp.repository.TokenRepositoryType;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FetchTokensInteract {

    private final TokenRepositoryType tokenRepository;

    public FetchTokensInteract(TokenRepositoryType tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Observable<Token[]> fetch(Wallet wallet) {
        return tokenRepository.fetch(wallet.address)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
