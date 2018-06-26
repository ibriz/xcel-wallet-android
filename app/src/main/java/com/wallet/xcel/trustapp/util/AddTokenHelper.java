package com.wallet.xcel.trustapp.util;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;

import com.wallet.xcel.trustapp.R;
import com.wallet.xcel.trustapp.entity.Address;
import com.wallet.xcel.trustapp.entity.ErrorEnvelope;
import com.wallet.xcel.trustapp.ui.TokensActivity;
import com.wallet.xcel.trustapp.ui.TransactionsActivity;
import com.wallet.xcel.trustapp.viewmodel.AddTokenViewModel;
import com.wallet.xcel.trustapp.widget.SystemView;

public class AddTokenHelper {

    private AddTokenViewModel viewModel;

    private SystemView systemView;
    private Dialog dialog;

    private Context context;


    public void init(Context context, AddTokenViewModel addTokenviewModel) {
        TokensActivity activity = (TokensActivity) context;
        this.context = context;
        this.viewModel = addTokenviewModel;
        viewModel.error().observe(activity, this::onError);
        viewModel.result().observe(activity, this::onSaved);
    }

    private void onSaved(boolean result) {
        Log.i("Helper: ","Saved");
    }

    private void onError(ErrorEnvelope errorEnvelope) {
        dialog = new AlertDialog.Builder(context)
                .setTitle(R.string.title_dialog_error)
                .setMessage(R.string.error_add_token)
                .setPositiveButton(R.string.try_again, null)
                .create();
        dialog.show();
    }

    public void addDefaultToken(String address, String symbol, String rawDecimals) {
        boolean isValid = true;

        int decimals = 0;

        if (TextUtils.isEmpty(address)) {
            isValid = false;
        }

        if (TextUtils.isEmpty(symbol)) {
            isValid = false;
        }

        if (TextUtils.isEmpty(rawDecimals)) {
            isValid = false;
        }

        try {
            decimals = Integer.valueOf(rawDecimals);
        } catch (NumberFormatException ex) {
            isValid = false;
        }

        if (!Address.isAddress(address)) {
            //addressLayout.setError(getString(R.string.error_invalid_address));
            isValid = false;
        }

        if (isValid) {
            viewModel.save(address, symbol, decimals);
        }
    }
}
