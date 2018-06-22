package com.wallet.xcel.trustapp.di;

import com.wallet.xcel.trustapp.ui.SettingsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface SettingsModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {SettingsFragmentModule.class})
    SettingsFragment settingsFragment();
}
