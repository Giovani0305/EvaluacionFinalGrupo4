package com.divyamoza.assesmentdemo.base

import android.app.Application
import android.content.Context
import com.divyamoza.assesmentdemo.BuildConfig
import com.divyamoza.assesmentdemo.utils.MiApp
import timber.log.Timber
import kotlin.properties.Delegates


/**
 * Assesment demo app
 *
 * @constructor Create empty Assesment demo app
 */
class AssesmentDemoApp : Application() {

    init {
        context = this
    }

    companion object {
        var context: Context by Delegates.notNull()
            private set

        val applicationContext: Context get() { return AssesmentDemoApp.context.applicationContext }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}