package com.ngedev.hitungduit.di

import androidx.room.Room
import com.ngedev.hitungduit.data.database.MoneyRoomDatabase
import com.ngedev.hitungduit.repository.MoneyRepository
import com.ngedev.hitungduit.ui.expense.add.AddExpenseViewModel
import com.ngedev.hitungduit.ui.expense.detail.DetailExpenseViewModel
import com.ngedev.hitungduit.ui.expense.list.ExpenseListViewModel
import com.ngedev.hitungduit.ui.history.HistoryViewModel
import com.ngedev.hitungduit.ui.wallet.add.AddWalletViewModel
import com.ngedev.hitungduit.ui.wallet.detail.WalletDetailViewModel
import com.ngedev.hitungduit.ui.wallet.list.WalletListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    factory { get<MoneyRoomDatabase>().dao() }
    single {
        Room.databaseBuilder(androidContext(), MoneyRoomDatabase::class.java, "money_entity.db")
            .build()
    }
}

val repositoryModule = module {
    single { MoneyRepository(get()) }
}

val viewModelModule = module {
    viewModel { AddExpenseViewModel(get()) }
    viewModel { DetailExpenseViewModel(get()) }
    viewModel { ExpenseListViewModel(get()) }
    viewModel { HistoryViewModel(get()) }
    viewModel { AddWalletViewModel(get()) }
    viewModel { WalletDetailViewModel(get()) }
    viewModel { WalletListViewModel(get()) }
}