package com.ngedev.hitungduit.ui.expense.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ngedev.hitungduit.R
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.databinding.ActivityDetailExpenseBinding
import com.ngedev.hitungduit.helper.DateConverter
import com.ngedev.hitungduit.utils.EXPENSE_ID
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailExpenseBinding
    private val detailViewModel: DetailExpenseViewModel by viewModel()
    private var expenseDetail: MoneyEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXPENSE_ID, 0)
        detailViewModel.getExpenseById(id).observe(this){
            if(it != null) {
                binding.detailEdExpense.setText(it.money.toString())
                binding.detailEdExpenseDescription.setText(it.description)
            }
            expenseDetail = it
        }

        supportActionBar?.title = DateConverter.convertMillisToString(expenseDetail?.dateMoney ?: 0)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_delete_money, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_delete -> {
                detailViewModel.deleteExpense(expenseDetail!!)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}