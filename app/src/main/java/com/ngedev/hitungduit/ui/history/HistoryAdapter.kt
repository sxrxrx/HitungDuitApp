package com.ngedev.hitungduit.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ngedev.hitungduit.R
import com.ngedev.hitungduit.data.model.MoneyEntity
import com.ngedev.hitungduit.databinding.ItemHistoryBinding
import com.ngedev.hitungduit.helper.DateConverter
import com.ngedev.hitungduit.helper.DiffCallBack
import com.ngedev.hitungduit.utils.Flag

class HistoryAdapter :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val listHistory = ArrayList<MoneyEntity>()

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: MoneyEntity) {
            with(binding) {
                tvItemDuit.text = history.money.toString()
                tvItemDescription.text = history.description
                tvItemDate.text = DateConverter.convertMillisToString(history.dateMoney!!)
                when (history.flag) {
                    Flag.WALLET -> {
                        Glide.with(itemView.context)
                            .load(R.drawable.ic_baseline_account_balance_wallet_24).into(imgFlag)
                    }
                    Flag.EXPENSE -> {
                        Glide.with(itemView.context).load(R.drawable.ic_baseline_money_24)
                            .into(imgFlag)
                    }
                    else -> throw Throwable("Unknown flag: ${history.flag}")
                }
            }
        }
    }

    fun setListHistory(list: List<MoneyEntity>) {
        val diffCallBack = DiffCallBack(listHistory, list)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)

        this.listHistory.clear()
        this.listHistory.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = listHistory[position]
        holder.bind(history)
    }

    override fun getItemCount(): Int = listHistory.size
}