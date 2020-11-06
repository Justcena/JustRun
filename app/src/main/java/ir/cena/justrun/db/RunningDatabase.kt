package ir.cena.justrun.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Run::class], version = 1)
@TypeConverters(RunsConverters::class)
abstract class RunningDatabase : RoomDatabase() {
    abstract fun getRunDao(): RunDao
}