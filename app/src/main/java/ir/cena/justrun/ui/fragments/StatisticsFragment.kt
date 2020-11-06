package ir.cena.justrun.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.cena.justrun.R
import ir.cena.justrun.ui.viewmodel.StatisticsViewModel

@AndroidEntryPoint
class StatisticsFragment:Fragment(R.layout.frgment_statistics) {
    private val viewModel: StatisticsViewModel by viewModels()

}