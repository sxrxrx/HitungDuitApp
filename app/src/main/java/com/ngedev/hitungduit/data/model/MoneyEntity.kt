package com.ngedev.hitungduit.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MoneyEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "money")
    var money: Int? = 0,

    @ColumnInfo(name = "dateMoney")
    var dateMoney: Long? = 0,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "flag")
    var flag: String? = null
)
