package com.eahm.jetpackcomponentsexp.db.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eahm.jetpackcomponentsexp.db.ProductDatabase
import com.eahm.jetpackcomponentsexp.db.dao.ProductDao
import com.eahm.jetpackcomponentsexp.models.Product

/**
 * Repository of Products
 *
 * @param application A reference to the application
 */
class ProductRepository (application : Application){

    //region variables
    private var productDao : ProductDao?
    /**
     * Receive all the results from a search operation.
     */
    val searchResults = MutableLiveData<List<Product>>()
    val allProducts : LiveData<List<Product>>? // Observe changes in all the "products" table (See init{})
    //endregion variables

    //region defining the async operations

    //region handling search results
    /**
     * Called by the query Async Task when is completed to provide the results of the search.
     *
     * @param results A list with the products returned by the database
     */
    private fun asyncFinished(results : List<Product>){
        searchResults.value = results
    }

    private class QueryAsyncTask constructor(val asyncProductDao : ProductDao?) : AsyncTask<String, Void, List<Product>>() {

        var delegate : ProductRepository? = null

        override fun doInBackground(vararg params: String): List<Product>? {
            return asyncProductDao?.findProduct(params[0])
        }

        override fun onPostExecute(result: List<Product>) {
            delegate?.asyncFinished(result)
        }

    }
    //endregion handling search results

    private class InsertAsyncTask constructor(val asyncProductDao: ProductDao?) : AsyncTask<Product, Void, Void>() {

        override fun doInBackground(vararg params: Product): Void? {
            asyncProductDao?.insertProduct(params[0])
            return null
        }

    }

    private class DeleteAsyncTask constructor(val asyncProductDao : ProductDao?) : AsyncTask<String, Void, Void>(){

        override fun doInBackground(vararg params: String): Void? {
            asyncProductDao?.deleteProduct(params[0])
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }

    }

    //endregion defining the async operations

    //region obtaining the DAO from the DB instance

    init {
        /* Now we need to provide public methods to allow other classes to work with the database.
        To do this, we need to obtain the DAO reference from our database instance:*/
        val db : ProductDatabase? = ProductDatabase.getDatabase(application)
        productDao = db?.productDao()
        allProducts = productDao?.getAllProducts()
    }
    //endregion obtaining the DAO from the DB instance

    //region declaring the public methods

    /**
     * Run the operation to create the given product object in the "products" table (Add).
     *
     * @param product The new product to be inserted
     */
    fun insertProduct(product : Product){
        val task = InsertAsyncTask(productDao)
        task.execute(product)
    }

    /**
     * Run the operation to find a product from the "products" table
     *
     * @param productName The name of the product
     */
    fun findProduct(productName : String){
        val task = QueryAsyncTask(productDao)
        task.delegate = this // Assigned so the asyncFinished() can be called after the search completes.
        task.execute(productName)
    }

    /**
     * Run the operation to delete a product from the "products" table
     *
     * @param productName The name of the product
     * @return An integer number with the amount of deleted products
     */
    fun deleteProduct(productName : String) {
        val task = DeleteAsyncTask(productDao)
        task.execute(productName)
    }

    //endregion declaring the public methods

}