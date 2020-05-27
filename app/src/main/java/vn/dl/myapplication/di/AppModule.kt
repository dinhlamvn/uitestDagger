package vn.dl.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import vn.dl.myapplication.MainActivity

@Module
interface AppModule {
    @ContributesAndroidInjector(modules = [Provider::class])
    fun activity(): MainActivity

    @Module
    object Provider {
        @Provides
        @JvmStatic
        fun provideString(): String = "This is app"
    }
}