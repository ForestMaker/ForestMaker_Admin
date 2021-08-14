package com.forest.forestmaker.admin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InfoAdapter(private val context: Context, private val onClickItem: OnClickItem): RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    var datas = mutableListOf<ReceiptData>()

    inner class InfoViewHolder(itemview: View, onClickItem: OnClickItem): RecyclerView.ViewHolder(itemview) {

        val itemDate = itemView.findViewById<TextView>(R.id.item_date)
        val itemTime = itemView.findViewById<TextView>(R.id.item_time)
        val treeKind = itemView.findViewById<TextView>(R.id.item_tree)
        val treeLocation = itemView.findViewById<TextView>(R.id.item_location)
        val plantDate = itemView.findViewById<TextView>(R.id.item_plantDate)
        val product = itemView.findViewById<TextView>(R.id.item_product)
        val button = itemview.findViewById<ImageView>(R.id.item_button)

        fun bind(receiptData: ReceiptData) {
            itemDate.text = receiptData.date
            itemTime.text = receiptData.time
            treeKind.text = receiptData.tree
            treeLocation.text = receiptData.location
            plantDate.text = receiptData.plantDate
            product.text = receiptData.product
            button.isSelected = receiptData.status
        }

        init {
            button.setOnClickListener {
                onClickItem.onClickButton(adapterPosition)
            }
        }
    }

    interface OnClickItem{
        fun onClickButton(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false)
        return InfoViewHolder(view, onClickItem)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}