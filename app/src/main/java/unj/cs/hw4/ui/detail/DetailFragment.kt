package unj.cs.hw4.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.viewbinding.ViewBinding
import unj.cs.hw4.R
import unj.cs.hw4.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.detailTitle.text = root.context.resources.getString(arguments!!.getInt("title"))
        binding.detailImageView.setImageResource(arguments!!.getInt("image"))
        binding.detailDesc.text = root.context.resources.getString(arguments!!.getInt("description"))


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}