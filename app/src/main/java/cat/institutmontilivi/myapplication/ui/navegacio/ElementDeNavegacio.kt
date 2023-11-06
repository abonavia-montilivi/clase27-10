package cat.institutmontilivi.myapplication.ui.navegacio

import androidx.navigation.NavType

sealed class ElementDeNavegacio//con esta estructura decimos que rutaBase és "principal"/"numeros", etc. y argumentos podemos hacer +{Elementos de la lista de parámetros}
(
    val rutaBase: String,
    val argumentsDeNavegacio: List<ArgumentDeNavegacio> = emptyList(),
    // esta parte es para que monte las rutas + parámetros de forma automática para elementos obligatorios
    val rutaSencera: String = run{ //un run devuelve la última lina que calcula,
        // rutaBase/{arg1}/{arg2}/.../{argN}
        val clausArguments = argumentsDeNavegacio.map {
            "{${it.clau}}"
        }
            listOf(rutaBase)
                .plus(clausArguments)
                .joinToString(separator = "/")
    }

)//Páginas de navegación
{
    object Principal: ElementDeNavegacio("principal")
    object Numeros: ElementDeNavegacio("numeros")
    object Lletres: ElementDeNavegacio("lletres")
    object Contingut: ElementDeNavegacio("contingut",listOf(ArgumentDeNavegacio.Text))//Esto es para que pase un parámetro de texto
    {//Como que siempre le pasamos lo mismo ya lo dejamos para que lo haga solo
        fun creaRutaDeNavegacio (element: Int) = "rutaBase/${element.toString()}"
        fun creaRutaDeNavegacio (element: Char) = "rutaBase/${element}"
    }
}


//ArgumentDeNavegacio es un enum, parámetros
enum class ArgumentDeNavegacio(
    val clau: String,
    val tipus: NavType<*>//* = T C#, genérico
){
    Text (clau = "text",tipus = NavType.StringType),
    Pagina (clau="plana", tipus = NavType.IntType),//Esto és para ir añadiendo argumentos
    Audio("AudioOn", NavType.BoolType)//como que ya está declarado si se hace en orden se puede ahorrar el campo=
}