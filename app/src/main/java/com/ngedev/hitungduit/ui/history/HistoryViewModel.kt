package com.ngedev.hitungduit.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.repository.MoneyRepository

class HistoryViewModel(private val repository: MoneyRepository): ViewModel() {

    fun getAllMoneyHistory(): LiveData<List<MoneyEntity>> {
        return repository.getAllMoneyHistory()
    }
}