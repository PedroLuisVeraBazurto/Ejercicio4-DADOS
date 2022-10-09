package movil.ejercicio4_dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.Lanzar_dado)
        rollButton.setOnClickListener { rollDice() }
        // Realiza un lanzamiento al iniciar
        rollDice()
    }

    private fun rollDice() {
        // Crea un nuevo Objeto Dice con 6 lados
        val lanzada = Lanzamiento(6)
        val Resultado_Obt = lanzada.roll()
        // Encuentre el ImageView
        val diceImage: ImageView = findViewById(R.id.Imagen)
        // Determine qué ID de recurso extraíble usar en función de la tirada de dados
        val Recurso_Imagen = when (Resultado_Obt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Actualice ImageView con el ID
        diceImage.setImageResource(Recurso_Imagen)
        // Actualizar la descripción del contenido
        diceImage.contentDescription = Resultado_Obt.toString()
    }

}
//Clase con la logica de generar el numero aleatorio
class Lanzamiento(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

}