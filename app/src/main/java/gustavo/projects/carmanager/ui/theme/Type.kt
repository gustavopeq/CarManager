package gustavo.projects.carmanager.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val AppTypography = Typography(
    // Title large
    h1 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight(400),
        lineHeight = 28.sp
    ),
    // Title medium
    h2 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight(500),
        lineHeight = 24.sp
    ),
    // Title small || Label large
    h3 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight(500),
        lineHeight = 20.sp
    ),
    // Label medium
    h4 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(500),
        lineHeight = 16.sp
    ),
    // Label small
    h5 = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight(500),
        lineHeight = 16.sp
    ),
    // Body large
    body1 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        lineHeight = 24.sp
    ),
    // Body medium
    body2 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        lineHeight = 20.sp
    ),
)