package gustavo.projects.carmanager.addvehicle.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gustavo.projects.carmanager.addvehicle.domain.UIEvent
import gustavo.projects.carmanager.addvehicle.domain.VehicleState
import gustavo.projects.carmanager.common.database.entities.Vehicle
import gustavo.projects.carmanager.common.database.repository.VehicleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddVehicleViewModel @Inject constructor(
    private val vehicleRepository: VehicleRepository
): ViewModel() {

    private var _vehicleState = mutableStateOf(VehicleState())
    val vehicleState: State<VehicleState> = _vehicleState

    val vehicleNameError = mutableStateOf(false)
    val vehicleModelError = mutableStateOf(false)
    val vehicleMakeError = mutableStateOf(false)
    val vehicleOdometerError = mutableStateOf(false)

    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.VehicleNameChanged -> {
                _vehicleState.value = _vehicleState.value.copy(
                    vehicleName = event.vehicleName
                )
            }
            is UIEvent.VehicleMakeChanged -> {
                _vehicleState.value = _vehicleState.value.copy(
                    vehicleMake = event.vehicleMake
                )
            }
            is UIEvent.VehicleModelChanged -> {
                _vehicleState.value = _vehicleState.value.copy(
                    vehicleModel = event.vehicleModel
                )
            }
            is UIEvent.VehicleYearChanged -> {
                _vehicleState.value = _vehicleState.value.copy(
                    vehicleYear = event.vehicleYear
                )
            }
            is UIEvent.VehicleLicensePlateChanged -> {
                _vehicleState.value = _vehicleState.value.copy(
                    vehicleLicensePlate = event.vehicleLicensePlate
                )
            }
            is UIEvent.VehicleOdometerChanged -> {
                _vehicleState.value = _vehicleState.value.copy(
                    vehicleOdometer = event.vehicleOdometer
                )
            }
            is UIEvent.MileageUnitChanged -> {
                _vehicleState.value = _vehicleState.value.copy(
                    mileageUnit = event.mileageUnit
                )
            }
            is UIEvent.Submit -> {
                validateInputs()
            }
        }
    }

    private fun validateInputs() {
        vehicleNameError.value = vehicleState.value.vehicleName.isEmpty()
        vehicleMakeError.value = vehicleState.value.vehicleMake.isEmpty()
        vehicleModelError.value = vehicleState.value.vehicleModel.isEmpty()
        vehicleOdometerError.value = vehicleState.value.vehicleOdometer.isEmpty()

        if (vehicleState.value.vehicleName.isNotEmpty() &&
                vehicleState.value.vehicleMake.isNotEmpty() &&
                vehicleState.value.vehicleModel.isNotEmpty() &&
                vehicleState.value.vehicleOdometer.isNotEmpty()
        ) {
            val newVehicle = Vehicle(
                name = vehicleState.value.vehicleName,
                make = vehicleState.value.vehicleMake,
                model = vehicleState.value.vehicleModel,
                odometer = vehicleState.value.vehicleOdometer.toInt(),
                year = vehicleState.value.vehicleYear.toInt(),
                licensePlate = vehicleState.value.vehicleLicensePlate
            )
            viewModelScope.launch(context = Dispatchers.IO) {
                vehicleRepository.addVehicleItem(newVehicle)
            }
        }
    }
}