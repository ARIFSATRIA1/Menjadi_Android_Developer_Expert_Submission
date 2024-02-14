package com.example.expertsubs.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.expertsubs.core.R
import com.example.expertsubs.core.domain.model.Users
import com.example.expertsubs.core.databinding.ItemListUserBinding


class UserAdapter: RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    private var listData = ArrayList<Users>()
    var onItemCLick:((Users) -> Unit)? = null

    fun setData(newListData: List<Users>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListUserBinding.bind(itemView)
        fun bind(data: Users) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(imgView)
                userTv.text= data.username
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemCLick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false))


    override fun onBindViewHolder(holder: UserAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size
}