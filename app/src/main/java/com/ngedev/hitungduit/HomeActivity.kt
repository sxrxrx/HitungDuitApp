package com.ngedev.hitungduit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngedev.hitungduit.databinding.ActivityHomeBinding
import com.ngedev.hitungduit.ui.expense.list.ExpenseListActivity
import com.ngedev.hitungduit.ui.history.HistoryActivity
import com.ngedev.hitungduit.ui.settings.SettingsActivity
import com.ngedev.hitungduit.ui.wallet.list.WalletListActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgvHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.imgvSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        binding.imgvWallet.setOnClickListener {
            startActivity(Intent(this, WalletListActivity::class.java))
        }

        binding.imgvExpense.setOnClickListener {
            startActivity(Intent(this, ExpenseListActivity::class.java))
        }
    }
}