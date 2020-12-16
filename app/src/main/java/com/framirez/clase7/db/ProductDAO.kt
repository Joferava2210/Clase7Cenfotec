package com.framirez.clase7.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//TODO 2: Crear objecto de acceso a datos. (se declaran los métodos de entrada y salida de datos)
@Dao
interface ProductDAO {
    @Insert
    suspend fun insert(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<Product>>
}