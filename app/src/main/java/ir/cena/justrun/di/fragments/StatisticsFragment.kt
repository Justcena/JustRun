package ir.cena.justrun.di.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.cena.justrun.R
import ir.cena.justrun.ui.viewmodel.MainViewModel
import ir.cena.justrun.ui.viewmodel.StatisticsViewModel

@AndroidEntryPoint
class StatisticsFragment:Fragment(R.layout.frgment_statistics) {
    private val viewModel: StatisticsViewModel by viewModels()

}