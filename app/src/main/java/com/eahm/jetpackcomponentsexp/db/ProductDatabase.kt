package com.eahm.jetpackcomponentsexp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eahm.jetpackcomponentsexp.db.dao.ProductDao
import com.eahm.jetpackcomponentsexp.models.Product

@Database(
    entities = [(Product::class)],
    version = 1
)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao

    companion object{
        private var instance : ProductDatabase? = null

        internal fun getDatabase(context : Context) : ProductDatabase? {
            if(instance == null){
                synchronized(ProductDatabase::class.java){
                    if(instance == null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            ProductDatabase::class.java,
                            "db_product"
                        ).build()
                    }
                }
            }
            return instance
        }
    }

}