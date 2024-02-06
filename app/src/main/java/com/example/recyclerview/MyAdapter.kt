package com.example.recyclerview

import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val newsList: ArrayList<Items>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var editTextValues: SparseArray<String> = SparseArray()

    var index = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        Log.d("RecyclerView", "Create view called for view type = $viewType and index =  ${index++}")
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(newsList[position].heading, position)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var heading: TextView = itemView.findViewById(R.id.heading)
        var num: EditText = itemView.findViewById(R.id.input)

        fun bind(item: String, position: Int) {
            heading.text = item
            num.setText(editTextValues[position] ?: "")
            num.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    editTextValues.put(adapterPosition, s.toString())
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
        }
    }
}

