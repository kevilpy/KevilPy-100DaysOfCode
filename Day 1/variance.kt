/**
 * variance is of two type in kotlin
 * 1. Declaration-site variance : using in and out keyword
 * 2.use-site variance : Type Projection
 */

// creating a simple class
// without using out keyword we can not assign instance or object of WithoutOut class to the reference of its SuperType
class NoOut<T> ( val value: T){
    fun get(): T{
        return value
    }
}

// this is the same class as above but we have used out keyword this time
class AwesomeOut<out T> (val value: T) {
    fun get(): T = value
}


class InClass< in T>{
    fun toString(value: T): String {
            return value.toString()
    }
}
fun main(){
    // Out keyword

    // assigning the instance of string to the reference of its supertype Any
    val name: String = "kevil"
    val refOfAny: Any = name
    // so as you can see we can assign instance of String to the reference of its supertype Any

    // But that's not the case with standard generic classes so lets ty it out
   // creating object or instance of the generic WithoutOut Class
    val objOne: NoOut<String> = NoOut("This class is without out keyword ")

    // now trying to assign the  objectOne to reference  that is super type of it
    // val reference: NoOut<Any> = objOne
    // this will generate compile time error

    /**
     * The standard generic class or generic function that are already defined
     * for  a particular data type can not accept or return another data type
     *
     *  (eg. reference of <Any> cant accept instance of <String>)
     */

    // so lets create the object of AwesomeOut class which has out keyword
    val objTwo: AwesomeOut<String> = AwesomeOut("This class has  Out keyword  ")
    val referenceTwo: AwesomeOut<Any> = objTwo

    /** wow that's great
     * so as you can see now we can assign object or instance of the class AwesomeOut to the reference of its superType Any
     * and now we can guess why and in what situation we can use out keyword when creating generic classes
     */

    // okay so now lets talk about 'in' keyword

    val objThree: InClass<Number> = InClass()
    val refThree: InClass< Int > = objThree
    /**
     * so in this case if we want to assign instance of the InClass to the reference that is its sub type we can use in keyword
     */

}
