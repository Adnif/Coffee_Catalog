package unj.cs.hw4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import unj.cs.hw4.adapter.ItemAdapter
import unj.cs.hw4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.homeListView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = ItemAdapter(root.context, homeViewModel.myDataset)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}