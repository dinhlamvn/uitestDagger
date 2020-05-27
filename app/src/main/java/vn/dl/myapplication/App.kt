package vn.dl.myapplication

import android.app.Application
import android.util.Log
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import vn.dl.myapplication.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @set:Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        DaggerAppComponent.builder().application(this).build().inject(this)
        Log.d("DinhLam", "App create")
        super.onCreate()
    }
}