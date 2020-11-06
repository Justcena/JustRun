package ir.cena.justrun.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.cena.justrun.other.Constants.RUNNING_DATABASE_NAME
import ir.cena.justrun.db.RunningDatabase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRunningDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, RunningDatabase::class.java, RUNNING_DATABASE_NAME).build()


    @Provides
    @Singleton
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()
}