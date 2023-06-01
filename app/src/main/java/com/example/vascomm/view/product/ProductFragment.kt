package com.example.vascomm.view.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.data.Product
import com.example.vascomm.R
import com.example.vascomm.adapter.ProductAdapter
import com.example.vascomm.databinding.FragmentRvBinding
import com.example.vascomm.helper.MarginItemDecoration

class ProductFragment : Fragment() {

    private lateinit var binding: FragmentRvBinding
    private lateinit var productAdapter: ProductAdapter

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
        val product = Product(
            image = R.drawable.image_product,
            name = "Suntik Steril",
            price = 10000,
            status = "Ready Stok"
        )
        val data = arrayListOf<Product>()
        data.add(product)
        data.add(product)
        productAdapter = ProductAdapter()
        binding.rv.apply {
            val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_large2)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(MarginItemDecoration(spacingInPixels))
            adapter = productAdapter
        }
        productAdapter.differ.submitList(data)


    }


}