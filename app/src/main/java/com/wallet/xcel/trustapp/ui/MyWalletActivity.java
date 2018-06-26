package com.wallet.xcel.trustapp.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wallet.xcel.trustapp.R;
import com.wallet.xcel.trustapp.entity.ErrorEnvelope;
import com.wallet.xcel.trustapp.entity.Token;
import com.wallet.xcel.trustapp.ui.widget.adapter.TokensAdapter;
import com.wallet.xcel.trustapp.util.AddTokenHelper;
import com.wallet.xcel.trustapp.viewmodel.AddTokenViewModel;
import com.wallet.xcel.trustapp.viewmodel.AddTokenViewModelFactory;
import com.wallet.xcel.trustapp.viewmodel.TokensViewModel;
import com.wallet.xcel.trustapp.viewmodel.TokensViewModelFactory;
import com.wallet.xcel.trustapp.widget.SystemView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

import static com.wallet.xcel.trustapp.C.Key.WALLET;

public class MyWalletActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_wallet);

        SystemView systemView = findViewById(R.id.system_view);
        systemView.setVisibility(View.GONE);

        toolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                //viewModel.showAddToken(this);
            } break;
            case android.R.id.home: {
                //viewModel.showTransactions(this, true);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //viewModel.showTransactions(this, true);
    }

    private void onTokenClick(View view, Token token) {
        Context context = view.getContext();
        //viewModel.showSendToken(context, token.tokenInfo.address, token.tokenInfo.symbol, token.tokenInfo.decimals);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //viewModel.prepare();
    }

    private void onTokens(Token[] tokens) {
        if (tokens == null || tokens.length == 0) {

        }
    }

    private void onError(ErrorEnvelope errorEnvelope) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.try_again: {
            } break;
        }
    }
}
