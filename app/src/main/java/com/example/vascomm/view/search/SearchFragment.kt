package com.example.vascomm.view.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.vascomm.R
import com.example.vascomm.adapter.SearchViewpagerAdapter
import com.example.vascomm.databinding.FragmentSearchBinding
import com.example.vascomm.view.product.ProductFragment
import com.example.vascomm.view.service_type.ServiceTypeFragment
import com.google.android.material.tabs.TabLayoutMediator

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
        initTabLayout2()

    }

    private fun initTabLayout() {
        val categoriesFragments = arrayListOf(
            ProductFragment(),
            ProductFragment(),
            ProductFragment()
        )
        binding.viewPager.isUserInputEnabled = false
        val viewPagerAdapter =
            SearchViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "All Product"
                1 -> tab.text = "Layanan Kesehatan"
                2 -> tab.text = "Alat Kesehatan"
            }
        }.attach()
        for (i in 0 until binding.tabLayout.tabCount) {
            val textView = LayoutInflater.from(requireContext())
                .inflate(R.layout.tab_search_title, null) as TextView
            binding.tabLayout.getTabAt(i)?.customView = textView
            when (i) {
                0 -> textView.text = "All Product"
                1 -> textView.text = "Layanan Kesehatan"
                2 -> textView.text = "Alat Kesehatan"
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initTabLayout2() {
        val categoriesFragments = arrayListOf(
            ServiceTypeFragment(),
            ServiceTypeFragment()
        )

        binding.viewPager2.isUserInputEnabled = false
        val viewPager2Adapter =
            SearchViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewPager2.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout2, binding.viewPager2) { tab, position -> }.attach()

        for (i in 0 until binding.tabLayout2.tabCount) {
            val textView = LayoutInflater.from(requireContext())
                .inflate(R.layout.tab_search_kesehatan, null) as TextView
            binding.tabLayout2.getTabAt(i)?.customView = textView
            when (i) {
                0 -> textView.text = "Satuan"
                1 -> textView.text = "Paket Pemeriksaan"
            }
        }
    }

}