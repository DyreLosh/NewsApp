package ru.dyrelosh.newsapp.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import ru.dyrelosh.newsapp.R
import ru.dyrelosh.newsapp.databinding.FragmentDetailsBinding
import java.lang.Exception

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val bundleArgs: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = bundleArgs.article

        article.let { arg ->
            arg.urlToImage.let {
                Glide.with(this)
                    .load(arg.urlToImage)
                    .into(binding.imageDetail)
            }
            binding.imageDetail.clipToOutline = true
            binding.titleDetail.text = arg.title
            binding.descriptionDetail.text = arg.description

            binding.visitButtonDetail.setOnClickListener {
                try {
                    Intent().setAction(Intent.ACTION_VIEW)
                        .addCategory(Intent.CATEGORY_BROWSABLE)
                        .setData(Uri.parse(takeIf { URLUtil.isValidUrl(arg.url) }
                            ?.let {
                                arg.url
                            } ?: "https://google.com"))
                        .let { ContextCompat.startActivity(requireContext(), it, null) }
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "The device doesn't have any browser",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}