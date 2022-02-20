package com.ngedev.hitungduit.helper

import androidx.recyclerview.widget.DiffUtil
import com.ngedev.hitungduit.data.model.MoneyEntity

class DiffCallBack(private val mOldList: List<MoneyEntity>, private val mNewList: List<MoneyEntity>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldList.size
    }

    override fun getNewListSize(): Int {
        return mNewList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldList[oldItemPosition].id == mNewList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMoney = mOldList[oldItemPosition]
        val newMoney = mNewList[newItemPosition]
        return oldMoney.money == newMoney.money && oldMoney.description == newMoney.description
    }
}