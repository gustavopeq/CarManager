package gustavo.projects.carmanager.addvehicle.domain

data class VehicleState(
    val vehicleName: String = "",
    val vehicleMake: String = "",
    val vehicleModel: String = "",
    val vehicleYear: Int? = null,
    val vehicleLicensePlate: String = "",
    val vehicleOdometer: Long = 0,
    val mileageUnit: String = "km"
)
