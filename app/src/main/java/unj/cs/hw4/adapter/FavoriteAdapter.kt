package unj.cs.hw4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import unj.cs.hw4.R
import unj.cs.hw4.model.Coffee
import unj.cs.hw4.ui.favorite.FavoriteFragmentDirections

class FavoriteAdapter(private val context: Context, private val dataset: List<Coffee>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    class FavoriteViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val descView: TextView = view.findViewById(R.id.item_short_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.FavoriteViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return FavoriteAdapter.FavoriteViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.title)
        holder.imageView.setImageResource(item.drawable)
        holder.descView.text = context.resources.getString(item.shortDescription)
        holder.itemView.setOnClickListener { view ->
            val action = FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(item)
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
