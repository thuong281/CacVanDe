package com.example.myapplication.game

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.*
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentGameMenuBinding


class GameMenuFragment : Fragment() {
    lateinit var binding: FragmentGameMenuBinding
    lateinit var viewModel: GameViewModel
    
    
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGameMenuBinding.inflate(layoutInflater)
        return binding.root
    }
    
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
        binding.play.setOnClickListener {
            showDialog(GameFragment().apply {
                this.setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_NoActionBar)
            })
        }
        binding.tutorial.setOnClickListener {
            showDialog(TutorialFragment())
        }
        viewModel.highScore.observe(viewLifecycleOwner) {
            binding.highScore.text = viewModel.highScore.value.toString()
        }
        val sharedPref = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val score = sharedPref.getInt("score", 0)
        viewModel.highScore.value = score
    }
    
    private fun showDialog(fragment: DialogFragment) {
        val fm: FragmentManager? = fragmentManager
        fragment.show(fm!!, "")
    }
    
    
}