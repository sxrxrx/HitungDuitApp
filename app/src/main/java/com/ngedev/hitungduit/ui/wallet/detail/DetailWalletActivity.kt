package com.ngedev.hitungduit.ui.wallet.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ngedev.hitungduit.R
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.databinding.ActivityDetailWalletBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.ngedev.hitungduit.helper.DateConverter
import com.ngedev.hitungduit.utils.WALLET_ID

class DetailWalletActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailWalletBinding
    private val detailViewModel: WalletDetailViewModel by viewModel()
    private var moneyDetail: MoneyEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailWalletBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val id = intent.getIntExtra(WALLET_ID, 0)
        detailViewModel.getWalletById(id).observe(this) { money ->
            if (money != null) {
                binding.detailEdWallet.setText(money.money.toString())
                binding.detailEdWalletDescription.setText(money.description)
            }

            moneyDetail = money

        }
        supportActionBar?.title = DateConverter.convertMillisToString(moneyDetail?.dateMoney ?: 0)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_delete_money, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_delete -> {
                detailViewModel.deleteWallet(moneyDetail!!)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}