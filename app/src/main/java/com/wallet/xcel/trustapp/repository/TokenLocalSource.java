package com.wallet.xcel.trustapp.repository;

import com.wallet.xcel.trustapp.entity.NetworkInfo;
import com.wallet.xcel.trustapp.entity.TokenInfo;
import com.wallet.xcel.trustapp.entity.Wallet;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface TokenLocalSource {
    Completable put(NetworkInfo networkInfo, Wallet wallet, TokenInfo tokenInfo);
    Single<TokenInfo[]> fetch(NetworkInfo networkInfo, Wallet wallet);
}
