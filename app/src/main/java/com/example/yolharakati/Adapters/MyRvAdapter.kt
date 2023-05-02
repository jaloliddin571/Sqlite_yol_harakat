package com.example.yolharakati.Adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yolharakati.Models.Label
import com.example.yolharakati.R
import com.example.yolharakati.databinding.ItemRvBinding

class MyRvAdapter(val list: ArrayList<Label>,val rvClick:RvClick):RecyclerView.Adapter<MyRvAdapter.Vh>() {

inner class Vh(val itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){

    fun onBind(label: Label){
        itemRvBinding.rvTvText.text=label.name
        itemRvBinding.rvItemImage.setImageURI(Uri.parse(label.img))


        list.forEach{
            if (it.like=="1"){
                itemRvBinding.like.setImageResource(R.drawable.baseline_heart_broken_24)
            }else if (it.like=="0"){
                itemRvBinding.like.setImageResource(R.drawable.likee11)
            }
        }

        itemRvBinding.delete.setOnClickListener {
            rvClick.deleteClick(label)
        }
        itemRvBinding.edit.setOnClickListener {
            rvClick.editClick(label)
        }
        itemRvBinding.cardView.setOnClickListener {
            rvClick.itemClick(label)
        }
        itemRvBinding.like.setOnClickListener {
            rvClick.likeClick(label)
            if (label.like=="1"){
                itemRvBinding.like.setImageResource(R.drawable.baseline_heart_broken_24)
            }else if (label.like=="0"){
                itemRvBinding.like.setImageResource(R.drawable.likee11)
            }
        }
    }
}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
     return  list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
    interface RvClick {
        fun editClick(label: Label)
        fun deleteClick(label: Label)
        fun itemClick(label: Label)
        fun likeClick(label: Label)

    }
}
