package com.eahm.jetpackcomponentsexp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.interfaces.IProductOptions
import com.eahm.jetpackcomponentsexp.models.Product
import com.eahm.jetpackcomponentsexp.ui.BasicExample

class ProductAdapter(
    private val productCallback: IProductOptions
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    private var productList : List<Product>? = null
    private lateinit var rootView : View

    inner class ProductViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val card : CardView = view.findViewById(R.id.cardProduct)
        val cardDelete : ImageButton = view.findViewById(R.id.btnProductDelete)
        var productId : TextView = view.findViewById(R.id.tvProductID)
        var productName : TextView = view.findViewById(R.id.tvProductName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(rootView)
    }

    override fun getItemCount(): Int = if (productList == null) 0 else productList!!.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productId.text = productList!!.get(position).id.toString()
        holder.productName.text = productList!!.get(position).name
        holder.card.setOnClickListener{
            productList!![position].id.let {
                Toast.makeText(rootView.context, it, Toast.LENGTH_SHORT).show()
            }
        }
        holder.cardDelete.setOnClickListener{
            productList!![position].name.let {
                productCallback.deleteProduct(it)
            }
        }
    }

    fun setProductList(products : List<Product>){
        productList = products
        notifyDataSetChanged()
    }

}