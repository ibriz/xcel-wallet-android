package com.wallet.xcel.trustapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wallet.xcel.trustapp.repository.EthereumNetworkRepository;
import com.wallet.xcel.trustapp.repository.EthereumNetworkRepositoryType;
import com.wallet.xcel.trustapp.repository.PreferenceRepositoryType;
import com.wallet.xcel.trustapp.repository.SharedPreferenceRepository;

import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EthereumNetworkRepositoryTest {

	private EthereumNetworkRepositoryType networkRepository;

	@Before
	public void setUp() {
		Context context = InstrumentationRegistry.getTargetContext();
		PreferenceRepositoryType preferenceRepositoryType = new SharedPreferenceRepository(context);
		networkRepository = new EthereumNetworkRepository(preferenceRepositoryType);
	}

}
