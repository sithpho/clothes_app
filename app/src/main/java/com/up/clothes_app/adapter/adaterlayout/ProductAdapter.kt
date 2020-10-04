package com.up.clothes_app.adapter.adaterlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.up.clothes_app.R
import com.up.clothes_app.model.Products

/**
 * @author Phor Sith
 * @Date 12/11/19
 */
class ProductAdapter(private val productList: ArrayList<Products>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product: Products = productList[position]
        holder.textProduct.text = product.itemName
        holder.imageProduct.setImageResource(product.imge)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textProduct = itemView.findViewById(R.id.txtItemName) as TextView
        val imageProduct = itemView.findViewById(R.id.imgItemImage) as ImageView
    }
}