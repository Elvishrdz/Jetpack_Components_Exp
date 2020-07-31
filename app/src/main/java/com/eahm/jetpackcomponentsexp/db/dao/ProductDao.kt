package com.eahm.jetpackcomponentsexp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eahm.jetpackcomponentsexp.models.Product

@Dao
interface ProductDao {

    /**
     * Create the given product object in the "products" table (Add).
     *
     * @param product The new product to be inserted
     */
    @Insert
    fun insertProduct(product : Product)

    /**
     * Read and return all the elements in the "products" table
     *
     * @return A List of products wrapped by a LiveData object to observe every change in the table values.
     */
    @Query("SELECT * FROM products")
    fun getAllProducts() : LiveData<List<Product>>

    /**
     * Update the values of a specific product
     *
     * @param id The unique id of the product to update.
     * @param name The new value of the "name" property.
     */
    @Query("UPDATE products SET productName = :name WHERE productId == :id")
    fun updateProduct(id:Int, name :String)

    /**
     * Find a product from the "products" table
     *
     * @param name The name of the product
     * @return A list of products with all the coincidences
     */
    @Query("SELECT * FROM products WHERE productName == :name")
    fun findProduct(name : String) : List<Product>

    /**
     * Delete a product from the "products" table
     *
     * @param name The name of the product
     * @return An integer number with the amount of deleted products
     */
    @Query("DELETE FROM products WHERE productName == :name")
    fun deleteProduct(name : String)

}