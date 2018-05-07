package defense

import offense.Rocket
import java.util.Observable

class Radar : Observable() {


    private val foundRockets = mutableSetOf<Rocket>()

    open fun newRocketInAirSpace(rocket: Rocket) {
        foundRockets.add(rocket)
        setChanged()
        notifyObservers(rocket)
    }

    open fun rocketDestroyed(rocket: Rocket){
        foundRockets.remove(rocket)
    }
}