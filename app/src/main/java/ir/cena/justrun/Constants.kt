package ir.cena.justrun

import android.view.View

object Constants {

    const val RUNNING_DATABASE_NAME = "running_db"


    fun View.gone() {
        this.visibility = View.GONE
    }

    fun View.visible() {
        this.visibility = View.VISIBLE
    }

}