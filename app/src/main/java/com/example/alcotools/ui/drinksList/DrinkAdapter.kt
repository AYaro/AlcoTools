package com.example.alcotools.ui.drinksList

import android.content.Context
import android.net.Uri
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

class DrinkAdapter(private val context: Context) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    private var listener: OpenDrinkDetailsListener? = null

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var drinks: List<Drink> = emptyList()

    fun setDrinks(drinks: List<Drink>) {
        this.drinks = drinks
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (context is MainActivity) {
            this.listener = context
        }
        return ViewHolder(inflater.inflate(R.layout.element_drink_preview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getDrink(position))
        holder.itemView.setOnClickListener { onOpenDrinkDetailsListenerClicked(getDrink(position)) }
    }

    fun onOpenDrinkDetailsListenerClicked(drink: Drink) {
        println("DrinkAdapter - onOpenDrinkDetailsListenerClicked")
        listener?.onOpenDrinkDetailsListenerClicked(drink)
    }

    override fun getItemCount(): Int = drinks.size

    fun getDrink(position: Int): Drink = drinks[position]

    class ViewHolder(drinkView: View): RecyclerView.ViewHolder(drinkView) {
        private val image: ImageView = drinkView.findViewById(R.id.elementDrinkPreviewImageView)
        private val title: TextView = drinkView.findViewById(R.id.elementDrinkPreviewTitle)
        private val ingredientsList: TextView = drinkView.findViewById(R.id.elementDrinkPreviewIngredientsList)
        private val portion: TextView = drinkView.findViewById(R.id.elementDrinkPreviewPortionMl)
        private val alcohol: TextView = drinkView.findViewById(R.id.elementDrinkPreviewAlcohol)
        private val description: TextView = drinkView.findViewById(R.id.elementDrinkPreviewDescription)
        private val liked: LikeButton = drinkView.findViewById(R.id.elementDrinkPreviewHeartButton)
        private val dose: String = "Dose: "

        fun bind(drink: Drink) {
            println("ViewHolder - bind")
            if (drink.custom) {
                image.setImageURI(Uri.parse(drink.imageUri))
            } else {
                image.setImageResource(drink.image!!)
            }
            title.text = drink.title
            ingredientsList.text = drink.ingredientsList
            alcohol.text = dose.plus(drink.alcoholDose.toString())
            portion.text = drink.portionMl.toString().plus(" ml")
            description.text = drink.description
            liked.isLiked = drink.liked
        }
    }
}