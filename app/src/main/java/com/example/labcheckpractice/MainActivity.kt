package com.example.labcheckpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labcheckpractice.ui.theme.LabCheckPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabCheckPracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    LacCheckerScreen()
                }
            }
        }
    }


@Composable
fun LacCheckerScreen() {
    var numComputers by remember { mutableStateOf("") }
    var numStudents by remember { mutableStateOf("") }
    var resultsText by remember{ mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ){
        OutlinedTextField(
            value = numComputers,
            onValueChange = { numComputers = it },
            label = { Text("Number of COmputers")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = numStudents,
            onValueChange = {numStudents = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Number of Students") }
        )
                Button(onClick = {
                 val computer = numComputers.toIntOrNull() ?: 0
                 val students = numStudents.toIntOrNull() ?: 0
                 val total  = students - computer

                 resultsText = if(students >= computer){
                     "Lab 10-140 will need $total more Computers."
                 }else{
                     "Lab 10-140 can be used for the test"
                 }
                },
                  modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Check Student Numbers")
                }
        Text(text = resultsText, fontSize = 15.sp,color= Color.Black)
            }

}

@Preview(showBackground = true)
@Composable
fun LabCheckerPreview() {
    LabCheckPracticeTheme {
        LacCheckerScreen()
    }
}
}