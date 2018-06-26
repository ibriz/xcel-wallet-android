package com.wallet.xcel.trustapp.ui.widget.holder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wallet.xcel.trustapp.R;
import com.wallet.xcel.trustapp.entity.Token;
import com.wallet.xcel.trustapp.ui.widget.OnTokenClickListener;

import java.math.BigDecimal;

public class TokenHolder extends BinderViewHolder<Token> implements View.OnClickListener {

    private final TextView symbol;
    private final TextView balance;
    private final ImageView logo;

    private Token token;
    private OnTokenClickListener onTokenClickListener;

    public TokenHolder(int resId, ViewGroup parent) {
        super(resId, parent);

        logo = findViewById(R.id.logo);
        symbol = findViewById(R.id.symbol);
        balance = findViewById(R.id.balance);
        itemView.setOnClickListener(this);
    }

    @Override
    public void bind(@Nullable Token data, @NonNull Bundle addition) {
        this.token = data;
        if (data == null) {
            fillEmpty();
            return;
        }
        try {
            symbol.setText(token.tokenInfo.symbol);

            if(token.tokenInfo.symbol.equals(getString(R.string.xcelSymbol))){
                logo.setImageResource(R.drawable.xcel);
            }else if(token.tokenInfo.symbol.equals(getString(R.string.bitSymbol))){
                logo.setImageResource(R.drawable.btc);
            }else if(token.tokenInfo.symbol.equals(getString(R.string.ethSymbol))){
                logo.setImageResource(R.drawable.eth);
            }

            BigDecimal decimalDivisor = new BigDecimal(Math.pow(10, token.tokenInfo.decimals));
            BigDecimal ethBalance = token.tokenInfo.decimals > 0
                    ? token.balance.divide(decimalDivisor) : token.balance;
            String value = ethBalance.compareTo(BigDecimal.ZERO) == 0
                    ? "0"
                    : ethBalance.toPlainString();
            this.balance.setText(value);
        } catch (Exception e) {
            fillEmpty();
        }
    }

    private void fillEmpty() {
        balance.setText(R.string.NA);
        balance.setText(R.string.minus);
    }

    @Override
    public void onClick(View v) {
        if (onTokenClickListener != null) {
            onTokenClickListener.onTokenClick(v, token);
        }
    }

    public void setOnTokenClickListener(OnTokenClickListener onTokenClickListener) {
        this.onTokenClickListener = onTokenClickListener;
    }
}
