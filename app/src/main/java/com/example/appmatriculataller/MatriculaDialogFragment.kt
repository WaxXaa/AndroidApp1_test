package com.example.appmatriculataller

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ValidFragment")
abstract class MatriculaDialogFragment(private val mensaje: String) : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(mensaje)
                .setPositiveButton("aceptar") { dialog, _ ->
                    dialog.dismiss()
                }
            builder.create()
        } ?: throw IllegalStateException("Actividad no puede ser null")
    }


}