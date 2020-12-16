package com.framirez.clase7.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.framirez.clase7.db.Product
import com.framirez.clase7.db.ProductDatabase
import com.framirez.clase7.repository.ProductRepository

class ProductListViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    private val database: ProductDatabase = ProductDatabase.getDatabase(application)

    init {
        repository = ProductRepository(database.productDao())
    }

    fun getAllProducts() : LiveData<List<Product>> = repository.allProducts.asLiveData()
}