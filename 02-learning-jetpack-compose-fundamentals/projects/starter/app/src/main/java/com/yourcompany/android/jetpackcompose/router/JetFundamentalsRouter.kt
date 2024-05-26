/*
 * Copyright (c) 2022 Kodeco Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.yourcompany.android.jetpackcompose.router

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * Class defining the screens we have in the app.
 *
 * These objects should match files we have in the screens package
 */
sealed class Screen {

    /*object Navigation: Esto define un objeto singleton llamado Navigation. En Kotlin, object se
    utiliza para crear singletons, lo que significa que solo habrá una instancia de este objeto en
    toda la aplicación.

    :: Esto indica que Navigation es un subtipo de Screen.

    Screen(): Aquí estamos llamando al constructor de la clase sellada Screen. Las clases selladas
    en Kotlin son como enumeraciones avanzadas que pueden contener tanto datos como métodos. Cuando
    llamamos al constructor de Screen, estamos creando una instancia de una de sus subclases. En
    este caso, Navigation es una instancia de la subclase Screen.

    Entonces, en resumen, la línea object Navigation : Screen() crea un objeto singleton llamado
    Navigation, que es una instancia de la clase sellada Screen. Esto se utiliza para representar
    una pantalla específica en la aplicación, en este caso, la pantalla de navegación.






*/
    object Navigation : Screen() // Define la pantalla de navegación
    object Text : Screen() // Define la pantalla de texto
    object TextField : Screen() // Define la pantalla de campo de texto
    object Buttons : Screen() // Define la pantalla de botones
    object ProgressIndicator : Screen() // Define la pantalla de indicador de progreso
    object AlertDialog : Screen() // Define la pantalla de diálogo de alerta
    object NavigationDialogs : Screen() // Define la pantalla de navegación de diálogos
    object Snackbar : Screen() // Define la pantalla de Snackbar
    object BottomSheetDialogs : Screen() // Define la pantalla de BottomSheet
}

/** Router object used to navigate between screens. */
object JetFundamentalsRouter {
    // MutableState para mantener el estado de la pantalla actual
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.Navigation)

    /**
     * Function to navigate to a specific screen.
     *
     * @param destination La pantalla a la que se desea navegar
     */
    fun navigateTo(destination: Screen) {
        // Actualiza el valor de currentScreen para mostrar la pantalla deseada
        currentScreen.value = destination
    }
}
