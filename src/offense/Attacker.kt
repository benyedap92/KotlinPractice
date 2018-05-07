package offense

import defense.Radar
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Attacker (val radar:Radar){
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    fun launchRocket() {
        val time = LocalDateTime.now().format(formatter)
        println("Launching rocket to Seoul at $time")
        radar.newRocketInAirSpace(Rocket("C-101", "xy"))
    }
}
