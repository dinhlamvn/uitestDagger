package vn.dl.myapplication.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import vn.dl.myapplication.App

@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent {
    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }
}