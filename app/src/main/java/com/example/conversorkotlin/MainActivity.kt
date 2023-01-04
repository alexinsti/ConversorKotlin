package com.example.conversorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var unidad1 : TextView
    lateinit var unidad2 : TextView
    lateinit var valor1 : EditText
    lateinit var valor2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val opciones : Spinner = findViewById(R.id.spinner)
        unidad1 = findViewById(R.id.Unidad1)
        unidad2 = findViewById(R.id.Unidad2)
        valor1 = findViewById(R.id.Valor1)
        valor2 = findViewById(R.id.Valor2)

        unidad1.setText("Millas")
        unidad2.setText("Km")

        opciones.onItemSelectedListener=this

        valor1.addTextChangedListener{
            when(opciones.selectedItem.toString()){
                "Millas a Kilómetros"-> {
                    //para evitar que se activen infinitamente al modificar cada uno el del otro comprobamos el foco
                    if (valor1.hasFocus()) {
                        if (valor1.text.toString().length != 0) {
                            println(valor1.text.toString().length)
                            valor2.setText(millasAKm(valor1.text.toString()))
                        } else {
                            valor2.setText(null)
                        }
                    }
                }

                "Litros a Galones"-> {
                    if (valor1.hasFocus()) {
                        if (valor1.text.toString().length != 0) {
                            println(valor1.text.toString().length)
                            valor2.setText(lAGalones(valor1.text.toString()))
                        } else {
                            valor2.setText(null)
                        }
                    }
                }

                "Kilogramos a Libras"-> {
                    if (valor1.hasFocus()) {
                        if (valor1.text.toString().length != 0) {
                            println(valor1.text.toString().length)
                            valor2.setText(kgAlibras(valor1.text.toString()))
                        } else {
                            valor2.setText(null)
                        }
                    }
                }

                "Dólares a Euros"-> {
                    if (valor1.hasFocus()) {
                        if (valor1.text.toString().length != 0) {
                            println(valor1.text.toString().length)
                            valor2.setText(dolaresAEuros(valor1.text.toString()))
                        } else {
                            valor2.setText(null)
                        }
                    }
                }

                "Metros a Pies"-> {
                    if (valor1.hasFocus()) {
                        if (valor1.text.toString().length != 0) {
                            println(valor1.text.toString().length)
                            valor2.setText(metrosAPies(valor1.text.toString()))
                        } else {
                            valor2.setText(null)
                        }
                    }
                }
            }
        }

        valor2.addTextChangedListener{
            when(opciones.selectedItem.toString()){
                "Millas a kilómetros"-> {
                    if (valor2.hasFocus()) {
                        if (valor2.text.toString().length != 0) {
                            println(valor2.text.toString().length)
                            valor1.setText(millasAKm(valor2.text.toString()))
                        } else {
                            valor1.setText(null)
                        }
                    }
                }

                "Litros a Galones"-> {
                    if (valor2.hasFocus()) {
                        if (valor2.text.toString().length != 0) {
                            println(valor2.text.toString().length)
                            valor1.setText(galonesAL(valor2.text.toString()))
                        } else {
                            valor1.setText(null)
                        }
                    }
                }

                "Kilogramos a Libras"-> {
                    if (valor2.hasFocus()) {
                        if (valor2.text.toString().length != 0) {
                            println(valor2.text.toString().length)
                            valor1.setText(librasAKg(valor2.text.toString()))
                        } else {
                            valor1.setText(null)
                        }
                    }
                }

                "Dólares a Euros"-> {
                    if (valor2.hasFocus()) {
                        if (valor2.text.toString().length != 0) {
                            println(valor2.text.toString().length)
                            valor1.setText(eurosADolares(valor2.text.toString()))
                        } else {
                            valor1.setText(null)
                        }
                    }
                }

                "Metros a Pies"-> {
                    if (valor2.hasFocus()) {
                        if (valor2.text.toString().length != 0) {
                            println(valor2.text.toString().length)
                            valor1.setText(piesAMetros(valor2.text.toString()))
                        } else {
                            valor1.setText(null)
                        }
                    }
                }
            }
        }

    }
    /*
Millas a KM
Litros a Galones
Kilos a Libras
Dolares a Euros
Metros a Pies
*/
    val kmAMillas : Double = 1.60934
    val millasAKm : Double = 0.621371
    val lAGalones : Double = 0.219969
    val galonesAL : Double = 4.54609
    val kgAlibras : Double = 2.20462
    val librasAKg : Double = 0.453592
    val eurosADolares : Double = 0.98
    val dolaresAEuros : Double = 1.02
    val metrosAPies : Double = 3.28084
    val piesAMetros : Double = 0.3048


    fun kmAMillas(km: String): String {
        val resultado: Double
        resultado = km.toDouble()  * kmAMillas
        return resultado.toString()
    }

    fun millasAKm(millas: String): String {
        val resultado: Double
        resultado =  millas.toDouble() * millasAKm
        return resultado.toString()
    }

    fun lAGalones(l: String): String {
        val resultado: Double
        resultado = l.toDouble()  * lAGalones
        return resultado.toString()
    }

    fun galonesAL(galones: String): String {
        val resultado: Double
        resultado = galones.toDouble()  * galonesAL
        return resultado.toString()
    }

    fun kgAlibras(kg: String): String {
        val resultado: Double
        resultado = kg.toDouble() * kgAlibras
        return resultado.toString()
    }

    fun librasAKg(libras: String): String {
        val resultado: Double
        resultado = libras.toDouble()  * librasAKg
        return resultado.toString()
    }

    fun eurosADolares(euros: String): String {
        val resultado: Double
        resultado = euros.toDouble()  * eurosADolares
        return resultado.toString()
    }

    fun dolaresAEuros(dolares: String): String {
        val resultado: Double
        resultado = dolares.toDouble() * dolaresAEuros
        return resultado.toString()
    }

    fun metrosAPies(metros: String): String {
        val resultado: Double
        resultado = metros.toDouble() * metrosAPies
        return resultado.toString()
    }

    fun piesAMetros(pies: String): String {
        val resultado: Double
        resultado = pies.toDouble()  * piesAMetros
        return resultado.toString()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        println("cambio")
        valor1.text=null
        valor2.text=null

        when(p2){
            0 -> {
                unidad1.setText("Millas")
                unidad2.setText("Kilómetros")
            }

            1 -> {
                unidad1.setText("Litros")
                unidad2.setText("Galones")
            }

            2 -> {
                unidad1.setText("Kilogramos")
                unidad2.setText("Libras")
            }

            3 -> {
                unidad1.setText("Dólares")
                unidad2.setText("Euros")
            }

            4 -> {
                unidad1.setText("Metros")
                unidad2.setText("Pies")
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

}