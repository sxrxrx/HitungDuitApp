package com.ngedev.hitungduit.ui.expense.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.repository.MoneyRepository

class ExpenseListViewModel(private val repository: MoneyRepository): ViewModel() {

    fun getAllExpense(flag: String): LiveData<List<MoneyEntity>> = repository.getAllExpense(flag)
}