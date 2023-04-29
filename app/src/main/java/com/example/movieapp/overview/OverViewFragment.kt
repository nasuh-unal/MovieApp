package com.example.movieapp.overview

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.MainActivity
import com.example.movieapp.databinding.FragmentOverViewBinding

class OverViewFragment : Fragment() {
    private lateinit var binding: FragmentOverViewBinding
    private lateinit var viewModel: OverviewViewModel

    private  val Adapterr by lazy { MovieAdapter() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentOverViewBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner
        viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //veri çekme işlemini burada yapmalıyız çünkü veri gecikmesi işlemlerini onCreateView içerisinde yaparsak null dönebiliriz
        // önerilen yer burası

        binding.recyclerView.layoutManager=GridLayoutManager(activity,2)
        binding.recyclerView.adapter = Adapterr
        viewModel.movies.observe(viewLifecycleOwner,{
            Adapterr.submitList(it) })


    }
}