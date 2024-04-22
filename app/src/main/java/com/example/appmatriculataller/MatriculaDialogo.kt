package com.example.appmatriculataller

import android.app.AlertDialog

public class MatriculaDialogo {
    private lateinit var mensaje: String
    fun setMensaje(mensaje: String) {
        this.mensaje = mensaje
    }

/*    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return getActivity()?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(mensaje)
                .setPositiveButton("aceptar") { dialog, _ ->
                    dialog.dismiss()
                }
            builder.setTitle("Informacion de Matricula")
            builder.create()
        } ?: throw IllegalStateException("Actividad no puede ser null")
    }*/
 fun mostrar(ctx: MainActivity) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(ctx)
    builder
        .setMessage(mensaje)
        .setTitle("Informacion de Matricula")
        .setPositiveButton("Aceptar", null)

    val dialog = builder.create()
    dialog.show()
}

}