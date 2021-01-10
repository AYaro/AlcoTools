package com.example.alcotools.ui.drinksList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.alcotools.R
import com.example.alcotools.controller.DataStorage
//import com.example.alcotools.controller.DrinkViewModel
import com.example.alcotools.model.Drink

class DrinksListFragment : Fragment() {

//    private val drinkViewModel: DrinkViewModel by viewModels()

    companion object {
        fun newInstance() = DrinksListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_drinks_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val drinks = DataStorage.getDrinksList()
        val adapter = DrinkAdapter(this.requireContext(), drinks)
        val list = this.activity?.findViewById<RecyclerView>(R.id.drinksList)
        list?.adapter = adapter
        val decoration = DividerItemDecoration(this.requireContext(), DividerItemDecoration.HORIZONTAL)
        decoration.setDrawable(ContextCompat.getDrawable(this.requireContext(), R.color.purple_700)!!)
        list?.addItemDecoration(decoration)

//        drinkViewModel.allItems.observe(this, object: Observer<List<Drink>> {
//            override fun onChanged(@Nullable drinks: List<Drink>) {
//                adapter.setDrinks(drinks)
//            }
//        })

        // todo onclick intent add toggle button
    }
}