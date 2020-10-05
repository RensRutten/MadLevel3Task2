package com.example.madlevel3task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_website.*

const val REQ_WEBSITE_KEY = "req_website"
const val BUNDLE_URL_KEY = "bundle_url"
const val BUNDLE_TITLE_KEY = "bundle_title"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddWebsiteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_website, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddPortal.setOnClickListener {
            onAddWebsite()
        }
    }

    private fun onAddWebsite() {
        val TitleText = etTitle.text.toString()
        val URLtext = etURLtext.text.toString()

        if (TitleText.isNotBlank()) {
            setFragmentResult(
                REQ_WEBSITE_KEY,
                bundleOf(BUNDLE_TITLE_KEY to TitleText, BUNDLE_URL_KEY to URLtext)
            )

            findNavController().popBackStack()
        } else {
            Toast.makeText(
                activity,
                "invalid input", Toast.LENGTH_SHORT
            ).show()
        }
    }
}