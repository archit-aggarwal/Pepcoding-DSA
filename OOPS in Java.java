// import java.util.*;

// // class A{
// //     public void earlyBind(){
// //         System.out.println("Early Bind");
// //     }    

// //     public void lateBind(){
// //         System.out.println("Late Bind in Parent Class");
// //     }
// // }

// // class B extends A{
// //     @Override
// //     public void lateBind(){
// //         System.out.println("Late Bind in Child Class");
// //     }
// // }

// // A obj = new B();
// // obj.earlyBind();
// // obj.lateBind();

// // class Cuboid{
// //     int length;
// //     int breadth;
// //     int height;
    
// //     // Explicit Default Constructor
// //     public Cuboid(){
// //         // System.out.println(" Hi I am before Constructor Chaining "); // this is not possible
// //         this(1);
// //         System.out.println(" Hi I am after Constructor Chaining "); // this is possible
// //     }
    
// //     public Cuboid(int side){
// //         this(side, side, side);
// //     }
    
// //     public Cuboid(int length, int breadth){
// //         this(length, breadth, 1);
// //     }
    
// //     public Cuboid(int length, int breadth, int height){
// //         System.out.println(length + " " + breadth + " " + height);
// //         this.length = length;
// //         this.breadth = breadth;
// //         this.height = height;
// //     }
    
// //     public int volume(){
// //         return (this.area() * this.height);
// //     }
    
// //     public Cuboid join(Cuboid other){
// //         this.length += other.length;
// //         this.breadth += other.breadth;
// //         this.height += other.height;
// //         return this;
// //     }
// //     // obj4.join(obj3);
    
// //     public int area(){
// //         return (this.length * this.breadth);
// //     }
// // }

// // // class customInteger{
// // //     int val;
    
// // //     public customInteger(int newVal){
// // //         val = newVal; // autoboxing    
// // //     }
    
// // //     public String toString(){
// // //         return Integer.toString(val); // unboxing
// // //     }
// // // }

// // class Student{
// //     private int marks;
// //     String name;
// //     int rollNo;
// //     static String university = "Pepcoding";
// //     static String course = "BTech";
    
// //     // Implicit Default Constructor
// //     // Student(){
// //     // }
    
// //     // Explicit Default Constructor
// //     Student(){
// //         marks = 0;
// //         name = null;
// //         rollNo = 0;
// //     }
    
// //     Student(int marks, String name, int rollNo){
// //         // System.out.println(this);
// //         this.marks = marks;
// //         this.name = name;
// //         this.rollNo = rollNo;
// //     }
    
// //     Student(int marks, int rollNo, String name) {
// //         // System.out.println(this);
// //         this.marks = marks;
// //         this.name = name;
// //         this.rollNo = rollNo;
// //     }
    
// //     // copy constructor
// //     Student(Student obj){
// //         this.name = obj.name; // shallow copy
// //         // this.name = obj.name; // deep copy
// //         this.marks = obj.marks;
// //         this.rollNo = obj.rollNo;
// //     }
    
// //     public int getMarks(){
// //         // Getter
// //         return this.marks;
// //     }
    
// //     public void setMarks(int marks, String password){
// //         // Setter
// //         if(password == "Pepcoding"){
// //             this.marks = marks;    
// //         }
// //     }
    
// //     void study(String subject){
// //         studyUniversity();
// //         System.out.println(name + " studies " + subject);
// //     }
    
// //     void exam(){
// //         System.out.println("Student gives exam");
// //     }
    
// //     static void studyCourse(){
// //         System.out.println("Student studies " + course) ;
// //     }
    
// //     static void studyUniversity(){
// //         studyCourse();
// //         System.out.println("Student studies in " + university + " university ") ;
        
// //         // This cannot be referenced inside a static method
// //         // non-static variable this cannot be referenced from a static context
// //     }
// // }

// class MusicPlayer{
//     double radio;    
// }

// class DJ{
//     MusicPlayer player;    
// }

// // this. -> Properties
// // this(); -> Constructor

// class Car{
//     int gear;
//     int wheels;
//     String engine;
//     MusicPlayer player;
// }

// class FlyingCar extends Car{
//     String wings;
// }

// // class HydroCar extends Car{
// //     String pedal;    
// // }

// // // This is Multiple inheritance which is not possible
// // class FlyingHydroCar extends FlyingCar, HydroCar{
// //     String pedalAndWing;
// // }

