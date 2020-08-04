package com.eahm.jetpackcomponentsexp.observable

import androidx.databinding.ObservableInt


class CounterObservableInt(value: Int = 0) : ObservableInt(value) {

    fun increment() {
        set(get() + 1)
    }

    fun decrement() {
        set(if (get() <= 1) 1 else get() - 1)
    }
}