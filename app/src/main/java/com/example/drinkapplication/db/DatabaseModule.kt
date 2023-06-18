package com.example.drinkapplication.db

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
object DatabaseModule {
    //var favoriteDrinkDao: FavoriteDrinkDao?=null
    private var myFavoriteDrinkDB: AppDataBase? = null

    @Singleton
    @Provides
    fun init(@ApplicationContext context: Context): AppDataBase {
        return myFavoriteDrinkDB ?: synchronized(this) {
            myFavoriteDrinkDB ?: Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "myFavoriteDrink-database"
            ).build().also { myFavoriteDrinkDB = it }
        }
    }

    @Singleton
    @Provides
    fun provideFavoriteDrinkDao(appDataBase: AppDataBase): FavoriteDrinkDao {
        return appDataBase.favoriteDrinkDao()
    }
}