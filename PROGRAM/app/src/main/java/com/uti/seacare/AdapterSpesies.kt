package com.uti.seacare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterSpesies(private val dataList: ArrayList<DataClassspesies>):
    RecyclerView.Adapter<AdapterSpesies.ViewHolderClass>() {

    var onItemClick: ((DataClassspesies)-> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.item_layoutspesies,parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currenItem = dataList[position]
        holder.rvImage.setImageResource(currenItem.dataImage)
        holder.rvtitle.text = currenItem.dataTitle

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currenItem)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.image)
        val rvtitle: TextView = itemView.findViewById(R.id.title)
    }
}
