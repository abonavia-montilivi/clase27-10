package cat.institutmontilivi.myapplication.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PantallaElement(
    modifier: Modifier = Modifier,
    text: String ="99",
    textStyle: TextStyle = MaterialTheme.typography.displayLarge,
    backColor: Color = MaterialTheme.colorScheme.tertiary,
    textColor: Color = MaterialTheme.colorScheme.onTertiary,
    onClick: ()->Unit = {}
){
    Box(modifier = modifier
        .fillMaxSize()
        .border(width = 4.dp, color = textColor)
        .padding(4.dp)
        .background(backColor)
        .clickable ( onClick= onClick )
    ){
        Text(
            text=text,
            modifier = Modifier.align(Alignment.Center),
            style=textStyle,
            color = textColor,
            fontSize=256.sp
        )
    }
}