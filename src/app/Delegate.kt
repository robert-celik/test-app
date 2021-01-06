package app

import kotlin.random.Random
import kotlin.reflect.KProperty

class Delegate {
    var curValue = 0
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = curValue
    operator fun setValue(example: Example, property: KProperty<*>, value: Int) {
        curValue = Random.nextInt()
    }
}

class Example {
    var p: Int by Delegate()
}
