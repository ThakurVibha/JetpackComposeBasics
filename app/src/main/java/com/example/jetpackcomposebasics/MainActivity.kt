package com.example.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyButtonComposable()
            GenerateNamesList()
        }
    }

}


//LazyColumn
@Composable
@Preview
fun MyList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) {
            MyColumnComposable()
        }

    }

}

@Composable
@Preview
fun MyColumnComposable() {
    //Column
    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(10.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Color(0xFF912121), RoundedCornerShape(30.dp))
                .fillMaxSize()
        ) {
            Text(
                "Vibha Thakur", color = Color.White,
                fontSize = 30.sp, fontWeight = FontWeight(800)
            )
            Text(
                "Android Developer",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight(700)
            )
            Text(
                "vibhathakur1297@gmail.com",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight(700)
            )
            Spacer(modifier = Modifier.size(20.dp))
            Image(
                painter = painterResource(id = R.drawable.codinglads),
                contentDescription = "dummy image"
            )
        }
    }

}


@Composable
@Preview
fun MyRowComposable(name: String = "Vibhu") {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Text(
            "Hi vibha", color = Color.DarkGray,
            fontSize = 30.sp, fontWeight = FontWeight(800)
        )
        Text("Yo Brooo", color = Color.Green, fontSize = 30.sp, fontWeight = FontWeight(700))
    }

}


@Preview
@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxSize()
    ) {
        Text(
            text = "Hi this is a box composable",
            color = Color.White, fontSize = 25.sp,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
        Text(
            text = "Yo bro who got you smile like that",
            color = Color.White, fontSize = 25.sp
        )
    }


}


//Button composable
@Composable
@Preview
fun MyButtonComposable() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by remember {
            mutableStateOf(0)
        }
        Text(text = count.toString(), color = Color.Black, fontSize = 30.sp)
        Button(
            onClick = {
                count++

            }) {
            Text(text = "Click Me!")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun GenerateNamesList() {
    var name by remember {
        mutableStateOf("")
    }

    var listOfNames by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedTextField(
                value = name, onValueChange = { it ->
                    name = it.toString()
                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        listOfNames = listOfNames + name
                    }
                }) {
                Text(text = "Add", color = Color.White)

            }
        }
        LazyColumn {
            items(listOfNames) { currentName ->
                Text(
                    text = currentName, modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)

                )
                Divider(
                    modifier = Modifier.padding(10.dp),
                    thickness = 1.dp,
                    color = Color.LightGray
                )


            }

        }

    }
}