package com.example.todolist

import android.content.ClipData
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.ui.theme.TODOlistTheme
import com.example.todolist.ui.theme.TaskItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOlistTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    todolistApp()
                }
            }
        }
    }
}

@Composable
fun todolistApp() {
    TODOlistTheme {
        Scaffold(
            topBar = { TopBar() }
        ) { padding ->
            HomeScreen()
        }
    }
}

@Composable
fun TopBar() {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.yarukoto))},
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "さがす")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "もっと")
                    
                }
            }
        )
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        Spacer(modifier = Modifier.height(16.dp))
        FABBtn()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

//タスク追加ボタンの実装
@Composable
fun FABBtn() {
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = {
                //BottomSheetDialogScreen()
            }
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "追加")
        }
    }) {

    }
}

@Composable
fun BottomSheetDialogScreen() {
    Surface(color = MaterialTheme.colors.background) {
        var taskName by remember { mutableStateOf("") }
        var taskScript by remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = taskName,
                onValueChange = {taskName = it},
                label = { Text(text = "タスク名")},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = taskScript,
                onValueChange = {taskScript = it},
                label = { Text(text = "説明")}
            )
            Row() {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "今日")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "やること")
                }
            }
            Row() {
                Button(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "ラベル")
                }
                Button(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "ラベル")
                }
                Button(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "ラベル")
                }
                Button(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "ラベル")
                }
                Button(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "ラベル")
                }
            }

        }

    }
}

@Composable
fun TaskList(item: TaskItem) {
    Row {
        Column {
            Text(text = item.title)
            Text(text = item.limit.toString())
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview
@Composable
fun todolistAppPreview() {
    todolistApp()
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}

@Preview
@Composable
fun TaskAddBtnPreview() {
    FABBtn()
}

@Preview
@Composable
fun BottomSheetDialogScreenPreview() {
    BottomSheetDialogScreen()
}

