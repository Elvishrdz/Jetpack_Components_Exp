package com.eahm.jetpackcomponentsexp.viewmodels

import android.app.Application 
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eahm.jetpackcomponentsexp.db.repository.ProductRepository
import com.eahm.jetpackcomponentsexp.models.Product

/**
 * BasicExample Activity's ViewModel
 *
 * - Extends AndroidViewModel(application) instead of ViewModel()
 *
 * @param application A reference of the application object.
 */
class BasicExampleViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository : ProductRepository = ProductRepository(application)

    private val allProducts : LiveData<List<Product>>?
    private val searchResults : MutableLiveData<List<Product>>

    init {
        allProducts = repository.allProducts
        searchResults = repository.searchResults
    }

    fun insertProduct(product: Product) = repository.insertProduct(product)
    fun getAllProducts() : LiveData<List<Product>>? = allProducts
    fun findProduct(productName : String) = repository.findProduct(productName)
    fun deleteProduct(productName : String) = repository.deleteProduct(productName)

}