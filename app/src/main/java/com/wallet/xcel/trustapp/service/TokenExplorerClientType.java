package com.wallet.xcel.trustapp.service;

import com.wallet.xcel.trustapp.entity.TokenInfo;

import io.reactivex.Observable;

public interface TokenExplorerClientType {
    Observable<TokenInfo[]> fetch(String walletAddress);
}