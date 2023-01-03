package gustavo.projects.carmanager.addvehicle.domain

data class VehicleState(
    val vehicleName: String = "",
    val vehicleMake: String = "",
    val vehicleModel: String = "",
    val vehicleYear: String = "",
    val vehicleLicensePlate: String = "",
    val vehicleOdometer: String = "0",
    val mileageUnit: String = "km"
)
