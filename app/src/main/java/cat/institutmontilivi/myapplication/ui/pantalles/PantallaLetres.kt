package cat.institutmontilivi.myapplication.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cat.institutmontilivi.myapplication.ui.navegacio.ElementDeNavegacio
import cat.institutmontilivi.myapplication.ui.pantalles.common.Casella

//@Preview
//@Composable
//fun PreviewpantallaLletres(){
//    TemaApp {
//        PantallaLletres(controladorDeNavegacio)
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLletres(onLletraClick: (Char)->Unit, onPopUpClic: () ->Unit)
{
    Scaffold (
        topBar =
        {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { "Menú principal" },
                navigationIcon = {
                    IconButton(onClick = { onPopUpClic }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla principal"
                        )
                    }
                }
            )
        }
    ){
        Lletres(it, onLletraClick)
    }
}

@Composable
fun Lletres(paddingValues: PaddingValues, onLletraClick: (Char)->Unit) {
    val dades = ('A'..'Z').toList()
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .background((MaterialTheme.colorScheme.secondary))
    ) {
        Text(text = "Lletres",
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSecondary
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy((4.dp))
        ){
            items(
                items = dades
            ){
                Casella(
                    text = it.toString(),
                    onClick = {onLletraClick(it)}
                )
            }
        }
    }
}
