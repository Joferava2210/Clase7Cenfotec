package com.framirez.clase7.repository

import com.framirez.clase7.db.Product
import com.framirez.clase7.db.ProductDAO
import kotlinx.coroutines.flow.Flow

// TODO 4: Crear repositorio (encargado de llamar al servidor y sincronizar los datos con la base de datos)
// En este caso solo utlizamos base de datos
class ProductRepository(private val productDAO: ProductDAO) {
    suspend fun insert(product: Product) {
        productDAO.insert(product)
    }

    val allProducts : Flow<List<Product>> = productDAO.getAllProducts()

}