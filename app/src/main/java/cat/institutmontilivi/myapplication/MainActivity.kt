package cat.institutmontilivi.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cat.institutmontilivi.myapplication.ui.navegacio.navegacio
import cat.institutmontilivi.myapplication.ui.theme.Clase2710Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Menos comun pero modo lamda
            //TemaApp (content = { Greeting(name = "Android")})
            //Mayoria de veces se usa este
            TemaApp {
                //Greeting(name = "Android")
                navegacio()
            }
        }
    }
}


@Composable
fun TemaApp ( content: @Composable ()->Unit)
{
    Clase2710Theme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Clase2710Theme {
//        Greeting("Android")
//    }
//}
