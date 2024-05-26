package com.yourcompany.android.jetpackcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yourcompany.android.jetpackcompose.router.BackButtonHandler
import com.yourcompany.android.jetpackcompose.router.JetFundamentalsRouter
import com.yourcompany.android.jetpackcompose.router.Screen
import kotlinx.coroutines.launch

@Composable
fun SnackbarScreen() {

    MySnackbarScreen()

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.NavigationDialogs)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySnackbarScreen() {
    // SnackbarHostState se usa para controlar la visualización de los Snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    // scope se utiliza para lanzar corrutinas
    val scope = rememberCoroutineScope()

    // Scaffold proporciona la estructura de diseño para Compose
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        content = { paddingValues ->
            // Añadir un modificador a la columna para manejar el padding del scaffold
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            // Muestra el Snackbar
                            snackbarHostState.showSnackbar(
                                message = "Hello",
                                actionLabel = "Deshacer"
                            )
                        }
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Mostrar Snackbar")
                }
            }
        }
    )
}







