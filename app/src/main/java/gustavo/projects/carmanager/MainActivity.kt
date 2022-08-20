package gustavo.projects.carmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import gustavo.projects.carmanager.ui.theme.AppTypography
import gustavo.projects.carmanager.ui.theme.CarManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column() {
        Text(text = "Hello Title Large", style = AppTypography.h1)
        Text(text = "Hello Title Medium", style = AppTypography.h2)
        Text(text = "Hello Title Small || Label Large", style = AppTypography.h3)
        Text(text = "Hello Label Medium", style = AppTypography.h4)
        Text(text = "Hello Label Small", style = AppTypography.h5)
        Text(text = "Hello Body Large", style = AppTypography.body1)
        Text(text = "Hello Body Medium", style = AppTypography.body2)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CarManagerTheme {
        Greeting("Android")
    }
}