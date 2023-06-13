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
    private var myFavoriteDrinkDB: FavoriteDrinkDatabase? = null

    @Singleton
    @Provides
    fun init(@ApplicationContext context: Context): FavoriteDrinkDatabase {
        return myFavoriteDrinkDB ?: synchronized(this) {
            myFavoriteDrinkDB ?: Room.databaseBuilder(
                context,
                FavoriteDrinkDatabase::class.java,
                "myFavoriteDrink-database"
            ).build().also { myFavoriteDrinkDB = it }
        }
    }

    @Singleton
    @Provides
    fun provideFavoriteDrinkDao(favoriteDrinkDatabase: FavoriteDrinkDatabase): FavoriteDrinkDao {
        return favoriteDrinkDatabase.favoriteDrinkDao()
    }
}