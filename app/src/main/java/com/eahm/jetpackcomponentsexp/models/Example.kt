package com.eahm.jetpackcomponentsexp.models

import com.eahm.jetpackcomponentsexp.ui.MainActivity


data class Example (
    val title: String = "",
    val subtitle: String  = "",
    val description: String  = "",
    val activity : Class<*> = MainActivity::class.java
)
