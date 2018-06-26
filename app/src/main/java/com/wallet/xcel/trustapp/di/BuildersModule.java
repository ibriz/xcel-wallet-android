package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.ui.AddTokenActivity;
import com.wallet.xcel.trustapp.ui.ConfirmationActivity;
import com.wallet.xcel.trustapp.ui.GasSettingsActivity;
import com.wallet.xcel.trustapp.ui.ImportWalletActivity;
import com.wallet.xcel.trustapp.ui.MyAddressActivity;
import com.wallet.xcel.trustapp.ui.MyWalletActivity;
import com.wallet.xcel.trustapp.ui.SendActivity;
import com.wallet.xcel.trustapp.ui.SettingsActivity;
import com.wallet.xcel.trustapp.ui.SplashActivity;
import com.wallet.xcel.trustapp.ui.TokensActivity;
import com.wallet.xcel.trustapp.ui.TransactionDetailActivity;
import com.wallet.xcel.trustapp.ui.TransactionsActivity;
import com.wallet.xcel.trustapp.ui.WalletsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {
	@ActivityScope
	@ContributesAndroidInjector(modules = SplashModule.class)
	abstract SplashActivity bindSplashModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = AccountsManageModule.class)
	abstract WalletsActivity bindManageWalletsModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = ImportModule.class)
	abstract ImportWalletActivity bindImportWalletModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = TransactionsModule.class)
	abstract TransactionsActivity bindTransactionsModule();

    @ActivityScope
    @ContributesAndroidInjector(modules = TransactionDetailModule.class)
    abstract TransactionDetailActivity bindTransactionDetailModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = SettingsModule.class)
	abstract SettingsActivity bindSettingsModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = SendModule.class)
	abstract SendActivity bindSendModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = ConfirmationModule.class)
	abstract ConfirmationActivity bindConfirmationModule();
    @ContributesAndroidInjector
	abstract MyAddressActivity bindMyAddressModule();

	@ActivityScope
    @ContributesAndroidInjector(modules = {TokensModule.class, AddTokenModule.class})
	abstract TokensActivity bindTokensModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = GasSettingsModule.class)
	abstract GasSettingsActivity bindGasSettingsModule();

	@ActivityScope
    @ContributesAndroidInjector(modules = AddTokenModule.class)
	abstract AddTokenActivity bindAddTokenActivity();
}
