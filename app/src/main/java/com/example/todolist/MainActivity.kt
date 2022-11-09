package com.example.todolist

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.ui.theme.TODOlistTheme

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
                    TopBar()
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.todo_list))},
        )
    }
}

@Composable
fun TaskAddBtn() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "追加")
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}

@Preview
@Composable
fun TaskAddBtnPreview() {
    TaskAddBtn()
}
