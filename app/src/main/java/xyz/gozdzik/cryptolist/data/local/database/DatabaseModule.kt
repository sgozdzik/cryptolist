package xyz.gozdzik.cryptolist.data.local.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context,
    ) = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        APP_DATABASE_NAME
    ).build()

    @Provides
    fun provideCurrencyInfoDao(appDatabase: AppDatabase) =
        appDatabase.currencyInfoDao()

}