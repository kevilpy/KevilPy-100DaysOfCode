// in class CoBox and Contrabox we have used in and out keyword while declaring
// and defining the class this is called declaration site variance

// co-variant class
class CoBox<out T> (t: T){
    val value: T = t // works fine
    // because property is declared as val which means its read-only

    // properties get also affected by out keyword  as functions or methods
    // var sameValue: T = t // does'nt compile
    // because the property is declared as var so the it is read-write and thus it has implicit
    // setter "set(value)" which takes the value of type or consume it thus its showing error

    //out position
    // with the "out" keyword type parameter can only be used as return type not as function or method parameter
    fun getStoredValue(): T{ // this is valid because we have only gave out the value (output) of type not take it as in or consumed it (t:T)

        return value
    }

    fun getStoredValueOne(thought: String = " kotlin is love "): T{ // no error coz we have'nt consumed or take value of type (t: T)
        println(thought)
        return value
    }

   // fun getStoredValueTwo(t: T): T = value
    // we cant do this because our class is covariant class
    // and in co-variant class we can only return or give out  values of type =  (): T
    // but we cant take them in as in line #10  (t: T) we are take value or reference of type T
    // which is invalid

}

// contra-variant class
class ContraBox<in T> (t: T){
     //val value: T  = t
    // cant do this  here because we giving out values of type T and the class is contra-variant
    // creating property declared as val or var creates implicit get() method which give out the value or output of type

    // with the keyword 'in' type parameter can only be used as method or function parameter not return type
    fun getStoredValue(value: T){ // here we only have consumed they value of type (t: T) and not given out the values of type (): T
        println(value.toString())
    }

    fun getStoredValueOne(value: T): String { // no error because we are not giving out value of type T
        return "this is string"
    }

   // fun getStoredValueTwo(value: T): T = value
    // this won't compile because we are giving out value or outputs of type (): T
    // we can only consume the value of type in contra-variant class
}


// summary
// covariant class -: we can give out the values (outputs) of type but cant consume it (t: T)
// contra-variant class -: we can consume the values or outputs of type(t: T) but cant give outputs or values () : T

class Box<T> (t: T){
    var value: T = t

    // class is neither covariant or contravariant so we can consume or give out value of type
    fun getBoxItem(): T = value

    fun setBoxItem(item: T) {
        value = item
    }

}


fun main(){
    // use site variance
    val intBox: Box<Int> = Box(10)
    val numberBox: Box<out Number> = intBox // we can accept the subtype of the type parameter (Int is subtype of Number )

    val numberBoxTwo:Box<Number> =  Box(10)
    val intBoxTwo:Box<in Int> = numberBoxTwo // we can accept the supertype of type parameter (Number is super-type of Int
    
}
