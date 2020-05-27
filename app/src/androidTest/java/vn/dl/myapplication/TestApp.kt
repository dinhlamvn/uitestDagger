package vn.dl.myapplication

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TestApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    private lateinit var testAppComponent: TestAppComponent

    override fun onCreate() {
        testAppComponent = DaggerTestAppComponent.builder().application(this).build()
        testAppComponent.inject(this)
        super.onCreate()
    }

    fun getTestAppComponent(): TestAppComponent {
        return testAppComponent
    }
}