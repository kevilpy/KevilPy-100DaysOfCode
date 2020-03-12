package dayOne.test
// Practicing covariance and Contravariance -:

// creating Pets Class
// we used open keyword because by default kotlin classes are final
// and thus we can not use them for inheritance so we have to make them open so that we can extend from or inherit from them.
open class Pets(val name: String, val age: Int){
    fun eat() { }
    fun sleep() { }
}

class Dog(val dogName: String, val dogAge: Int ): Pets(dogName, dogAge )

class Cat(val catName: String, val catAge: Int ): Pets(catName, catAge)

// lets create a covariance class
// In kotlin to declare class covariant on a certain type parameter we put 'out' keyword before type parameter

// so lets create a class

class ElectronicItem<out T> (val item: T, hasBattery: Boolean ){

    fun <T> information(item: T): String{
        print("Electronic Item Name ${item.toString()}")
        return "this is string "
    }

}

open class Computer(val ram: Int, val  hardDiskMemory: Int){

    fun printInfo(){
        println("Ram: $ram")
        println("Hard Disk Space: $hardDiskMemory")
    }
    override fun toString(): String {
        return "Computer"
    }
}


// creating subtype of computer
class Laptop(ram: Int, hardDiskMemory: Int) : Computer(ram, hardDiskMemory){


    override fun toString(): String{
        return "Laptop"
    }
}

// creating another subtype of computer
class Desktop(val mRam: Int, val mHardDiskMemory: Int): Computer(mRam, mHardDiskMemory) {
    override fun toString():  String {
        return "Desktop"
    }
}

class InClass<in T>{
   override fun  toString(): String {
       return "this is instance of in class"
   }
}
fun main(){

    // creating list of dogs
    val dogList: List<Dog> = listOf(
            Dog("Tommy", 2),
            Dog("Stiffy", 3),
            Dog("bruce", 5)
    )

    //creating list of cats
    val catList: List<Cat> = listOf(
            Cat("sam", 2),
            Cat("misty", 1),
            Cat("kitty", 1)
    )

    println("-----------------------Feeding Dogs------------------------------ ")
    feedDogs(dogList)

    println("-----------------------------------Feeding cats-------------------------------- ")
    feedCats(catList)

    // using feetPets function to feed both cats and dogs
    println("-------------------------------------------------")
    feedPets(catList) // feeding cats
    feedPets(dogList) //feeding dogs


    println("-----------------------------------------------------------")

    // using printElectronicItem to demonstrate covariance
    // creating instance of Computer, Laptop, Desktop (note Computer is super type of Laptop and Desktop

    val computerOne: Computer = Computer(16, 1000)
    val desktopOne: Desktop = Desktop(4, 500)
    val laptopOne: Laptop = Laptop(8, 1000)

    // using printElectronicItem to print electronic item inside  ElectronicItem instance
    // creating instance of electronic item and putting Computer Instance inside
    val eItem: ElectronicItem<Computer> = ElectronicItem(computerOne, false  )
    printElectronicItem(eItem) // here the eIem is instance of ElectronicItem<Computer> and it matches the function signature

    // but if we want to pass the subtype of Computer (like Laptop or Desktop instances)
    val eItemTwo: ElectronicItem<Laptop> = ElectronicItem(laptopOne, true)
    // printElectronicItem(eItemTwo) so this line of code produces if we don't use out keyword before the type parameter
    // in class ElectronicItem signature eg. ElectronicItem<T> (val item: T, val hasBattery: boolean)
    // so we will add up the out keyword before type parameter so that subtype can be preserved or it can accept or store subtype
    // of specified or defined type argument

    // lets try that line again
    printElectronicItem(eItemTwo) //so now it accepts computer subtype

    // this is called covariance its all about preserving subtypes
    // on the other hand we have contravariance its reflection of covariance
    // in contravariance generic class or function supertype is preserved

    // creating object of  InClass and type parameter Int type
    // Note Number is super type of Int
    val inClassObject: InClass<Number> = InClass()

    //val ref: InClass<Int> = inClassObject // this will generate the compile time error
    // because we have'nt yet specified the 'in' keyword before the type parameter of InClass and thus
    // assigning (or passing as argument to function) instance of supertype to the reference of its sub type
    // lets add in keyword in InClass Type parameter
    // now again try to assign (or pass as argument ) the instance of supertype to its subtype reference

    val ref: InClass<Int>  = inClassObject
    println(ref.toString())

    // voila!!! now we can store or pass instance of supertype to the reference of its subtype
    // and that's the power of contravariance

}


fun feedDogs(dogList: List<Dog>){
    dogList.forEach {
        it.eat()
        println("${it.name} is eating")
    }
}

// now we also want to feed cats too soo we need to create another function to feed cats
fun feedCats(catList: List<Cat>){
    catList.forEach{
        it.eat()
        println("${it.name} is eating ")
    }
}

// soo we created the function that feeds cats but its totally similar to the function feedDogs and have the same thing to do
// so how can we use only single function that can feed cats and dogs both

// so one way to do that is to create a generic function

 fun <T> feed(list: List<T>) {
     list.forEach {
         // it.eat() // hey what happened here it does'nt compile
         // so we cant call the eat() function or method here because not very list type is going to have eat method in it
         // for example if the user pass int type of list (List<Int>) and we invoke or call .eat() method on it,
         // Then its going to generate compile time error
         // Because Int type does'nt have eat method defined  in it
     }
 }

// so what will be the better approach to feed both dogs and cats by using just one function
// to solve this problem we are going to create Pets Class and make Cat and Dog class subtype of it
// or in simple words we are going to inherit or extend Pets Class in  both the Dog and Cat class
// now we cant create a function which will feed not only dog or cat but whatever class that inherits pets class

fun feedPets(petList: List<Pets>){
    petList.forEach{
        it.eat()
        println("${it.name} is eating")
    }
}

// woo that works but how this actually happening
// i mean i specified the type of parameter of feed function to be List<Pets> so it should be accepting only Pets type
// but it also accepting its subtype like Dog and Cat why ??
// To know that we have to look at the List definition or code of its class (ctrl + left click) inn intelij
// or check out the documentation of the list and you will find its signature as interface List<out E>: Collection<E>


// we see the signature is -> public interface List<out E> : Collection<E>
// where the list is covariant on its element type
/** all we need to know is the acceptance criteria of type arguments when they don't match is that they are at least subtype
 * of the defined type argument The generic class that has this behavior we call it covariance class
 *Covariance class is a class where subtyping is preserved
 */

fun printElectronicItem(eItem: ElectronicItem<Computer>) {
    println(eItem.item.toString())
}

