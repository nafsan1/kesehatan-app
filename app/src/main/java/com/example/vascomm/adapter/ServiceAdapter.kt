package com.example.vascomm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.data.Service
import com.example.core.util.formatRupiah
import com.example.vascomm.R
import com.example.vascomm.databinding.RvProductBinding
import com.example.vascomm.databinding.RvServiceTypeBinding

class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    inner class ServiceViewHolder(private val binding: RvServiceTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(service: Service) {
            binding.apply {

                Glide.with(itemView).load(service.image).into(imageView)
                txtPrice.text = service.price.formatRupiah()
                txtName.text = service.name
                txtHospitalName.text = service.hospitalName
                txtLocation.text = service.location
            }

        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Service>() {
        override fun areItemsTheSame(oldItem: Service, newItem: Service): Boolean {
            return oldItem.name == newItem.name

        }

        override fun areContentsTheSame(oldItem: Service, newItem: Service): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(
            RvServiceTypeBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = differ.currentList[position]
        holder.bind(service)

        holder.itemView.setOnClickListener {
            onClick?.invoke(service)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick: ((Service) -> Unit)? = null

}