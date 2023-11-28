package com.example.triviamania.Adapters

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.triviamania.Models.StagesModel
import com.example.triviamania.R
import com.example.triviamania.databinding.ItemsRvBinding

class StagesAdapter(
    var context: Context?,
    var list: MutableList<StagesModel>?,
    val destination: Int
    ): RecyclerView.Adapter<StagesAdapter.ViewHolder>() {

    var mediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items_rv, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list!![position]
        holder.binding.stagesNumbers.text = model.stageName
        val bundle = bundleOf("Key" to model.stageName)
        holder.itemView.setOnClickListener {
            mediaPlayer = MediaPlayer.create(context,R.raw.mouse_click_sound_effect)
            mediaPlayer?.start()
            it.findNavController().navigate(destination, bundle)
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