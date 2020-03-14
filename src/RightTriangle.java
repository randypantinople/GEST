import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RightTriangle extends TwoDimensions{

    private double base;
    private double height;
    private double hypotenuse;

    //constructor for the class
    public RightTriangle( double base, double height, double hypotenuse) {
        super("Triangle");
        this.base = base;
        this.height = height;
        this.hypotenuse = hypotenuse;

    }

    @Override
    /*
    Intent: To solve the area of a right triangle
    Post-condition: calculates the area of right triangle
    Post-condition: Display the area of rght triangle
    Post-condition: returns area in type double
     */
    public double getArea() {
        double area = (this.base * this.height) / 2;
        area = Double.parseDouble(String.format("%.2f", area)); // cast the answer to double
        System.out.println("Area = ( "+ this.base + " * " + this.height + " ) / 2");
        System.out.println("Area = " + area + "\n");
        return area;
    }

    @Override
    /*
   Intent: To solve the perimeter of a right triangle
   Post-condition: calculates the perimeter of right triangle
   Post-condition: display the perimeter of right triangle
   Post-condition: returns the perimeter in type double
   Returns: perimeter
    */
    public double getPerimeter() {
        double perimeter =  this.base +  this.height + this.hypotenuse;
        perimeter  = Double.parseDouble(String.format("%.2f", perimeter));
        System.out.println("P = " + this.base + " + " + this.height + " + " + this.hypotenuse);
        System.out.println("P = " + perimeter);
        return perimeter;
    }

    @Override
    /*
    Intent:To display information of right triangle
    Post-condition: calls rectangleInfo method and displays the information for right triangle
     */
    public void displayInformation()throws IOException {
        List<String> triangleInfo = triangleInfo();
        for(String line: triangleInfo){
            System.out.println(line);
        }
    }

    /*
      Intent: To store right triangle information on a list
      Post-condition: reads a text file "rightTriangleInfo.text". This file contains information of right triangle.
      Post-condition : returns a List
       */
    public List<String> triangleInfo() throws IOException {
        String str;
        List<String> list = new ArrayList<>();

        try (
            BufferedReader in = new BufferedReader(new FileReader("triangleInfo.txt"))){
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
    //Returns the string representation of the class
    public String toString() {
        return "RightTriangle{" +
                "base = " + base +
                ", height = " + height +
                ", hypotenuse = " + hypotenuse +
                '}';
    }
}
