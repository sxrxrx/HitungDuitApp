package com.ngedev.hitungduit.ui.wallet.add

import androidx.lifecycle.ViewModel
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.repository.MoneyRepository

class AddWalletViewModel(private val repository: MoneyRepository): ViewModel() {

    fun insertWallet(wallet: MoneyEntity) { repository.insertWallet(wallet) }
}