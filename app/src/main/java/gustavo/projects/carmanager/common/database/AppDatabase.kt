package gustavo.projects.carmanager.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import gustavo.projects.carmanager.common.database.daos.VehicleDao
import gustavo.projects.carmanager.common.database.entities.Vehicle

@Database(
    entities = [Vehicle::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}