package com.wallet.xcel.trustapp.router;

import android.content.Context;
import android.content.Intent;

import com.wallet.xcel.trustapp.entity.Wallet;
import com.wallet.xcel.trustapp.ui.MyAddressActivity;
import com.wallet.xcel.trustapp.ui.MyWalletActivity;

import static com.wallet.xcel.trustapp.C.Key.WALLET;

public class MyWalletRouter {

    public void open(Context context, Wallet wallet) {
        Intent intent = new Intent(context, MyWalletActivity.class);
        intent.putExtra(WALLET, wallet);
        context.startActivity(intent);
    }
}
