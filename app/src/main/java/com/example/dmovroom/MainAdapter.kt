package com.example.dmovroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dmovroom.database.User
import com.example.dmovroom.databinding.ItemUserBinding

class MainAdapter(private val nombres: List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }


    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.render(nombres[position])
    }

    override fun getItemCount(): Int {
        return nombres.size
    }
    class MainHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        fun render(name: User){
            binding.tvName.setText("" + name.user_id + " "+ name.user_name)
            binding.ivPerfil.setImageResource(R.drawable.icon_perf)
        }
    }

}