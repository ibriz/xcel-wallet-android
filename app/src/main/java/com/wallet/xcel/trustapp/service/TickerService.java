package com.wallet.xcel.trustapp.service;

import com.wallet.xcel.trustapp.entity.Ticker;

import io.reactivex.Observable;

public interface TickerService {

    Observable<Ticker> fetchTickerPrice(String ticker);
}
