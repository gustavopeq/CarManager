package gustavo.projects.carmanager.addvehicle.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import gustavo.projects.carmanager.R
import gustavo.projects.carmanager.addvehicle.domain.UIEvent
import gustavo.projects.carmanager.addvehicle.domain.VehicleState
import gustavo.projects.carmanager.common.components.DropdownMenuButton
import gustavo.projects.carmanager.common.components.PrimaryButton
import gustavo.projects.carmanager.common.util.SuffixTransformation

@Composable
fun AddVehicle() {
    AddVehicle(viewModel = hiltViewModel())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddVehicle(
    viewModel: AddVehicleViewModel
) {

    val vehicleState = viewModel.vehicleState.value



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = viewModel.vehicleState.value.vehicleName,
            onValueChange = { viewModel.onEvent(UIEvent.VehicleNameChanged(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            label = { Text(text = stringResource(id = R.string.vehicle_name_label)) },
            singleLine = true,
            isError = viewModel.vehicleNameError.value,
            supportingText = {
                if (viewModel.vehicleNameError.value) {
                    Text(text = stringResource(id = R.string.vehicle_name_error_label))
                }
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = vehicleState.vehicleMake,
                onValueChange = { viewModel.onEvent(UIEvent.VehicleMakeChanged(it)) },
                modifier = Modifier.weight(1f),
                label = { Text(text = stringResource(id = R.string.vehicle_make_label)) },
                singleLine = true,
                isError =  viewModel.vehicleMakeError.value,
                supportingText = {
                    if (viewModel.vehicleMakeError.value) {
                        Text(text = stringResource(id = R.string.vehicle_make_error_label))
                    }
                }
            )

            OutlinedTextField(
                value = vehicleState.vehicleModel,
                onValueChange = { viewModel.onEvent(UIEvent.VehicleModelChanged(it)) },
                modifier = Modifier.weight(1f),
                label = { Text(text = stringResource(id = R.string.vehicle_model_label)) },
                singleLine = true,
                isError =  viewModel.vehicleModelError.value,
                supportingText = {
                    if (viewModel.vehicleModelError.value) {
                        Text(text = stringResource(id = R.string.vehicle_model_error_label))
                    }
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = vehicleState.vehicleYear?.toString() ?: "",
                onValueChange = { viewModel.onEvent(UIEvent.VehicleYearChanged(it.toInt())) },
                modifier = Modifier.weight(0.5f),
                label = { Text(text = stringResource(id = R.string.vehicle_year_label)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = vehicleState.vehicleLicensePlate,
                onValueChange = { viewModel.onEvent(UIEvent.VehicleLicensePlateChanged(it)) },
                modifier = Modifier.weight(1f),
                label = { Text(text = stringResource(id = R.string.vehicle_license_plate_label)) },
                singleLine = true
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.additional_info_label),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 8.dp),
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        AdditionalInfoPanel(
            vehicleState = vehicleState,
            viewModel = viewModel
        )

        Spacer(modifier = Modifier.height(8.dp))

        PrimaryButton(
            onClick = {
                viewModel.onEvent(UIEvent.Submit)
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "Submit")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdditionalInfoPanel(
    vehicleState: VehicleState,
    viewModel: AddVehicleViewModel
) {
    val listMileageUnit = listOf("km", "mi")
    var selectedMileageUnitIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = vehicleState.vehicleOdometer.toString(),
            onValueChange = { newValue ->
                if (newValue.isEmpty()) {
                    viewModel.onEvent(UIEvent.VehicleOdometerChanged(0))

                } else {
                    viewModel.onEvent(UIEvent.VehicleOdometerChanged(newValue.toLong()))
                }
            },
            modifier = Modifier.weight(0.8f),
            label = { Text(text = stringResource(id = R.string.odometer_label)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            visualTransformation = SuffixTransformation(vehicleState.mileageUnit),
            isError =  viewModel.vehicleOdometerError.value,
            supportingText = {
                if (viewModel.vehicleOdometerError.value) {
                    Text(text = stringResource(id = R.string.vehicle_odometer_error_label))
                }
            }
        )

        Box {
            DropdownMenuButton(
                options = listMileageUnit,
                selectedIndex = selectedMileageUnitIndex,
                onOptionSelected = {
                    selectedMileageUnitIndex = it
                    viewModel.onEvent(UIEvent.MileageUnitChanged(listMileageUnit[it]))
                },
                modifier = Modifier.width(80.dp)
            )
        }
    }
}