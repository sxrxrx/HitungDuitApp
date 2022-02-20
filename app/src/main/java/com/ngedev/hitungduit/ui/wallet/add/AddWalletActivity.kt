package com.ngedev.hitungduit.ui.wallet.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.ngedev.hitungduit.R
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.databinding.ActivityAddWalletBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.ngedev.hitungduit.helper.DatePickerFragment
import com.ngedev.hitungduit.utils.Flag
import java.text.SimpleDateFormat
import java.util.*

class AddWalletActivity : AppCompatActivity(), DatePickerFragment.DialogDateListener {
    private lateinit var binding: ActivityAddWalletBinding
    private val addViewModel: AddWalletViewModel by viewModel()
    private var dateMoney: Long = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddWalletBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Add Wallet"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_money, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when (item.itemId) {
            R.id.action_save -> {
                val money = binding.addEdWallet.text.toString().toInt()
                val description = binding.addEdWalletDescription.text.toString().trim()

                addViewModel.insertWallet(
                    MoneyEntity(
                        money = money,
                        description = description,
                        dateMoney = dateMoney,
                        flag = Flag.WALLET
                    )
                )

                finish()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showDatePicker(view: View) {
        val dialogFragment = DatePickerFragment()
        dialogFragment.show(supportFragmentManager, "date picker")
    }

    override fun onDialogDateSet(tag: String?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        binding.tvDate.text = dateFormat.format(calendar.time)

        dateMoney = calendar.timeInMillis
    }


}