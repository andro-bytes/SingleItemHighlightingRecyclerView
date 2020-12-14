package com.example.singleitemhighlightingrecyclerview

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ItemHolder>() {

    var selectedPosition = -1

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mainCard = itemView.findViewById<CardView>(R.id.mainCard)

        init {
            itemView.setOnClickListener {
                selectedPosition = adapterPosition
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_rv_items, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        if (selectedPosition == position) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                holder.mainCard.setCardBackgroundColor(
                    holder.mainCard.context.resources.getColor(
                        R.color.teal_700,
                        null
                    )
                )
            } else {
                holder.mainCard.setCardBackgroundColor(holder.mainCard.context.resources.getColor(R.color.teal_700))
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                holder.mainCard.setCardBackgroundColor(
                    holder.mainCard.context.resources.getColor(
                        R.color.white,
                        null
                    )
                )
            } else {
                holder.mainCard.setCardBackgroundColor(holder.mainCard.context.resources.getColor(R.color.white))
            }
        }
    }


}