package castro.cristina.calculadora_247580

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textResultado = findViewById<TextView>(R.id.textResultado)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        val buttonSuma = findViewById<Button>(R.id.buttonSuma)
        val buttonResta = findViewById<Button>(R.id.buttonResta)
        val buttonMultiplicacion = findViewById<Button>(R.id.buttonMultiplicacion)
        val buttonDivision = findViewById<Button>(R.id.buttonDivision)
        val buttonEquals = findViewById<Button>(R.id.buttonEquals)
        val buttonDEL = findViewById<Button>(R.id.buttonDEL)
        val buttonAC = findViewById<Button>(R.id.buttonAC)

        val botonesNumeros = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        val botonesOperaciones = listOf(buttonSuma, buttonResta, buttonMultiplicacion, buttonDivision)

        for (boton in botonesNumeros) {
            boton.setOnClickListener {
                textResultado.text = textResultado.text.toString() + boton.text
            }
        }

        for (boton in botonesOperaciones) {
            boton.setOnClickListener {
                textResultado.text = textResultado.text.toString() + " " +  boton.text + " "

            }
        }

        buttonDEL.setOnClickListener {
            val textoActual = textResultado.text.toString()
            if (textoActual.isNotEmpty()) {
                textResultado.text = textoActual.dropLast(1)
            }
        }

        buttonAC.setOnClickListener {
            textResultado.text = ""
        }

        buttonEquals.setOnClickListener {
            val expresion = textResultado.text.toString()
            try {
                val resultado = evaluarExpresion(expresion)
                textResultado.text = resultado.toString()
            } catch (e: Exception) {
                textResultado.text = "Error"
            }
        }
    }


    private fun evaluarExpresion(expresion: String): Int {
        val partes = expresion.split(" ")
        if (partes.size < 3) return 0

        val num1 = partes[0].toIntOrNull()
        val operador = partes[1]
        val num2 = partes[2].toIntOrNull()

        if (num1 == null || num2 == null) return 0

        return when (operador) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "x" -> num1 * num2
            "/" -> if (num2 != 0) num1 / num2 else 0
            else -> 0
        }
    }

}