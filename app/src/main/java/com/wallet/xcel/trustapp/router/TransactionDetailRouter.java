package com.wallet.xcel.trustapp.router;

import android.content.Context;
import android.content.Intent;

import com.wallet.xcel.trustapp.entity.Transaction;
import com.wallet.xcel.trustapp.ui.TransactionDetailActivity;

import static com.wallet.xcel.trustapp.C.Key.TRANSACTION;

public class TransactionDetailRouter {

    public void open(Context context, Transaction transaction) {
        Intent intent = new Intent(context, TransactionDetailActivity.class);
        intent.putExtra(TRANSACTION, transaction);
        context.startActivity(intent);
    }
}
