package ru.dyrelosh.newsapp.ui.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.dyrelosh.newsapp.R
import ru.dyrelosh.newsapp.databinding.FragmentDetailsBinding
import ru.dyrelosh.newsapp.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(layoutInflater, container, false)
        binding.dfdsaf.setOnClickListener {
            findNavController().navigate(R.id.action_favouriteFragment_to_detailsFragment)
        }
        return binding.root
    }

}