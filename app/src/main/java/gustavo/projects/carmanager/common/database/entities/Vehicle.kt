package gustavo.projects.carmanager.common.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vehicle(
    @PrimaryKey val name: String,
    val make: String,
    val model: String,
    val odometer: Long,
    val year: Int? = null,
    val licensePlate: String? = null
)
