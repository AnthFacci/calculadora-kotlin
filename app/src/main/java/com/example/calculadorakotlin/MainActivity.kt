package com.example.calculadorakotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadorakotlin.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calculo = binding.calculo
        val result = binding.resultado

        binding.um.setOnClickListener {
            calculo.text = "${calculo.text}1"
        }
        binding.dois.setOnClickListener {
            calculo.text = "${calculo.text}2"
        }
        binding.tres.setOnClickListener {
            calculo.text = "${calculo.text}3"
        }
        binding.quatro.setOnClickListener {
            calculo.text = "${calculo.text}4"
        }
        binding.cinco.setOnClickListener {
            calculo.text = "${calculo.text}5"
        }
        binding.seis.setOnClickListener {
            calculo.text = "${calculo.text}6"
        }
        binding.sete.setOnClickListener {
            calculo.text = "${calculo.text}7"
        }
        binding.oito.setOnClickListener {
            calculo.text = "${calculo.text}8"
        }
        binding.nove.setOnClickListener {
            calculo.text = "${calculo.text}9"
        }
        binding.ce.setOnClickListener {
            calculo.text = ""
            result.text = ""
        }
        binding.parenteseOpen.setOnClickListener {
            calculo.text = "${calculo.text}("
        }
        binding.parenteseClose.setOnClickListener {
            calculo.text = "${calculo.text})"
        }
        binding.divisao.setOnClickListener {
            calculo.text = "${calculo.text}/"
        }
        binding.soma.setOnClickListener {
            calculo.text = "${calculo.text}+"
        }
        binding.subtracao.setOnClickListener {
            calculo.text = "${calculo.text}-"
        }
        binding.multiplicacao.setOnClickListener {
            calculo.text = "${calculo.text}*"
        }
        binding.ponto.setOnClickListener {
            calculo.text = "${calculo.text}."
        }
        binding.zero.setOnClickListener {
            calculo.text = "${calculo.text}0"
        }
        binding.delete.setOnClickListener{
            calculo.text = calculo.text.dropLast(1)
        }
        binding.botaoresultado.setOnClickListener{
         val resultadoCalculado = Expression(calculo.text.toString()).calculate()

            if(resultadoCalculado.isNaN()){
                result.text = "Expressão inválida!"
            }else{
                result.text = "${resultadoCalculado}"
            }
        }
    }
}