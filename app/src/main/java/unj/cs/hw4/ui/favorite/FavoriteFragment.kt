package unj.cs.hw4.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import unj.cs.hw4.R
import unj.cs.hw4.adapter.FavoriteAdapter
import unj.cs.hw4.databinding.FragmentFavoriteBinding
import unj.cs.hw4.ui.CoffeeViewModel

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private var _binding: FragmentFavoriteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val favoriteViewModel =
            ViewModelProvider(this).get(CoffeeViewModel::class.java)

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.favoriteListView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = FavoriteAdapter(root.context, favoriteViewModel.myDataset.filter { it.favorite })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}