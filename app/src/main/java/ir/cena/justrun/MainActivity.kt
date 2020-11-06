package ir.cena.justrun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.cena.justrun.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import ir.cena.justrun.other.Constants.gone
import ir.cena.justrun.other.Constants.visible
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        /**
         * this function --> if mainActivity was destroid then we going to onCreating it
         */
        navigationToTrackingFragmentIfNeeded(intent)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())


        navHostFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment ->
                    bottomNavigationView.visible()
                else -> bottomNavigationView.gone()
            }
        }
    }


    private fun navigationToTrackingFragmentIfNeeded(intent: Intent?) {
        if (intent?.action == ACTION_SHOW_TRACKING_FRAGMENT) {
            navHostFragment.findNavController().navigate(R.id.action_global_tracking_fragment)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigationToTrackingFragmentIfNeeded(intent)
    }
}
