package ir.cena.justrun.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.cena.justrun.R
import ir.cena.justrun.ui.viewmodel.MainViewModel

@AndroidEntryPoint
class TrackingFragment:Fragment(R.layout.frgment_tracking) {
    private val viewModel: MainViewModel by viewModels()

}