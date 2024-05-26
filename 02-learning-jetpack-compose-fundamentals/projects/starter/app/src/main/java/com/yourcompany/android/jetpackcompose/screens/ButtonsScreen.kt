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

package com.yourcompany.android.jetpackcompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarms
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yourcompany.android.jetpackcompose.R
import com.yourcompany.android.jetpackcompose.router.BackButtonHandler
import com.yourcompany.android.jetpackcompose.router.JetFundamentalsRouter
import com.yourcompany.android.jetpackcompose.router.Screen

@Composable
fun ExploreButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()
        MyOthersButtons()

        BackButtonHandler {
            JetFundamentalsRouter.navigateTo(Screen.Navigation)
        }
    }
}

@Composable
fun MyButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor =
            colorResource(id = R.color.colorPrimary)
        ),
        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.colorPrimaryDark)
        )
    ) {
        Text(
            text = stringResource(id = R.string.button_text),
            color = Color.White
        )
    }
}

@Composable
fun MyRadioGroup() {
    val radioButtons = listOf(0, 1, 2, 3, 4)
    val selectedButton = remember { mutableIntStateOf(radioButtons[0]) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.intValue
            val colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(id = R.color.quantum_yellowA400),
                unselectedColor = colorResource(id = R.color.quantum_vanillared600),
                disabledUnselectedColor = Color.Blue
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(4.dp)
            ) {
                RadioButton(
                    selected = isSelected,
                    onClick = { selectedButton.intValue = index },
                    colors = colors,
                    enabled = index != 3
                )
                Text(
                    text = "$index",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}


@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        containerColor = colorResource(id =
        R.color.colorPrimary),
        contentColor = Color.White,
        content = {
            Icon(
                Icons.Filled.AccessAlarms, contentDescription = "Test FAB")
        }
    )
}
@Composable
fun MyOthersButtons(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        // IconButton
        IconButton(onClick = { /* TODO: Handle IconButton click */ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Favorite Icon")
        }

        // OutlinedButton
        OutlinedButton(onClick = { /* TODO: Handle OutlinedButton click */ }) {
            Text(text = "Outlined Button")
        }

        // IconToggleButton
        var isChecked by remember { mutableStateOf(false) }
        IconToggleButton(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        ) {
            val icon = if (isChecked) Icons.Filled.Check else Icons.Filled.Close
            val tint = if (isChecked) Color.Green else Color.Red
            Icon(icon, contentDescription = "Toggle Button", tint = tint)
        }

        // TextButton
        TextButton(onClick = { /* TODO: Handle TextButton click */ }) {
            Text(text = "Text Button")
        }
    }
}
