package es.fpalonso.moneysaver

import androidx.lifecycle.*

class OneTimeObserver<T>(private val onChange: (T) -> Unit): LifecycleOwner, Observer<T> {
    private val lifecycle = LifecycleRegistry(this)
    init {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycle
    }

    override fun onChanged(data: T) {
        onChange(data)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }
}

fun<T> LiveData<T>.observeOnce(onChange: (T) -> Unit) {
    val observer = OneTimeObserver(onChange)
    this.observe(observer, observer)
}
