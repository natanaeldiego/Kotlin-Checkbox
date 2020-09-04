package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var checkBox: CheckBox
    lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.valorTexto)
        checkBox = findViewById(R.id.checkBox)
        botao = findViewById(R.id.button)

        /*
        checkBox.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                var textoExibir = ""
                if(isChecked) {
                    textoExibir = "Marcado"
                } else {
                    textoExibir = "Desmarcado"
                }
                Toast.makeText(applicationContext, textoExibir, Toast.LENGTH_LONG).show()
            }
        })
        */
        checkBox.setOnCheckedChangeListener {
                buttonView, isChecked ->  isChecked
            var textoExibir = criarTexto(isChecked)
            Toast.makeText(applicationContext, textoExibir, Toast.LENGTH_LONG).show()
            texto.text = textoExibir
        }

        botao.setOnClickListener{
            var textoExibir = criarTexto(checkBox.isChecked)
            Toast.makeText(applicationContext, textoExibir, Toast.LENGTH_LONG).show()
            texto.text = textoExibir
        }
    }

    private fun criarTexto(isChecked: Boolean): String {
        var textoExibir = ""
        if (isChecked) {
            textoExibir = "Marcado"
        } else {
            textoExibir = "Desmarcado"
        }
        return textoExibir
    }
}