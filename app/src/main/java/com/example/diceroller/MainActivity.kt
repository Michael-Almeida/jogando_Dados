package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declarar a localização do botão pelo ID
        val botaoJogar: Button = findViewById(R.id.button)

        //adicionando um listener de clique no botão
        botaoJogar.setOnClickListener {
            jogarDados()

            /*
            Passando um texto de resultado e indexando pelo id do textview
           val resultTextView: TextView = findViewById(R.id.resultado)
           resultTextView.text = "6"


            //adicionando um "brinde", mensagem a ser exibida
            val toastButton = Toast.makeText(this, "Dados Rolados!", Toast.LENGTH_SHORT)
            //exibindo o toast
            toastButton.show()
            */
        }
    }

    private fun jogarDados() {
        val dados = dados(6)
        val jogardados = dados.jogar()

        //encontrar a imagem no layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //determinar qual imagem aparecer de acordo com o resultado escolhido
        val drawableResource = when (jogardados) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //atualizando a imagem com o Id correto
        diceImage.setImageResource(drawableResource)

        //atualizar a descrição do conteudo
        diceImage.contentDescription = jogardados.toString()
    }

    class dados(private val numLados: Int) {
        fun jogar(): Int {
            return (1..numLados).random()
        }
    }
}