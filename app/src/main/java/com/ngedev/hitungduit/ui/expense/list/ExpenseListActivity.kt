package com.ngedev.hitungduit.ui.expense.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngedev.hitungduit.databinding.ActivityExpenseBinding
import com.ngedev.hitungduit.ui.expense.add.AddExpenseActivity
import com.ngedev.hitungduit.utils.Flag
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExpenseListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpenseBinding
    private val listViewModel: ExpenseListViewModel by viewModel()
    private lateinit var adapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Expense"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter = ExpenseAdapter(this)

        binding.rvExpense.layoutManager = LinearLayoutManager(this)
        binding.rvExpense.setHasFixedSize(true)
        binding.rvExpense.adapter = adapter

        listViewModel.getAllExpense(Flag.EXPENSE).observe(this) {
            adapter.setExpense(it)
        }

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }
    }
}