package com.wallet.xcel.trustapp.router;

import android.content.Context;
import android.content.Intent;

import com.wallet.xcel.trustapp.ui.SettingsActivity;

public class SettingsRouter {

    public void open(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }
}
