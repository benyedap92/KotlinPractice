package defense

import offense.Rocket
import java.util.*

class Radar : Observable() {


    private val foundRockets = mutableSetOf<Rocket>()

    open fun newRocketInAirSpace(rocket: Rocket) {
        foundRockets.add(rocket)
        setChanged()
        notifyObservers(rocket)
    }

    private fun rocketDestroyed(rocket: Rocket) {
        foundRockets.remove(rocket)
    }

    open fun wasAntiMissileSuccessful(rocket: Rocket): Boolean {
        val wasAntiMissileSuccessful = Random().nextBoolean()
        refreshMap(wasAntiMissileSuccessful, rocket)
        return wasAntiMissileSuccessful
    }

    private fun refreshMap(isEnemyRocketDestroyed: Boolean, rocket: Rocket) {
        if (isEnemyRocketDestroyed) {
            rocketDestroyed(rocket)
        }
    }
}