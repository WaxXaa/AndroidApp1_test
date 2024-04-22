package com.example.appmatriculataller

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appmatriculataller.ui.theme.AppMatriculaTallerTheme


class MainActivity : AppCompatActivity() {
    private lateinit var nombre : TextView
    private lateinit var edad : EditText
    private lateinit var materia : String
    private lateinit var turno: String
    private lateinit var spn : Spinner
    private lateinit var checkBox: CheckBox
    private lateinit var button: Button
    private lateinit var radioGroup: RadioGroup
    private val opcionesMaterias : List<String> = listOf("Investigacion de Operaciones", "Desarrollo de Software VI","Desarrollo de Software V","Ingenieria de Software II"," Arquitectura de Computadoras" )
    private lateinit var adapter: ArrayAdapter<*>
    private val turnoMatutino = "Mañana"
    private val turnoTarde = "Tarde"
    private val turnoNoche = "Noche"
    private val materiasProfesorTurno : Map<String, Map<String, String>> = mapOf(
        opcionesMaterias[0] to mapOf(turnoMatutino to "Juan García", turnoTarde to "María Martínez", turnoNoche to "Luis López"),
        opcionesMaterias[1] to mapOf(turnoMatutino to "Ana González", turnoTarde to "Carlos Rodríguez", turnoNoche to "Laura Fernández"),
        opcionesMaterias[2] to mapOf(turnoMatutino to "Pedro Pérez", turnoTarde to "Sofía Gómez", turnoNoche to "Diego Sánchez"),
        opcionesMaterias[3] to mapOf(turnoMatutino to "Andrea Díaz", turnoTarde to "Javier Hernández", turnoNoche to "Andrea Ruiz"),
        opcionesMaterias[4] to mapOf(turnoMatutino to "Marta Castro", turnoTarde to "Pablo Ramírez", turnoNoche to "Elena Moreno")
    )
    private lateinit var mensajeMatricula : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializar()
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesMaterias)
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
            if(nombre.text.toString().isEmpty()) {
                nombre.error = "este campo es obligatorio"
                return
            }
            if(edad.text.toString().isEmpty()) {
                nombre.error = "este campo es obligatorio"
                return
            }
            val edadNum = edad.text.toString().toInt()

            val selectRadioButtonId = radioGroup.checkedRadioButtonId
            val selectRadioButton: RadioButton = findViewById(selectRadioButtonId)
            turno = selectRadioButton.text.toString()

            spn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    materia = parent?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
            //asigna profe en funcion de la materia y turno
            val profe = if(checkBox.isChecked) {
                materiasProfesorTurno[materia]?.get(turno)
            } else null

            //mostrar profesor en mensaje
            mensajeMatricula = if(profe != null) {
                "Informacion de Matricula \nNombre: ${nombre.text.toString()}\nEdad: $edadNum\nMateria: $materia\nTurno: $turno\nProfesor: $profe"
            } else {
                "Informacion de Matricula \nNombre: ${nombre.text.toString()}\nEdad: $edadNum\nMateria: $materia\nTurno: $turno"
            }



            val dialog = MatriculaDialogFragment()
            dialog.setMensaje(mensajeMatricula)
            dialog.show()

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
