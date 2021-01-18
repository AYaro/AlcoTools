package com.example.alcotools.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.alcotools.R
import com.example.alcotools.controller.DataStorage

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val drinks = DataStorage.getDrinksList()
        val adapter = DrinkTextAdapter(this.requireContext(), drinks)
        val list = this.activity?.findViewById<RecyclerView>(R.id.recycler)
        list?.adapter = adapter
        val decoration = DividerItemDecoration(this.requireContext(), DividerItemDecoration.HORIZONTAL)
        decoration.setDrawable(ContextCompat.getDrawable(this.requireContext(), R.color.purple_700)!!)
        list?.addItemDecoration(decoration)
        // todo onclick intent add toggle button
        val home_drink_button = this.activity?.findViewById<AppCompatImageButton>(R.id.home_drink_button)
        val progressBar = this.requireActivity().findViewById<ProgressBar>(R.id.progressBar)
        home_drink_button?.setOnClickListener { v: View? -> run {
            progressBar.progress = progressBar.progress + 5;

            if (progressBar.progress >= 100) {
                Toast.makeText(this.requireContext(), "You drunk as f@%k", Toast.LENGTH_SHORT).show()
            }
        } }
    }
}