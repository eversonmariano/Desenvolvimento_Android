package co.tiagoaguiar.ganheinamega

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Aqui é onde se decide o que o APP irá fazer.
        setContentView(R.layout.activity_main)

        //Buscar os objetos e ter a refer~encias deles.
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        //opção 2: variavel que seja do tipo View.onClickListener (interface)
        //btnGenerate.setOnClickListener(buttonClickListener)

        //Opção 3: mais simples possível - bloco de código que será disparado pelo onClickListener
        btnGenerate.setOnClickListener {
            //Aqui oidenis cikicar bissa lógica de programação,
            // porque será disparado depois do evento de touch do usuário.

            val text = editText.text.toString()

            numberGenerator(text, txtResult)
        }

    }

    private fun numberGenerator(text: String, txtResult: TextView) {
       //falhas
        if (text.isEmpty()) {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }
        val qtd = text.toInt()
        if (qtd < 6 || qtd > 15) {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        //sucesso
        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true) {
            val number = random.nextInt(60) //gera de 0 ...59
            numbers.add(number + 1)

            if (numbers.size == qtd) {
                break
            }
        }

        txtResult.text = numbers.joinToString(" - ")


    }
}


//Opção 1: XML
/*fun buttonClicked(view: View){
    Log.i("Teste", "botao clicado!!!")
}*/

//Opção2
/*  val buttonClickListener = View.OnClickListener {
      Log.i("teste2", "botao clicado!")
  }*/

/* val buttonClickListener = object : View.onClickListener {
     //quem chama o onclick é o próprio SDK do Android que dispara após o evento de touch
     fun onCick(v: View?) {
         Log.i("Teste", "Botao clicado!!!")
     }*/




