package com.example.recyclerview01_2025

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleRecyclerview(modifier: Modifier) {
    //val list = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10")
    val list = List(10000) { "item $it" }
    Box(modifier = modifier.fillMaxSize()) {


        /*   LazyColumn {
               item { Text(text = "01") }
               item { Text(text = "02") }
               item { Text(text = "03") }
               item { Text(text = "04") }
           }*/

        /*  LazyColumn {
              items(800) {
                  // Text("item $it")
                      item ->
                  Text(text = "$item")
              }
          }*/


        LazyColumn {
            item { Text("Cabecera") }
            items(list) {
                Text(text = it)
            }
            item { Text("Pie de página") }
        }
    }
}


@Composable
fun Recyclerview_01(modifier: Modifier) {
    val context = LocalContext.current
    Box(modifier = modifier.fillMaxSize()) {

/*        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(getGuitars()) {
                ItemGuitar(it)
            }
        }*/
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // items(getGuitars()) {
            //   ItemGuitar(it)
            //}
            items(getGuitars()) {
                ItemGuitar02(it) {
                    Toast.makeText(
                        context,
                        "${it.marca} ${it.modelo}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }
}


@Composable
fun ItemGuitar(model: Model) {
    Card(border = BorderStroke(2.dp, Color.Black), modifier = Modifier.width(200.dp)) {
        Column {
            Image(
                painter = painterResource(id = model.foto),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(model.marca, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                model.modelo,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 10.sp
            )
        }
    }

}


@Composable
fun ItemGuitar02(model: Model, onItemSelected: (Model) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(model) }

    ) {
        Column {
            Image(
                painter = painterResource(id = model.foto),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(model.marca, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                model.modelo,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 10.sp
            )
        }
    }

}


fun getGuitars(): List<Model> {
    return listOf(
        Model("Fender", "Stratocaster", R.drawable.fenderstratocaster),
        Model("Fender", "Telecaster", R.drawable.fendertelecaster),
        Model("Gibson", "Les Paul", R.drawable.gibsonlespaul),
        Model("Gibson", "ES 175", R.drawable.gibson175),

        Model("Fender", "Stratocaster", R.drawable.fenderstratocaster),
        Model("Fender", "Telecaster", R.drawable.fendertelecaster),
        Model("Gibson", "Les Paul", R.drawable.gibsonlespaul),
        Model("Gibson", "ES 175", R.drawable.gibson175),

        Model("Fender", "Stratocaster", R.drawable.fenderstratocaster),
        Model("Fender", "Telecaster", R.drawable.fendertelecaster),
        Model("Gibson", "Les Paul", R.drawable.gibsonlespaul),
        Model("Gibson", "ES 175", R.drawable.gibson175),
    )

}



















