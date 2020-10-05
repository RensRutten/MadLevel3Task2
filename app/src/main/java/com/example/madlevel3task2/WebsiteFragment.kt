package com.example.madlevel3task2

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.VERTICAL
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_website.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WebsiteFragment : Fragment() {

    private val websites = arrayListOf<Website>()
    private val websiteAdapter = WebsiteAdapter(websites) { website: Website ->
        websiteCLicked(
            website
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_website, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addWebsiteResult()
        initViews()


    }

    private fun initViews() {
        rvWebsite.layoutManager = GridLayoutManager(context, 2)
        rvWebsite.adapter = websiteAdapter
        rvWebsite.setPadding(4, 4, 4, 4)
        rvWebsite.clipToPadding = false
        rvWebsite.clipChildren = false
        rvWebsite.addItemDecoration(
            DividerItemDecoration(
                context,
                VERTICAL
            )
        )
    }

    private fun addWebsiteResult() {
        setFragmentResultListener(REQ_WEBSITE_KEY) { key, bundle ->
            val title = bundle.getString(BUNDLE_TITLE_KEY)
            val urlTxt = bundle.getString(BUNDLE_URL_KEY)
            val website = Website(title.toString(), urlTxt.toString())
            websites.add(website)
            websiteAdapter.notifyDataSetChanged()
        }

    }

    private fun websiteCLicked(website: Website) {
        Log.e("website", website.URLtext)
        createChrome(website.URLtext)
    }

    fun createChrome(url: String) {
        var builder = CustomTabsIntent.Builder()
        var customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this.context, Uri.parse("${url}"))
    }

}


