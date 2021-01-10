package com.example.alcotools.ui.drinksList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alcotools.MainActivity
import com.example.alcotools.R
import com.example.alcotools.model.Drink

import com.like.LikeButton

class DrinkAdapter(private val context: Context, private val drinks: List<Drink>)
    : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    private var listener: OpenDrinkDetailsListener? = null

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (context is MainActivity) {
            this.listener = context
        }
        return ViewHolder(inflater.inflate(R.layout.element_drink_preview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { onOpenDrinkDetailsListenerClicked(getItem(position)) }
    }

    fun onOpenDrinkDetailsListenerClicked(drink: Drink) {
        println("DrinkAdapter - onOpenDrinkDetailsListenerClicked")
        listener?.onOpenDrinkDetailsListenerClicked(drink)
    }

    override fun getItemCount(): Int = drinks.size

    private fun getItem(position: Int): Drink = drinks[position]

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.elementDrinkPreviewImageView)
        private val title: TextView = itemView.findViewById(R.id.elementDrinkPreviewTitle)
        private val ingredientsList: TextView = itemView.findViewById(R.id.elementDrinkPreviewIngredientsList)
        private val portion: TextView = itemView.findViewById(R.id.elementDrinkPreviewPortionMl)
        private val alcohol: TextView = itemView.findViewById(R.id.elementDrinkPreviewAlcohol)
        private val description: TextView = itemView.findViewById(R.id.elementDrinkPreviewDescription)
        private val liked: LikeButton = itemView.findViewById(R.id.elementDrinkPreviewHeartButton)
        private val dose: String = "Dose: "

        fun bind(drink: Drink) {
            println("ViewHolder - bind")

            image.setImageResource(drink.image)
            title.text = drink.title
            ingredientsList.text = drink.ingredientsList
            alcohol.text = dose.plus(drink.alcoholDose.toString())
            portion.text = drink.portionMl.toString().plus(" ml")
            description.text = drink.description
            liked.isLiked = drink.liked
        }
    }
}