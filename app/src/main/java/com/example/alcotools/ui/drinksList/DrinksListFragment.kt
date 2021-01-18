package com.example.alcotools.ui.drinksList

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.alcotools.R
import com.example.alcotools.controller.DrinkViewModel
import com.example.alcotools.model.Drink
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DrinksListFragment : Fragment() {

    private val drinkViewModel: DrinkViewModel by viewModels()

    companion object {
        fun newInstance() = DrinksListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_drinks_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = DrinkAdapter(requireContext())
        val list = requireActivity().findViewById<RecyclerView>(R.id.drinksList)
        list.adapter = adapter
        drinkViewModel.allDrinks.observe(requireActivity(), object: Observer<List<Drink>> {
            override fun onChanged(@Nullable drinks: List<Drink>) {
                adapter.setDrinks(drinks)
            }
        })
        val buttonAddDrink: FloatingActionButton = requireActivity().findViewById(R.id.add_drink)
        buttonAddDrink.setOnClickListener {
            val intent = Intent(this.activity, AddNewDrinkActivity::class.java)
            startActivity(intent)
        }

        // todo do not swipe for not custom objects MINOR
        // todo make are you sure to delete window MINOR
        val swipeHandler = object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val drink: Drink = adapter.getDrink(viewHolder.adapterPosition)
                if (drink.custom) {
                    drinkViewModel.delete(drink)
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(list)
    }
}