package io.github.yuweiguocn.dagger.di;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import io.github.yuweiguocn.dagger.App;

@Component(modules = {ActivityBindingModule.class,AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<App> {
}
