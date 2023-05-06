package gustavo.projects.carmanager.common.database.repository

import gustavo.projects.carmanager.common.database.entities.Vehicle
import kotlinx.coroutines.flow.Flow

interface VehicleRepository {

    /**
     * Add new vehicle to the database.
     * @param[newVehicle] item to be added.
     */
    suspend fun addVehicleItem(newVehicle: Vehicle)

    /**
     * Get all vehicles available in the database.
     * @return List of vehicles.
     */
    suspend fun getAllVehicles(): Flow<List<Vehicle>>
}