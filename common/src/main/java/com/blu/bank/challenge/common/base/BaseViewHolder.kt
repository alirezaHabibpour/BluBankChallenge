package com.blu.bank.challenge.common.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in T>(itemView: View, parent: ViewGroup) : RecyclerView.ViewHolder(itemView) {

    internal var clickListener: (Any) -> Unit = { _ -> }

    abstract fun  bind(item: T, clickListener: (Any) -> Unit)
}