import defense.Defender
import defense.Radar
import offense.Attacker
import java.lang.Thread.sleep
import java.util.Random

fun main(args: Array<String>) {

    val radar = Radar()
    val defender = Defender(radar)
    radar.addObserver(defender)
    val attacker = Attacker(radar)


    fun Random.nextInt(range: IntRange): Int {
        return range.start + nextInt(range.last - range.start)
    }

    for (i in 1..10) {
        println("Attack $i.")
        sleep(Random().nextInt(1000..5000).toLong())
        attacker.launchRocket()
    }
}
