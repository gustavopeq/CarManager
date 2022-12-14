package gustavo.projects.carmanager.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Home() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Home Screen",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}