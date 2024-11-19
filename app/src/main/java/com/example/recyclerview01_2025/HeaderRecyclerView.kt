package com.example.recyclerview01_2025

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeaderRecyclerView(modifier: Modifier) {
    // Agrupa las guitarras por su marca, resultando en un mapa donde
    // la clave es la marca (String) y el valor es una lista de guitarras.
    val guitarras: Map<String, List<Model>> = getGuitars().groupBy { it.marca }

    // Crea un contenedor que ocupa todo el espacio disponible y tiene un fondo gris.
    Box(modifier = modifier.fillMaxSize().background(Color.Gray)) {

        // LazyColumn es un contenedor eficiente para listas grandes,
        // renderiza solo los elementos visibles en pantalla.
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

            // Itera a través del mapa de guitarras agrupadas por marca.
            guitarras.forEach { (marca, guitarras) ->

                // stickyHeader asegura que el encabezado se mantenga visible
                // en la parte superior mientras sus elementos asociados están en pantalla.
                stickyHeader {
                    // Muestra el nombre de la marca como encabezado.
                    // El encabezado ocupa todo el ancho disponible y tiene un fondo gris.
                    Text(
                        marca,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray),
                        fontSize = 30.sp // Tamaño de fuente grande para destacar el encabezado.
                    )
                }

                // Muestra los elementos de la lista asociados con la marca actual.
                items(guitarras) { guitarra ->
                    // ItemGuitar02 representa cada guitarra en la lista.
                    // Se pasa la guitarra y una lambda vacía como acción.
                    ItemGuitar02(guitarra) { }
                }
            }
        }
    }
}
