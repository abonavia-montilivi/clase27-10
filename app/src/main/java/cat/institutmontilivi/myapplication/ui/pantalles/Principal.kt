package cat.institutmontilivi.myapplication.ui.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cat.institutmontilivi.myapplication.TemaApp

//@Preview
//@Composable
//fun PreviewPantallaPrincipal()
//{
//    TemaApp{
//        PantallaPrincipal(controladorDeNavegacio)
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(onNavegaALletres: ()->Unit, onNavegaANumeros: () -> Unit)
{//originalmente NavNavigation
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
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla principal"
                        )
                    }
                }
            )
        }
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp)

        ){
            Button(onClick = {
                    onNavegaALletres()
                             },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = "Números",
                    style = MaterialTheme.typography.headlineLarge)
            }
            Button(onClick = {
                             //controladorDeNavegacio.navigate("lletres") antiguo
                             onNavegaANumeros()
                             },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = "Lletres",
                    style = MaterialTheme.typography.headlineLarge)
            }
        }
    }
}