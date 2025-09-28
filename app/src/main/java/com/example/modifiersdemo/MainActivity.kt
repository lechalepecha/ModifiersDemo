package com.example.modifiersdemo


import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifiersdemo.ui.theme.ModifiersDemoTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModifiersDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DemoScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DemoScreen(modifier: Modifier = Modifier){
    val mymodifier = modifier
        .border(width = 2.dp, color = Color.Gray)
        .padding(all = 15.dp)

    val secondmodifier = Modifier.height(100.dp)

    Column(
        Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            "Hello Compose",
            mymodifier.then(secondmodifier),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.padding(16.dp))

        CustomImage(image = R.drawable.kistunagi,
            Modifier
                .padding(16.dp)
                .width(300.dp)
                .clip(shape = RoundedCornerShape(30.dp)))
    }
}

@Composable
fun CustomImage(image: Int, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifiersDemoTheme {
        DemoScreen()
    }
}