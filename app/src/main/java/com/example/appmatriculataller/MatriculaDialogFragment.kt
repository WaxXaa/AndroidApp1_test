package com.example.appmatriculataller

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

public class MatriculaDialogFragment : DialogFragment() {
    private lateinit var mensaje: String
    fun setMensaje(mensaje: String) {
        this.mensaje = mensaje
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return getActivity()?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(mensaje)
                .setPositiveButton("aceptar") { dialog, _ ->
                    dialog.dismiss()
                }
            builder.setTitle("Informacion de Matricula")
            builder.create()
        } ?: throw IllegalStateException("Actividad no puede ser null")
    }

}