// public class Main{
    
//     public static void main(String[] args){
//         FlyingCar obj = new FlyingCar();
//         obj.gear = 5;
//         obj.wheels = 4;
//         obj.engine = "Electric";
//         obj.wings = "Metallic"; 
//         // Accessing Parent Class' Member from Child Class Object is possible
//         System.out.println(obj.gear + " " + obj.wheels + " " + obj.engine + " " + obj.wings);
        
//         Car obj2 = new Car();
//         obj2.gear = 5;
//         obj2.wheels = 4;
//         obj2.engine = "Electric";
//         obj2.player.radio = 93.5;
//         // obj2.wings = "Metallic"; 
        
//         // Accessing Child Class' Member from Parent Class Object is not possible
//     }
    

//     // public static void swap4(Student a, Student b){
//     //     Student temp = new Student();
//     //     temp.marks = a.marks;
//     //     temp.rollNo = a.rollNo;
        
//     //     a.marks = b.marks;
//     //     a.rollNo = b.rollNo;
        
//     //     b.marks = temp.marks;
//     //     b.rollNo = temp.rollNo;
//     // }
    
//     // public static void swap3(Student a, Student b){
//     //     Student temp = a;
//     //     a.marks = b.marks;
//     //     a.rollNo = b.rollNo;
//     //     b.marks = temp.marks;
//     //     b.rollNo = temp.rollNo;
//     // }
    
//     // public static void swap1(Student a, Student b){
//     //     Student temp = a;
//     //     a = b;
//     //     b = temp;
//     // }
    
//     // public static void main(String[] args){
    
//         // Student archit = new Student(10, "Archit", 0);
//         // archit.setMarks(20, "Pepcoding");
//         // archit.setMarks(30, "DTU");
        
//         // System.out.println(archit.getMarks() + " " + archit.name + " " + archit.rollNo + " " + Student.university);
//         // archit.study("DSA");
        
//         // // Student.study();
        
//         // // Student.studyUniversity();
        
//         // // Student sumeet = new Student(20, 2, "Sumeet");
//         // // System.out.println(sumeet.marks + " " + sumeet.name + " " + sumeet.rollNo + Student.university);
//         // // sumeet.study();
        
//         // // Student temp = new Student(archit);
//         // // System.out.println(temp.marks + " " + temp.name + " " + temp.rollNo);
        
//         // // archit.study("DSA");
//         // // sumeet.study("OOPS");
//         // // archit.name.append(" Aggarwal");
//         // // System.out.println(temp.name);
        
//         // // Cuboid obj1 = new Cuboid();
//         // // Cuboid obj2 = new Cuboid(10);
//         // // Cuboid obj3 = new Cuboid(20, 25);
//         // // Cuboid obj4 = new Cuboid(30, 40, 50);
//         // // System.out.println(obj4.area());
//         // // System.out.println(obj4.volume());
//         // // Cuboid obj5 = obj4.join(obj3);
//         // // System.out.println(obj5.length + " " + obj5.breadth + " " + obj5.height);
//         // // System.out.println(obj4.length + " " + obj4.breadth + " " + obj4.height);
        
//     // }
// }


import java.util.*;

class Car{
    int gear;
    String engine;
    
    Car(){
        System.out.println("Car Constructor Execution");
    }
    
    Car(int gear){
        this.gear = gear;
    }
    
    Car(int gear, String engine){
        this.gear = gear;
        this.engine = engine;
    }
    
    void drive(){
        System.out.println("Car is running");
    }
}

class FlyingCar extends Car{
    String wings;
    int gear;
    
    FlyingCar(){
        super(5, "Petrol");
    }
    
    FlyingCar(String wings){
        super(5, "Petrol");
        this.wings = wings;
    }
    
    FlyingCar(int gear, String engine, String wings){
        super(gear, engine);
        this.wings = wings;
    }
    
    void display(){
        System.out.println(this.wings + " " + gear + " " + super.engine);
        super.drive();
    }
}

// class HydroCar extends Car{
//     String pedal;
// }

// Multiple Inheritance is not possible in Java
// class FlyingHydroCar extends FlyingCar, HydroCar{
//     String windShield;   
// }

public class Main{
    
    public static void main(String[] args){
        FlyingCar obj = new FlyingCar(5, "Electric", "Aluminium");
        System.out.println(obj.engine);
        obj.display();
    }
}
