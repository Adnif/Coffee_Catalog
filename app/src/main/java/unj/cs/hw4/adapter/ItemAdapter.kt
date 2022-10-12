package unj.cs.hw4.adapter

import android.content.Context
import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import unj.cs.hw4.R
import unj.cs.hw4.model.Coffee
import unj.cs.hw4.ui.home.HomeFragment

class ItemAdapter(private val context: Context, private val dataset: List<Coffee>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val descView: TextView = view.findViewById(R.id.item_short_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.title)
        holder.imageView.setImageResource(item.drawable)
        holder.descView.text = context.resources.getString(item.shortDescription)
        holder.itemView.setOnClickListener { view ->
            val bundle: Bundle = bundleOf("title" to item.title, "image" to item.drawable, "description" to item.longDescription)
            val NavController = Navigation.findNavController(view)
            NavController.navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}