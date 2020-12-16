package com.framirez.clase7.db

import android.content.Context
import androidx.room.*

//TODO 3: Creeamos la base de datos de room (exponemos los diferentes DAO e inicializamos SINGLETON la base de datos)
@Database(entities = arrayOf(Product::class), version = 1, exportSchema = false)
public abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context) : ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}