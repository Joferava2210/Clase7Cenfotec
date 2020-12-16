package com.framirez.clase7.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.framirez.clase7.db.Product
import com.framirez.clase7.db.ProductDatabase
import com.framirez.clase7.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//TODO 5: Creamos el viewmodel encargado de llamar al  método para insertar a la base de datos. Este llamado tiene que hacerse en una corutina
class CreateProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    private val database: ProductDatabase = ProductDatabase.getDatabase(application)

    init {
        repository = ProductRepository(database.productDao())
    }

    fun insertProduct(product: Product) {
        //TODO 6: Recordar las extensiones del VIEWMODEL
        viewModelScope.launch{
            repository.insert(product)
        }

    }
}