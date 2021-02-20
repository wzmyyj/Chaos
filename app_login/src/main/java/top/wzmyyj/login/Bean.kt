package top.wzmyyj.login

/**
 * Created on 2021/02/18.
 *
 * @author feling
 * @version 1
 * @since 1
 */
class Bean {

    var list: List<AA>? = null


    interface A {

        fun f() {
            print("AAAAAAA")
        }
    }

    class AA : A {

        var age: Int = 0
    }
}