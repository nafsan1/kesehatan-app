package com.example.vascomm.view.service_type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.Product
import com.example.core.data.Service
import com.example.core.util.VerticalItemDecoration
import com.example.vascomm.R
import com.example.vascomm.adapter.ProductAdapter
import com.example.vascomm.adapter.ServiceAdapter
import com.example.vascomm.databinding.FragmentRvBinding

class ServiceTypeFragment : Fragment() {

    private lateinit var binding: FragmentRvBinding
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRvBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }


    private fun initAdapter() {
        val service1 = Service(
            name = "PCR Swab Test (Drive Thru)\n" +
                    "Hasil 1 Hari Kerja",
            price = 1400000,
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            image = R.drawable.image_hospital1
        )

        val service2 = Service(
            name = "PCR Swab Test (Drive Thru)\n" +
                    "Hasil 1 Hari Kerja",
            price = 1400000,
            hospitalName = "Lenmarc Surabaya",
            location = "Dukuh Pakis, Surabaya",
            image = R.drawable.image_hospital2
        )
        val data = arrayListOf<Service>()
        data.add(service1)
        data.add(service2)
        data.add(service1)
        data.add(service2)
        binding.rv.isNestedScrollingEnabled = false
        serviceAdapter = ServiceAdapter()
        binding.rv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            addItemDecoration(VerticalItemDecoration())
            adapter = serviceAdapter
        }
        serviceAdapter.differ.submitList(data)
    }
}