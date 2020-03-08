import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Rectangle extends TwoDimensions {
    private double base;
    private double height;

    // constructor of the class
    public Rectangle( double base, double height) {
        super("Rectangle");
        this.base = base;
        this.height = height;
    }

    @Override
    /*
    Intent: To solve the area of a rectangle
    Post-condition: calculates the area of rectangle
    Post-condition: Display the area of rectangle
    Post-condition: returns area in type double
     */
    public double getArea() {
        double area = this.base * this.height;
        area = Double.parseDouble(String.format("%.2f", area)); // cast the answer to double
        System.out.println("Area = "+ this.base + " * " + this.height);
        System.out.println("Area = " + area + "\n");
        System.out.println();
        return area;
    }

    @Override
   /*
   Intent: To solve the perimeter of a rectangle
   Post-condition: calculates the perimeter of rectangle
   Post-condition: display the perimeter of rectangle
   Post-condition: returns the perimeter in type double
   Returns: perimeter
    */
    public double getPerimeter() {
        double perimeter = (2 * this.base) + (2 * this.height);
        perimeter  = Double.parseDouble(String.format("%.2f", perimeter)); // cast the answer to double
        System.out.println("P = ( 2 * " + this.base + " ) + ( 2 * " + this.height + " )");
        System.out.println("P = " + perimeter);
        System.out.println();
        return perimeter;
    }

    @Override
    /*
    Intent:To display information of rectangle
    Post-condition: calls rectangleInfo method and displays the information for rectangle
     */
    public void displayInformation() throws IOException {
        List<String> rectangleInfo = rectangleInfo();
        for(String line: rectangleInfo){
            System.out.println(line);
        }

    }

    /*
    Intent: To store rectangle information on a list
    Post-condition: reads a text file "rectangleInfo.text". This file contains information of rectangle.
    Post-condition : returns a List
     */
    public List<String> rectangleInfo() throws IOException {
        String str;
        List<String> list = new ArrayList<>();

        try (
            BufferedReader in = new BufferedReader(new FileReader("rectangleInfo.txt"))){
            while ((str = in.readLine()) != null) {
                list.add(str);
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File was not found.....");
        }
        return list;
    }


    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    //returns the string representation of the class
    public String toString() {
        return "Rectangle{" +
                "base = " + base +
                ", height = " + height +
                '}';
    }
}
