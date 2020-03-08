
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Circle extends TwoDimensions {

    private double radius;

    public Circle( double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    /*
    Intent: To calculate the area of circle
    Post-condition : Calculates the area of circle
    Post-condition: Displays the area of the circle
    Post-condition: Returns the area of the circle in double
     */
    public double getArea() {
        double area = 3.14 * this.radius * this.radius;
        area  = Double.parseDouble(String.format("%.2f", area));
        System.out.println("Area = 3.14 * " + this.radius + " * " + this.radius);
        System.out.println("Area = " + area + "\n");
        return area;
    }

    @Override
    /*
    Intent: To calculate the circumference of a circle
    Post-condition: Calculates the circumference of a circle
    Post-condition: Displays the circumference of a circle
    Post-condition: returns the circumference as a type double
     */
    public double getPerimeter() {
        double circumference = 2 * 3.14 * this.radius;
        circumference  = Double.parseDouble(String.format("%.2f", circumference));
        System.out.println("C = 2 * 3.14 * " + this.radius);
        System.out.println("C = " + circumference);
        return circumference;
    }

    @Override
    /*
    Intent: To display the information of a circle
    Post-condition: Calls circleInfo() method
                    Displays circle definition, area and perimeter examples
     */
    public void displayInformation() throws IOException {
        List<String> circleInfo = circleInfo();
        for(String line: circleInfo){
            System.out.println(line);
        }
    }

    /*
    Intent: To store circle information on a list
    Post-condition: reads a text file " circleInfo.text". This file contains information of circle.
    Post-condition : returns a List
     */
    public List<String> circleInfo() throws IOException {
        String str;
        List<String> list = new ArrayList<>();

        try (
            BufferedReader in = new BufferedReader(new FileReader("circleInfo.txt"))){
            while ((str = in.readLine()) != null) {
                list.add(str);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File was not found.....");
        }
        return list;
    }

    @Override
    // returns the string representation of Circle class
    public String toString() {
        return "Circle{" +
                "radius = " + radius +
                '}';
    }

    public double getRadius() {
        return radius;
    }
}
