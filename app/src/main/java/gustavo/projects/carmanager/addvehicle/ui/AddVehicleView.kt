package gustavo.projects.carmanager.addvehicle.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import gustavo.projects.carmanager.R
import gustavo.projects.carmanager.addvehicle.domain.UIEvent

@Composable
fun AddVehicle() {
    AddVehicle(viewModel = hiltViewModel())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddVehicle(
    viewModel: AddVehicleViewModel
) {
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
            singleLine = true
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = viewModel.vehicleState.value.vehicleMake,
                onValueChange = { viewModel.onEvent(UIEvent.VehicleMakeChanged(it)) },
                modifier = Modifier.weight(1f),
                label = { Text(text = stringResource(id = R.string.vehicle_make_label)) },
                singleLine = true
            )

            OutlinedTextField(
                value = viewModel.vehicleState.value.vehicleModel,
                onValueChange = { viewModel.onEvent(UIEvent.VehicleModelChanged(it)) },
                modifier = Modifier.weight(1f),
                label = { Text(text = stringResource(id = R.string.vehicle_model_label)) },
                singleLine = true
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = viewModel.vehicleState.value.vehicleYear,
                onValueChange = { viewModel.onEvent(UIEvent.VehicleYearChanged(it)) },
                modifier = Modifier.weight(0.5f),
                label = { Text(text = stringResource(id = R.string.vehicle_year_label)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = viewModel.vehicleState.value.vehicleLicensePlate,
                onValueChange = { viewModel.onEvent(UIEvent.VehicleLicensePlateChanged(it)) },
                modifier = Modifier.weight(1f),
                label = { Text(text = stringResource(id = R.string.vehicle_license_plate_label)) },
                singleLine = true
            )
        }
    }
}