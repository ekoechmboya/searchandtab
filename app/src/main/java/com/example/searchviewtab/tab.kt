package com.example.searchviewtab

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TabsScreen() {
    val tabs = listOf("Chats", "Statuses", "Calls")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Whatsapp layout")
                },
                backgroundColor = Color.White,
                elevation = 8.dp
            )
        },
        content = {
            Column {
                TabRow(selectedTabIndex = selectedTabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(text = title) },
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index }
                        )
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    itemsIndexed(getTabContent(selectedTabIndex)) { index, content ->
                        Text(text = content, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    )
}

private fun getTabContent(tabIndex: Int): List<String> {
    return when (tabIndex) {
        0 -> {
            listOf("hello                        online")
        }
        1 -> {
            listOf("is it a holiday today or whaat", "hey my phone has been hacked by safaricom")
        }
        2 -> {
            listOf("I called you the other day and you did not pick", "you tried to call me but i was not available")
        }
        else -> {
            emptyList()
        }
    }
}
