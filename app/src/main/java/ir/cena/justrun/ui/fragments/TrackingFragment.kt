package ir.cena.justrun.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.AndroidEntryPoint
import ir.cena.justrun.R
import ir.cena.justrun.other.Constants.ACTION_START_OR_RESUME_SERVICE
import ir.cena.justrun.services.TrackingService
import ir.cena.justrun.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.frgment_tracking.*

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.frgment_tracking) {
    private val viewModel: MainViewModel by viewModels()

    private var map: GoogleMap? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * for create mapView
         */
        mapView.onCreate(savedInstanceState)


        btnToggleRun.setOnClickListener {
            sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
        }
        mapView.getMapAsync { map = it }
    }


    private fun sendCommandToService(action: String) {

        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }

    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

}