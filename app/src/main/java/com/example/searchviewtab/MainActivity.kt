package com.example.searchviewtab

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val itemsList = listOf(
            "Apple",
            "Apricot",
            "Avocado",
            "Banana",
            "Blackberry",
            "Blueberry",
            "Cantaloupe",
            "Cherry",
            "Coconut",
            "Cranberry",
            "Date",
            "Dragonfruit",
            "Durian",
            "Elderberry",
            "Fig",
            "Grape",
            "Grapefruit",
            "Guava",
            "Honeydew",
            "Jackfruit",
            "Jujube",
            "Kiwi",
            "Kumquat",
            "Lemon",
            "Lime",
            "Lychee",
            "Mango",
            "Mulberry",
            "Nectarine",
            "Orange",
            "Papaya",
            "Passionfruit",
            "Peach",
            "Pear",
            "Pineapple",
            "Plum",
            "Pomegranate",
            "Quince",
            "Raspberry",
            "Redcurrant",
            "Strawberry",
            "Tangerine",
            "Watermelon"
        )


        setContent {
            val (searchQuery, onSearchQueryChange) = remember { mutableStateOf("") }
            val filteredItems = remember(itemsList, searchQuery) {
                itemsList.filter { it.contains(searchQuery, ignoreCase = true) }
            }

            Scaffold(
                topBar = {
                    SearchView(
                        searchQuery = searchQuery,
                        onSearchQueryChange = onSearchQueryChange,
                        onClearQuery = { onSearchQueryChange("") }
                    )
                }
            ) {
                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = {
                            startActivity(Intent(this@MainActivity, tabactivity::class.java))
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text("wanna check out whatsapp")
                    }
                    FilterableList(
                        items = filteredItems,
                        filter = searchQuery
                    )
                }
            }
        }

    }
}
