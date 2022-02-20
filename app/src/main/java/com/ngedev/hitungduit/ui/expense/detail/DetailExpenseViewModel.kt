package com.ngedev.hitungduit.ui.expense.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.repository.MoneyRepository

class DetailExpenseViewModel(private val repository: MoneyRepository): ViewModel() {

    fun getExpenseById(id: Int): LiveData<MoneyEntity> = repository.getExpenseById(id)
    fun deleteExpense(expense: MoneyEntity) { repository.deleteExpense(expense) }
}