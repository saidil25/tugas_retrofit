package com.example.tugas_retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_retrofit.databinding.ListItemBinding
import com.example.tugas_retrofit.model.ListData
import com.squareup.picasso.Picasso

class ListModelAdapter(private val list: List<ListData>) :
    RecyclerView.Adapter<ListModelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.binding.id.text = item.id.toString()
        holder.binding.deskripsi.text = item.title
        Picasso.get().load(item.image).into(holder.binding.gambar)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}
