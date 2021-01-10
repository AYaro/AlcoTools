package com.example.alcotools.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alcotools.MainActivity
import com.example.alcotools.R

//import com.like.LikeButton

class DashElementAdapter(private val context: Context, private val drinks: List<DashElement>)
    : RecyclerView.Adapter<DashElementAdapter.ViewHolder>() {

//    private var listener: OpenElementDetailsListener? = null

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (context is MainActivity) {
//            this.listener = context
        }
        return ViewHolder(inflater.inflate(R.layout.element_of_dashboard, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { onOpenElementDetailsListenerClicked(getItem(position)) }
    }

    fun onOpenElementDetailsListenerClicked(drink: DashElement) {
        println("ElementAdapter onOpenElementDetailsListenerClicked")
//        listener?.onOpenElementDetailsListenerClicked(drink)
    }

    override fun getItemCount(): Int = drinks.size

    private fun getItem(position: Int): DashElement = drinks[position]

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.elementTitle)
        private val image: ImageView = itemView.findViewById(R.id.elementDrinkPreviewImageView)
//        private val liked: LikeButton = itemView.findViewById(R.id.elementElementPreviewHeartButton)

        fun bind(drink: DashElement) {
            println("ViewHolder - bind")
            image.setImageResource(drink.image)
            title.text = drink.title
//            liked.isLiked = drink.liked
        }
    }
}