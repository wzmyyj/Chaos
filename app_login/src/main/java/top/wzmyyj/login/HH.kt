package top.wzmyyj.login

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created on 2021/02/07.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
class HH {


    fun f() {
        val d = Observable.create<String> { it.onNext("A") }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { it + "a" }
            .flatMap { Observable.just("A") }
            .takeLast(100,TimeUnit.MILLISECONDS)
            .onErrorReturn { "A" }
            .subscribe({ println(it) }, { print("cc") }, {}, {})
    }
}