package com.example.weathertestapp.presentation.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

open class BaseFragment<T : ViewBinding>(private val layoutInflater:(LayoutInflater, ViewGroup?, Boolean) -> T?) : Fragment() {
    private var _binding: T? = null
    protected val binding: T get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = layoutInflater.invoke(inflater, container, false)
        return binding.root
    }
}