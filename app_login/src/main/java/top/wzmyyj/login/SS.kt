package top.wzmyyj.login

/**
 * Created on 2021/02/18.
 *
 * @author feling
 * @version 1
 * @since 1
 */
class T {
    var a: Any? = null
    fun f(u: String) {
       a?.let {
            object : Inter {
                override fun e() {
                    print("A")
                }
            }
        }
    }

}

fun main() {
    val t = T()
    t.a = Any()
    t.f("u")
}

interface Inter {
    fun e()
}