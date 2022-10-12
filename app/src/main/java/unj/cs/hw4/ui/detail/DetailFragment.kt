package unj.cs.hw4.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import unj.cs.hw4.R
import unj.cs.hw4.databinding.FragmentDetailBinding
import unj.cs.hw4.ui.CoffeeViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val detailViewModel =
            ViewModelProvider(this).get(CoffeeViewModel::class.java)

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.detailTitle.text = root.context.resources.getString(args.currentCoffee.title)
        binding.detailImageView.setImageResource(args.currentCoffee.drawable)
        binding.detailDesc.text = root.context.resources.getString(args.currentCoffee.longDescription)

        binding.favButton.setOnClickListener {
            for (coffee in detailViewModel.myDataset) {
                if (coffee == args.currentCoffee) {
                    if (!coffee.favorite) {
                        coffee.favorite = true
                        val toast = Toast
                            .makeText(
                                root.context,
                                "${resources.getString(coffee.title)} has added to favorite",
                                Toast.LENGTH_SHORT
                            )
                        toast.show()
                    } else {
                        coffee.favorite = false
                        val toast = Toast
                            .makeText(
                                root.context,
                                "${resources.getString(coffee.title)} has removed from favorite",
                                Toast.LENGTH_SHORT
                            )
                        toast.show()
                    }
                }
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}