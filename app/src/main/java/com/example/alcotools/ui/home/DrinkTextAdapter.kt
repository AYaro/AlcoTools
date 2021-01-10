package com.example.alcotools.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alcotools.MainActivity
import com.example.alcotools.R
import com.example.alcotools.model.Drink
import com.example.alcotools.ui.drinksList.OpenDrinkDetailsListener

//import com.like.LikeButton

class DrinkTextAdapter(private val context: Context, private val drinks: List<Drink>)
    : RecyclerView.Adapter<DrinkTextAdapter.ViewHolder>() {

    private var listener: OpenDrinkDetailsListener? = null

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (context is MainActivity) {
            this.listener = context
        }
        return ViewHolder(inflater.inflate(R.layout.home_drink_choice, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { onOpenDrinkDetailsListenerClicked(getItem(position)) }
    }

    fun onOpenDrinkDetailsListenerClicked(drink: Drink) {
        println("DrinkAdapter onOpenDrinkDetailsListenerClicked")
        listener?.onOpenDrinkDetailsListenerClicked(drink)
    }

    override fun getItemCount(): Int = drinks.size

    private fun getItem(position: Int): Drink = drinks[position]

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.elementDrinkPreviewTitle)
//        private val liked: LikeButton = itemView.findViewById(R.id.elementDrinkPreviewHeartButton)

        fun bind(drink: Drink) {
            println("ViewHolder - bind")

            title.text = drink.title
//            liked.isLiked = drink.liked
        }
    }
}