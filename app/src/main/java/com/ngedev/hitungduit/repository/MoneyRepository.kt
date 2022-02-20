package com.ngedev.hitungduit.repository

import androidx.lifecycle.LiveData
import com.ngedev.hitungduit.data.dao.MoneyDao
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.utils.executeThread


class MoneyRepository(private val mDao: MoneyDao) {

    fun getAllMoneyHistory(): LiveData<List<MoneyEntity>> = mDao.getAllMoneyHistory()

    fun getAllWallet(flag: String): LiveData<List<MoneyEntity>> = mDao.getAllWallet(flag)

    fun getAllExpense(flag: String): LiveData<List<MoneyEntity>> = mDao.getAllExpense(flag)

    fun getWalletById(id: Int): LiveData<MoneyEntity> = mDao.getWalletById(id)

    fun getExpenseById(id: Int): LiveData<MoneyEntity> = mDao.getExpenseById(id)

    fun insertWallet(wallet: MoneyEntity) = executeThread {
        mDao.insertWallet(wallet)
    }

    fun insertExpense(expense: MoneyEntity) = executeThread {
        mDao.insertWallet(expense)
    }

    fun deleteWallet(wallet: MoneyEntity) = executeThread {
        mDao.deleteWallet(wallet)
    }

    fun deleteExpense(expense: MoneyEntity) = executeThread {
        mDao.deleteExpense(expense)
    }


}