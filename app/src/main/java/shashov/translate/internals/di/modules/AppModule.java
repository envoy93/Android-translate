package shashov.translate.internals.di.modules;

import android.app.Application;
import android.content.res.Resources;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import dagger.Module;
import dagger.Provides;
import shashov.translate.internals.mvp.presenters.PresenterCache;

import javax.inject.Singleton;

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    PresenterCache providePresenterCacheProvider() {
        return new PresenterCache();
    }

    @Provides
    @Singleton
    Bus provideEventBus() {
        return new Bus(ThreadEnforcer.MAIN);
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return this.mApplication.getResources();
    }
}
