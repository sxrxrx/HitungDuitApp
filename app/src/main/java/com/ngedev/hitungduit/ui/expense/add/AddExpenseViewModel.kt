package com.ngedev.hitungduit.ui.expense.add

import androidx.lifecycle.ViewModel
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.repository.MoneyRepository

class AddExpenseViewModel(private val repository: MoneyRepository): ViewModel() {

    fun insertExpense(expense: MoneyEntity) {
        repository.insertExpense(expense)
    }
}