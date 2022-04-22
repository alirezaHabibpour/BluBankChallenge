package com.blu.bank.challenge.common.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


private  lateinit  var INSTANCE: RoomDatabase
private lateinit   var CURRENT_DATABASE_NAME: String


fun  <T :RoomDatabase>getDatabase(context: Context, database:Class<T> ,databaseName:String): T {
    synchronized(RoomDatabase::class) {
        if (!::INSTANCE.isInitialized || !::CURRENT_DATABASE_NAME.isInitialized || !CURRENT_DATABASE_NAME.contentEquals(databaseName) ) {
            INSTANCE = Room
                    .databaseBuilder(
                            context.applicationContext,
                            database,
                            databaseName
                    )
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
    return INSTANCE as T
}
