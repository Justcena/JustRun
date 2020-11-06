package ir.cena.justrun.di.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.cena.justrun.R
import ir.cena.justrun.ui.viewmodel.MainViewModel

@AndroidEntryPoint
class RunFragment:Fragment(R.layout.frgment_run) {

    private val viewModel:MainViewModel by viewModels()
}