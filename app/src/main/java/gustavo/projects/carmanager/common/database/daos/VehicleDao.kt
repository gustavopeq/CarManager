package gustavo.projects.carmanager.common.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import gustavo.projects.carmanager.common.database.entities.Vehicle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {

    @Insert
    fun insert(newVehicle: Vehicle)

    @Query("SELECT * FROM vehicle")
    fun getAll(): Flow<List<Vehicle>>
}