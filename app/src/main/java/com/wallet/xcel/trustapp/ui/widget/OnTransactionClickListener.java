package com.wallet.xcel.trustapp.ui.widget;

import android.view.View;

import com.wallet.xcel.trustapp.entity.Transaction;

public interface OnTransactionClickListener {
    void onTransactionClick(View view, Transaction transaction);
}
