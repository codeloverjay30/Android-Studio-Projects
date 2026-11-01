package com.otherdatatype.either1application

/*
See README.md
*/
import kotlin.*;

import arrow.core.Either

fun toInt(s:String): Either<NumberFormatException,Int> =
    if(s.matches(Regex("-?[0-9]+"))) {
        Either.Right(s.toInt())
    } else {
        Either.Left(NumberFormatException("$s is not a valid integer."))
    }

fun main(){
    val x = toInt("123")
    val value = when(x){
        is Either.Left -> when(x.a){
            is NumberFormatException -> "Not a number"
            else -> "Unknown error"
        }
        else -> "Number that was parsed: ${x.b}"
    }
}


