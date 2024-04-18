package com.example.appmatriculataller

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appmatriculataller.ui.theme.AppMatriculaTallerTheme

class MainActivity : ComponentActivity() {
    lateinit var nombre : TextView
    lateinit var edad : EditText
    lateinit var materia : String
    lateinit var spn : Spinner
    lateinit var checkBox: CheckBox
    lateinit var button: Button
    val opciones : List<String> = listOf("Investigacion de Operaciones", "Desarrollo de Software VI","Desarrollo de Software V","Ingenieria de Software II, Arquitectura de Computadoras" )
    lateinit var adapter: ArrayAdapter<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializar()
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spn.adapter = adapter
    }
    fun inicializar() {
        nombre = findViewById(R.id.nombre)
        edad = findViewById(R.id.edad)
        spn = findViewById(R.id.spnMaterias)
        checkBox = findViewById(R.id.check)
        button = findViewById(R.id.btnMatricular)

    }
    fun matricular(view: View) {
        try {

        } catch (e : Exception) {

        }
    }
}



// ya estaba aqui no se que es, se genera por defecto
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppMatriculaTallerTheme {
        Greeting("Android")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
