package gustavo.projects.carmanager.addvehicle.domain

sealed class UIEvent {
    data class VehicleNameChanged(val vehicleName: String): UIEvent()
    data class VehicleMakeChanged(val vehicleMake: String): UIEvent()
    data class VehicleModelChanged(val vehicleModel: String): UIEvent()
    data class VehicleYearChanged(val vehicleYear: Int): UIEvent()
    data class VehicleLicensePlateChanged(val vehicleLicensePlate: String): UIEvent()
    data class VehicleOdometerChanged(val vehicleOdometer: Long): UIEvent()
    data class MileageUnitChanged(val mileageUnit: String): UIEvent()
    object Submit: UIEvent()
}
