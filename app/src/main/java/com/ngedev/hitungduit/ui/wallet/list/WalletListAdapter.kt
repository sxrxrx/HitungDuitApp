package com.ngedev.hitungduit.ui.wallet.list

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
import com.ngedev.hitungduit.ui.wallet.detail.DetailWalletActivity
import com.ngedev.hitungduit.utils.WALLET_ID

class WalletListAdapter internal constructor(private val activity: Activity): RecyclerView.Adapter<WalletListAdapter.WalletViewHolder>() {
    private val listWallet = ArrayList<MoneyEntity>()

    fun setListWallet(listWallet: List<MoneyEntity>) {
        val diffCallBack = DiffCallBack(this.listWallet, listWallet)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)

        this.listWallet.clear()
        this.listWallet.addAll(listWallet)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder {
        val binding = ItemMoneyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WalletViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
        holder.bind(listWallet[position])
    }

    override fun getItemCount(): Int {
        return this.listWallet.size
    }

    inner class WalletViewHolder(private val binding: ItemMoneyBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(wallet: MoneyEntity) {
            with(binding) {
                tvItemDuit.text = wallet.money.toString()
                tvItemDate.text = DateConverter.convertMillisToString(wallet.dateMoney!!)
                tvItemDescription.text = wallet.description
                cvItemWallet.setOnClickListener {
                    val intent = Intent(activity, DetailWalletActivity::class.java)
                    intent.putExtra(WALLET_ID, wallet.id)
                    activity.startActivity(intent)
                }
            }

        }

    }
}