package ir.cena.justrun

import ir.cena.justrun.db.Run
import ir.cena.justrun.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(val runDao: RunDao) {


    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)


    fun getAllRunsSortedByDate()=runDao.getAllRunsSortedByDate()
    fun getAllRunsSortedByDistance()=runDao.getAllRunsSortedByDistance()
    fun getAllRunsSortedByTimeInMillis()=runDao.getAllRunsSortedByTimeInMillis()
    fun getAllRunsSortedByAvgSpeed()=runDao.getAllRunsSortedByAvgSpeed()
    fun getAllRunsSortedByCaloriesBurned()=runDao.getAllRunsSortedByCaloriesBurned()

    fun getTotalAvgSpeed()=runDao.getAllRunsSortedByCaloriesBurned()
    fun getTotalDistance()=runDao.getAllRunsSortedByCaloriesBurned()
    fun getTotalCaloriesBurned()=runDao.getAllRunsSortedByCaloriesBurned()
    fun getTotalTimeInMillis()=runDao.getAllRunsSortedByCaloriesBurned()
}