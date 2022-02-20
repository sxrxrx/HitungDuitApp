package com.ngedev.hitungduit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ngedev.hitungduit.data.dao.MoneyDao
import com.ngedev.hitungduit.data.model.MoneyEntity

@Database(entities = [MoneyEntity::class], version = 1)
abstract class MoneyRoomDatabase : RoomDatabase() {
    abstract fun dao(): MoneyDao
}