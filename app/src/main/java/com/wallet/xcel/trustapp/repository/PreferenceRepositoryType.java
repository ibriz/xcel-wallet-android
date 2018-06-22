package com.wallet.xcel.trustapp.repository;

import com.wallet.xcel.trustapp.entity.GasSettings;

public interface PreferenceRepositoryType {
	String getCurrentWalletAddress();
	void setCurrentWalletAddress(String address);

	String getDefaultNetwork();
	void setDefaultNetwork(String netName);

	GasSettings getGasSettings(boolean forTokenTransfer);
	void setGasSettings(GasSettings gasPrice);

}
