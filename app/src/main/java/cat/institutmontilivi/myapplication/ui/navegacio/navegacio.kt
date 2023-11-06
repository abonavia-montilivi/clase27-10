package cat.institutmontilivi.myapplication.ui.navegacio

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cat.institutmontilivi.myapplication.ui.pantalles.PantallaElement
import cat.institutmontilivi.myapplication.ui.pantalles.PantallaLletres
import cat.institutmontilivi.myapplication.ui.pantalles.PantallaNumeros
import cat.institutmontilivi.myapplication.ui.pantalles.PantallaPrincipal

@Preview
@Composable
fun navegacio(){
    //Creem el navegador
    val controladorDeNavegacio = rememberNavController()
    NavHost(navController = controladorDeNavegacio,
        startDestination = ElementDeNavegacio.Principal.rutaBase)//Sacado de la clase Element de navegació, sustituir por "principal"
    {
        composable(ElementDeNavegacio.Principal.rutaSencera){
            PantallaPrincipal(
                onNavegaALletres = {controladorDeNavegacio.navigate(ElementDeNavegacio.Lletres.rutaSencera)},
                onNavegaANumeros = {controladorDeNavegacio.navigate(ElementDeNavegacio.Numeros.rutaSencera)}
            )
        }
        composable(ElementDeNavegacio.Numeros.rutaSencera){
            PantallaNumeros(
                onNumeroClick = {
                    controladorDeNavegacio.navigate(ElementDeNavegacio.Contingut.creaRutaDeNavegacio(it))
                    {
                        popUpTo(ElementDeNavegacio.Principal.rutaSencera)
                    }
                },
                onPopUpClic = {controladorDeNavegacio.navigateUp()}
            )
            //PantallaNumeros(controladorDeNavegacio) original
        }
        composable(ElementDeNavegacio.Lletres.rutaSencera){
            PantallaLletres(
                onLletraClick = {
                    controladorDeNavegacio.navigate(ElementDeNavegacio.Contingut.creaRutaDeNavegacio(it))
                    {
                        popUpTo(ElementDeNavegacio.Principal.rutaSencera)
                    }
                },
                onPopUpClic = {controladorDeNavegacio.navigateUp()}
            )
        }
        //En caso de parametros /{parametro} y argumentos
        composable(//Ruta/parametros que pasamos, en este caso uno tipo String
            route = ElementDeNavegacio.Contingut.rutaSencera,//Forma generica que hace los argumentos de forma automática
            //route=ElementDeNavegacio.Contingut.rutaBase+"/{"+ElementDeNavegacio.Contingut.argumentsDeNavegacio[0].clau+"}",
            arguments = listOf(
                navArgument(ElementDeNavegacio.Contingut.argumentsDeNavegacio[0].clau) {type= NavType.StringType}
                //navArgument("text"){type = NavType.StringType} original
            )
        ){//una vegada navegat recuperar el element text
            val text = it.arguments?.getString(ElementDeNavegacio.Contingut.argumentsDeNavegacio[0].clau)
            requireNotNull(text, {"El text no pot ser null"})
            PantallaElement(text = text)//text!! = Cotlin te aseguro que text no es null
        }
    }
}