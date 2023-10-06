package com.example.triviamania.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.triviamania.Models.StagesModel
import com.example.triviamania.R
import com.example.triviamania.databinding.ItemsRvBinding

class StagesAdapter(var context: Context?, var list: ArrayList<StagesModel>?) : RecyclerView.Adapter<StagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items_rv, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list!![position]
        holder.binding.stagesNumbers.text = model.stageName

        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(R.id.game_Fragment)
        }

    }

    override fun getItemCount() = list!!.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemsRvBinding
        init {
            binding = ItemsRvBinding.bind(itemView)
        }

    }
}