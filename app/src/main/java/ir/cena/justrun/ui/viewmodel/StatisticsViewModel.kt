package ir.cena.justrun.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import ir.cena.justrun.MainRepository

class StatisticsViewModel @ViewModelInject constructor(

    val mainRepository: MainRepository
) : ViewModel() {

}