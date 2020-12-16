package com.framirez.clase7.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.framirez.clase7.R
import com.framirez.clase7.db.Product
import com.framirez.clase7.viewModels.CreateProductViewModel
import kotlinx.android.synthetic.main.fragment_create_product.*
import java.util.*

class CreateProductFragment : Fragment() {

    val viewModel: CreateProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_button.setOnClickListener {
            viewModel.insertProduct(Product(UUID.randomUUID().toString(), name_product.text.toString(), quantity_product.text.toString().toInt()))
        }

    }
}