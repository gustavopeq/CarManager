package gustavo.projects.carmanager.common.database.repository

import gustavo.projects.carmanager.common.database.daos.VehicleDao
import gustavo.projects.carmanager.common.database.entities.Vehicle
import kotlinx.coroutines.flow.Flow

class VehicleRepositoryImpl(
    private val vehicleDao: VehicleDao
): VehicleRepository {

    /**
     * Add new vehicle to the database.
     * @param[newVehicle] item to be added.
     */
    override suspend fun addVehicleItem(newVehicle: Vehicle) {
        vehicleDao.insert(newVehicle)
        println("PRINT - New vehicle added to database: $newVehicle")
    }

    /**
     * Get all vehicles available in the database.
     * @return List of vehicles.
     */
    override suspend fun getAllVehicles(): Flow<List<Vehicle>> {
        return vehicleDao.getAll()
    }
}