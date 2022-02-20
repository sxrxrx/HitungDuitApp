package com.ngedev.hitungduit.ui.wallet.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.repository.MoneyRepository

class WalletListViewModel(private val repository: MoneyRepository): ViewModel() {

    fun getAllWallet(flag: String): LiveData<List<MoneyEntity>> = repository.getAllWallet(flag)

}