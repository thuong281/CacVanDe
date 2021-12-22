package com.example.myapplication.post.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.*
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.databinding.*
import com.example.myapplication.model.Post


class PostDetailFragment(val post: Post) : DialogFragment() {
    
    lateinit var binding: FragmentPostDetailBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPostDetailBinding.inflate(layoutInflater)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.close.setOnClickListener {
            dismiss()
        }
//        binding.name.text = post.author.name
//        binding.email.text = post.author.email
        val options = RequestOptions().transforms(CenterCrop(), RoundedCorners(20))
            .placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round)
    
//        Glide.with(requireContext()).load(post.author.profileImage).apply(options).into(binding.avaImg)
    
        Glide.with(requireContext()).load(post.image).apply(options).into(binding.image)
        
        binding.post.text = post.content
    }
    
}