package com.wallet.xcel.trustapp.router;


import android.app.Activity;
import android.content.Intent;

import com.wallet.xcel.trustapp.C;
import com.wallet.xcel.trustapp.entity.GasSettings;
import com.wallet.xcel.trustapp.ui.GasSettingsActivity;
import com.wallet.xcel.trustapp.viewmodel.GasSettingsViewModel;

public class GasSettingsRouter {
    public void open(Activity context, GasSettings gasSettings) {
        Intent intent = new Intent(context, GasSettingsActivity.class);
        intent.putExtra(C.EXTRA_GAS_PRICE, gasSettings.gasPrice.toString());
        intent.putExtra(C.EXTRA_GAS_LIMIT, gasSettings.gasLimit.toString());
        context.startActivityForResult(intent, GasSettingsViewModel.SET_GAS_SETTINGS);
    }
}
