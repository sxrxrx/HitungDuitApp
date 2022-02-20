package com.ngedev.hitungduit.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ngedev.hitungduit.data.model.MoneyEntity

@Dao
interface MoneyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWallet(wallet: MoneyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpense(expense: MoneyEntity)

    @Delete
    fun deleteWallet(wallet: MoneyEntity)

    @Delete
    fun deleteExpense(expense: MoneyEntity)

    @Query("SELECT * FROM moneyentity ORDER BY id ASC")
    fun getAllMoneyHistory(): LiveData<List<MoneyEntity>>

    @Query("SELECT * FROM moneyentity WHERE flag = :walletFlag")
    fun getAllWallet(walletFlag: String): LiveData<List<MoneyEntity>>

    @Query("SELECT * FROM moneyentity WHERE id = :walletId")
    fun getWalletById(walletId: Int): LiveData<MoneyEntity>

    @Query("SELECT * FROM moneyentity WHERE flag = :expenseFlag")
    fun getAllExpense(expenseFlag: String): LiveData<List<MoneyEntity>>

    @Query("SELECT * FROM moneyentity WHERE id = :expenseId")
    fun getExpenseById(expenseId: Int): LiveData<MoneyEntity>
}