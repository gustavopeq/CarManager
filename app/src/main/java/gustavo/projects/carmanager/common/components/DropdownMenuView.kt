package gustavo.projects.carmanager.common.components

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import gustavo.projects.carmanager.R

@Composable
fun DropdownMenuButton(
    options: List<String>,
    selectedIndex: Int,
    onOptionSelected: (index: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val selectedOption = options[selectedIndex]
    val trailingIcon: Int = if (expanded) {
        R.drawable.ic_arrow_drop_up
    } else {
        R.drawable.ic_arrow_drop_down
    }
    
    TextButton(
        onClick = { expanded = !expanded },
        modifier = modifier
    ) {
        Text(text = selectedOption)
        Icon(painter = painterResource(id = trailingIcon), contentDescription = null)
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
    ) {
        options.forEachIndexed { index, option ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = option,
                        fontWeight = if (index == selectedIndex) {
                            FontWeight.Bold
                        } else {
                            FontWeight.Normal
                        }
                    )
                },
                onClick = {
                    onOptionSelected(index)
                    expanded = false
                }
            )
        }
    }
}