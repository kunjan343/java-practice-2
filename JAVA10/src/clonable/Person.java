package clonable;/*
 *  implements Cloneable interace demo
 */

public class Person implements Cloneable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person("Sam");

        System.out.println("Person name: " + p.getName());
        // Can you do this, if clone method in Person class is not public?
        Person pClone = p.clone();
        // print clone name
        System.out.println("Person's clone name: " + pClone.getName());
    }
}
