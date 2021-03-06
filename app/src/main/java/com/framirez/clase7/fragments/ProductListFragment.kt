package com.framirez.clase7.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.framirez.clase7.R
import com.framirez.clase7.adapters.ProductListAdapter
import com.framirez.clase7.viewModels.ProductListViewModel
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment : Fragment() {
    val viewModel : ProductListViewModel by viewModels()
    private val adapter = ProductListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product_list_rcv.adapter = adapter

        viewModel.getAllProducts().observe(viewLifecycleOwner) { productList ->
            //Alimentar adapter
            adapter.products = productList
        }
    }

}