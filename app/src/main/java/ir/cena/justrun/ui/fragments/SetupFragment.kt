package ir.cena.justrun.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.cena.justrun.R
import kotlinx.android.synthetic.main.frgment_setup.*

class SetupFragment:Fragment(R.layout.frgment_setup) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvContinue.setOnClickListener {
         findNavController().navigate(R.id.action_setupFragment_to_runFragment)
        }
    }
}