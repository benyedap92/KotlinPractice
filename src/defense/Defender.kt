package defense

import offense.Rocket
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Observer
import java.util.Observable
import java.util.Random

class Defender(val radar: Radar) : Observer {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")

    init {
        println("Defender initialized")
    }

    override fun update(o: Observable?, arg: Any?) {
        when (o) {
            is Radar -> {
                if (arg is Rocket) {
                    println("A ${arg.type.toString()} is detected. Action required.")
                    launchAntiBallisticMissile(arg)
                }
            }
            else -> println(o?.javaClass.toString())
        }
    }

    private fun launchAntiBallisticMissile(rocket: Rocket) {
        for (i in 1..3) {
            val time = LocalDateTime.now().format(formatter)
            println("Antimissile rocket launched for $i. time at $time")
            Thread.sleep(1000)
            val result = radar.wasAntiMissileSuccessful(rocket)
            val resultString = if (result) "successful" else "unsuccessful"
            println("Defense action was $resultString")
            if (result) {
                break
            }
            if (!result && i == 3) {
                println("WARNING! Anti-missile actions failed. Seoul must be evacuated immediately.")
            }
        }
        println("\n")
    }
}