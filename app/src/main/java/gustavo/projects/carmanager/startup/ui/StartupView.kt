package gustavo.projects.carmanager.startup.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import gustavo.projects.carmanager.R
import gustavo.projects.carmanager.common.components.BaseButton

@Composable
fun Startup(
    openAddVehicle: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.startup_header),
            style = MaterialTheme.typography.titleLarge,
        )

        Spacer(modifier = Modifier.height(60.dp))

        BaseButton(onClick = openAddVehicle) {
            Text(text = stringResource(id = R.string.startup_button))
        }
    }
}