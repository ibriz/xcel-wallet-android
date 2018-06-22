package com.wallet.xcel.trustapp.repository;

import com.wallet.xcel.trustapp.entity.NetworkInfo;

public interface OnNetworkChangeListener {
	void onNetworkChanged(NetworkInfo networkInfo);
}
