package com.ngedev.hitungduit.ui.expense.list

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.databinding.ItemMoneyBinding
import com.ngedev.hitungduit.helper.DateConverter
import com.ngedev.hitungduit.helper.DiffCallBack
import com.ngedev.hitungduit.ui.expense.detail.DetailExpenseActivity
import com.ngedev.hitungduit.utils.EXPENSE_ID

class ExpenseAdapter internal constructor(private val activity: Activity):
    RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    private val listExpense = ArrayList<MoneyEntity>()

    fun setExpense(list: List<MoneyEntity>) {
        val diffCallBack = DiffCallBack(this.listExpense, list)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)

        this.listExpense.clear()
        this.listExpense.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding = ItemMoneyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = listExpense[position]
        holder.bind(expense)
    }

    override fun getItemCount(): Int = listExpense.size

    inner class ExpenseViewHolder(private val binding: ItemMoneyBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(expense: MoneyEntity) {
            with(binding) {
                tvItemDuit.text = expense.money.toString()
                tvItemDescription.text = expense.description
                tvItemDate.text = DateConverter.convertMillisToString(expense.dateMoney!!)
                cvItemWallet.setOnClickListener {
                    val intent = Intent(activity, DetailExpenseActivity::class.java)
                    intent.putExtra(EXPENSE_ID, expense.id)
                    activity.startActivity(intent)
                }
            }
        }
    }
}