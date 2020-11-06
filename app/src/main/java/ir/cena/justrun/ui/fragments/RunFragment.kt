package ir.cena.justrun.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.cena.justrun.R
import ir.cena.justrun.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.frgment_run.*

@AndroidEntryPoint
class RunFragment:Fragment(R.layout.frgment_run) {

    private val viewModel:MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_runFragment_to_trackingFragment)
        }
    }
}