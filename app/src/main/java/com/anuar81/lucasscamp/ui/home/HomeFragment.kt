package com.anuar81.lucasscamp.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.anuar81.lucasscamp.R
import com.anuar81.lucasscamp.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        viewModel.loadOrCreateUserData()
        viewModel.updateView.observe(viewLifecycleOwner, Observer {
            updateLoadView(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateLoadView(updateStatus: Boolean) {
        if (updateStatus) {
            binding.homeLoadingTxt.text = "Done"
        }
    }

}