package java_Imp_Concepts;
/*
https://www.geeksforgeeks.org/can-we-overload-or-override-static-methods-in-java/
 */
class Base {

    public static void display() {
        System.out.println("Static or class method from Base");
    }

    public void print()  {
        System.out.println("Non-static or Instance method from Base");
    }

    //we can overload static methods -  yes
    public static void fun(){
        System.out.println("fun");
    }

    public static void fun(int a){
        System.out.println("fun"+ a);
    }

//    we cannot define two same method name with static & non static
//    public static void fun3(){
//        System.out.println("func3");
//    }
//    public void fun3(){
//        System.out.println("second func3");
//    }

    public static void fun3(){
        System.out.println("fun3");
    }
    public void fun3(int a){
        System.out.println("second fun3 "+ a);
    }

}

// Subclass
class Derived extends Base {

    // Static is removed here (Causes Compiler Error)
//    public void display() {
//        System.out.println("Non-static method from Derived");
//    }

  // Static is added here (Causes Compiler Error)
//    public static void print() {
//        System.out.println("Static method from Derived");
//    }

  public static void display() {
      System.out.println("Non-static method from Derived");
  }

    public  void print() {
        System.out.println("Static method from Derived");
    }

}
public class Inheritence_Example {
    public static void main(String[] args) {
        Base baseobj = new Base();
        Base.fun();
        Base.fun(2);
        Base.fun3();
        baseobj.fun3(5);


        Base base = new Derived();
        base.display();
        base.print();

        Derived derived = new Derived();
        derived.display();
        derived.print();

    }
}
