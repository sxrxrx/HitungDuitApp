package com.ngedev.hitungduit.ui.wallet.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.databinding.ActivityWalletBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.ngedev.hitungduit.ui.wallet.add.AddWalletActivity
import com.ngedev.hitungduit.utils.Flag

class WalletListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWalletBinding
    private val listViewModel: WalletListViewModel by viewModel()
    private lateinit var adapter: WalletListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWalletBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Wallet"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listViewModel.getAllWallet(Flag.WALLET).observe(this, observer)

        adapter = WalletListAdapter(this@WalletListActivity)

        binding.rvWallet.layoutManager = LinearLayoutManager(this)
        binding.rvWallet.setHasFixedSize(true)
        binding.rvWallet.adapter = adapter

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddWalletActivity::class.java))
        }
    }

    private val observer = Observer<List<MoneyEntity>> { moneyWallet ->
        if(moneyWallet != null) {
            adapter.setListWallet(moneyWallet)
        }
    }
}