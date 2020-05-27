package vn.dl.myapplication

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule

@Component(modules = [AndroidInjectionModule::class, TestAppModule::class, TestAppComponent.Other::class])
interface TestAppComponent {
    fun inject(app: TestApp)
    fun inject(test: ExampleInstrumentedTest)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TestApp): Builder
        fun build(): TestAppComponent
    }

    @Module
    object Other {
        @Provides
        @JvmStatic
        fun providePerson(): Person = Person("Leo", 22)
    }
}