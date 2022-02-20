package com.ngedev.hitungduit.ui.wallet.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.repository.MoneyRepository

class WalletDetailViewModel(private val repository: MoneyRepository): ViewModel() {

    fun getWalletById(id: Int): LiveData<MoneyEntity> {
        return repository.getWalletById(id)
    }

    fun deleteWallet(wallet: MoneyEntity) {
        repository.deleteWallet(wallet)
    }
}