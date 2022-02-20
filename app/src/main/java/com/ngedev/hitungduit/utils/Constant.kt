package com.ngedev.hitungduit.utils

import java.util.concurrent.Executors

const val WALLET_ID = "WALLET_ID"
const val EXPENSE_ID = "EXPENSE_ID"

private val single_executor = Executors.newSingleThreadExecutor()

fun executeThread(f: () -> Unit) {
    single_executor.execute(f)
}