package com.wallet.xcel.trustapp.router;

import android.content.Context;
import android.content.Intent;

import com.wallet.xcel.trustapp.ui.SendActivity;

public class SendRouter {

    public void open(Context context) {
        Intent intent = new Intent(context, SendActivity.class);
        context.startActivity(intent);
    }
}
