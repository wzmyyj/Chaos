package top.wzmyyj.login

import com.google.gson.Gson

/**
 * Created on 2021/02/18.
 *
 * @author feling
 * @version 1
 * @since 1
 */
fun main(args: Array<String>) {
    val g = Gson()

    val s = "{\"list\":[{\"age\":1},{\"age\":2}]}"

    val b = g.fromJson(s, Bean::class.java)
    val a: Bean.A? =b.list?.firstOrNull()
    a?.f()
}