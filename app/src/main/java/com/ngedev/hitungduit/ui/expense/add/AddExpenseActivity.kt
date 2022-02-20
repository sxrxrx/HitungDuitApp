package com.ngedev.hitungduit.ui.expense.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ngedev.hitungduit.R
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.databinding.ActivityAddExpenseBinding
import com.ngedev.hitungduit.helper.DatePickerFragment
import com.ngedev.hitungduit.utils.Flag
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class AddExpenseActivity : AppCompatActivity(), DatePickerFragment.DialogDateListener {

    private lateinit var binding: ActivityAddExpenseBinding
    private var dateMoney: Long = System.currentTimeMillis()
    private val addViewModel: AddExpenseViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Add Expense"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_money, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_save -> {
                val moneyExpense = binding.addEdExpense.text.toString().toInt()
                val descriptionExpense = binding.addEdExpenseDescription.text.toString().trim()
                val expense = MoneyEntity(
                    money = moneyExpense,
                    description = descriptionExpense,
                    dateMoney = dateMoney,
                    flag = Flag.EXPENSE
                )

                addViewModel.insertExpense(expense)
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