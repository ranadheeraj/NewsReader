package com.example.newsreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsreader.ui.theme.NewsReaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsReaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsReaderApp()

                }
            }
        }
    }
}

@Composable
fun Testing()
{

}
@Preview
@Composable
fun NewsReaderApp(){
    NewsReaderimage(
        modifier= Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))

}

@Composable
fun NewsReaderimage(modifier:Modifier =Modifier){
    var result by remember {mutableStateOf(1)}
    val image =when(result){
        1->R.drawable.figure_1
        2->R.drawable.figure4
        3->R.drawable.figure_2
        else->R.drawable.figure_3

    }
    Column(
        modifier =modifier,
        horizontalAlignment =Alignment.CenterHorizontally
    ){
        Image(
            painter =painterResource(image),
            contentDescription =result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick ={result =(1..3).random()}){
            Text(stringResource(R.string.start))
        }
    }

}