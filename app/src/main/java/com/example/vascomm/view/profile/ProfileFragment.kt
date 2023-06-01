package com.example.vascomm.view.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.vascomm.R
import com.example.vascomm.adapter.SearchViewpagerAdapter
import com.example.vascomm.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initTabLayout() {
        val categoriesFragments = arrayListOf(
            ProfileSayaFragment(),
            PengaturanFragment()
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
                0 -> textView.text = "Profile Saya"
                1 -> textView.text = "Pengaturan"
            }
        }
    }
}