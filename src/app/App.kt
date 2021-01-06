package app

import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

interface AppState: RState {
    var g: Example
}

interface EventHandler {
    fun runIt()
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        g = Example()
    }

    override fun RBuilder.render() {

        val eventHandler = object:EventHandler {
            override fun runIt() {
                setState{
                    g.p += 1
                }
            }
        }

        div("App-header") {
            h2 {
                +"Welcome to React with Kotlin"
            }
        }
        p("App-intro") {
            +"To get started, edit "
            code { +"app/App.kt" }
            " and save to reload2.".unaryPlus()
        }
        button(eventHandler)
        div { +state.g.p.toString() }
    }
}

fun setupDb() {
    /*var conn : Connection
    val connectionProps = Properties()
    connectionProps.put("user", username)
    connectionProps.put("password", password)
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "127.0.0.1" +
                        ":" + "3306" + "/" +
                        "",
                connectionProps)
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }*/
}

fun RBuilder.button(eventHandler: EventHandler) {
    div {
        button {
            +"Knapp"
            attrs.onClickFunction = {
                eventHandler.runIt()
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
