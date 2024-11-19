package com.example.recyclerview01_2025

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun Recyclerview_Control(modifier: Modifier) {
    val rvState = rememberLazyListState()
    val coroutilecope = rememberCoroutineScope()
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            LazyColumn(
                state = rvState,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(getGuitars()) {
                    ItemGuitar(it)
                }
            }

            // Utiliza un estado derivado para calcular si el botón debe mostrarse o no.
            // La variable `showButton` será `true` si el índice del primer elemento visible
            // en el estado del LazyColumn (`rvState.firstVisibleItemIndex`) es mayor a 0,
            // indicando que la lista ha sido desplazada hacia abajo. es algo inutil
            val showButton by remember {
                derivedStateOf { rvState.firstVisibleItemIndex > 0 }
            }

            if (showButton) {
                Button(
                    onClick = {
                        coroutilecope.launch { rvState.animateScrollToItem(0) }

                    },
                    modifier = Modifier
                        .weight(0.05f)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text("Pulsar")
                }
            }

        }
    }

}








