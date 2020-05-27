package vn.dl.myapplication

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
interface TestAppModule {

    @ContributesAndroidInjector(modules = [Provider::class])
    fun activity(): MainActivity

    @Module
    object Provider {
        @Provides
        @JvmStatic
        fun provideString(): String = "This is test."
    }
}