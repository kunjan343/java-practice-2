/* TestArrayList.java
 * This is a project code from Video in class */

import java.util.ArrayList;

// test cityList and list of Circles 

public class TestArrayList {

    public static void main(String[] args) {
        // Create a list to store cities
        ArrayList<String> cityList = new ArrayList<String>();

        // Add some cities in the list
        cityList.add("London");
        // cityList now contains [London]
        cityList.add("Denver");
        // cityList now contains [London, Denver]
        cityList.add("Paris");
        // cityList now contains [London, Denver, Paris]
        cityList.add("Miami");
        // cityList now contains [London, Denver, Paris, Miami]
        cityList.add("Seoul");
        // contains [London, Denver, Paris, Miami, Seoul]
        cityList.add("Tokyo");
        // contains [London, Denver, Paris, Miami, Seoul, Tokyo]

        System.out.println("List size? " + cityList.size());
        System.out.println("Is Miami in the list? " +
                cityList.contains("Miami"));
        System.out.println("The location of Denver in the list? "
                + cityList.indexOf("Denver"));
        System.out.println("Is the list empty? " +
                cityList.isEmpty()); // Print false

        // Insert a new city at index 2
        cityList.add(2, "Xian");
        // contains [London, Denver, Xian, Paris, Miami, Seoul, Tokyo]

        // Remove a city from the list
        cityList.remove("Miami");
        // contains [London, Denver, Xian, Paris, Seoul, Tokyo]

        // Remove a city at index 1
        cityList.remove(1);
        // contains [London, Xian, Paris, Seoul, Tokyo]

        // Display the contents in the list
        System.out.println(cityList.toString());

        System.out.println("Display the contents in the list in reverse order:");
        for (int i = cityList.size() - 1; i >= 0; i--)
            System.out.print(cityList.get(i) + " ");
        System.out.println();

        // Create a list to store two circles
        ArrayList<Circle> circleList = new ArrayList<>();

        // Add two circles
        circleList.add(new Circle(2));
        circleList.add(new Circle(3));

        System.out.println("List of circles:");

        System.out.println("Display the content of circleList:");
        for (int i = 0; i < circleList.size(); i++)
            System.out.print(circleList.get(i) + " ");
        System.out.println();


        System.out.println("List size? " + circleList.size());
        System.out.println("Call toString() method for circleList objects:");
        System.out.println(circleList.toString());


        // Display the area of the first circle in the list
        System.out.println("The area of the second circle: " +
                ((Circle) circleList.get(1)).getArea());

        System.out.println(circleList.get(0).equals(circleList.get(1)));
    }
}
