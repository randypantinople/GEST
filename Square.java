import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Square extends TwoDimensions {
    private double side;

    //constructor
    public Square( double side) {
        super("Square");
        this.side = side;
    }

    @Override
     /*
    Intent: To solve the area of a square
    Post-condition: calculates the area of square
    Post-condition: Display the area of square
    Post-condition: returns area in type double
     */

    public double getArea() {
        double area = this.side * this.side;
        area = Double.parseDouble(String.format("%.2f", area)); // cast the answer to double
        System.out.println("Area = "+ this.side + " * " + this.side);
        System.out.println("Area = " + area + "\n");
        System.out.println();
        return area;
    }

    @Override
    /*
   Intent: To solve the perimeter of a square
   Post-condition: calculates the perimeter of square
   Post-condition: display the perimeter of square
   Post-condition: returns the perimeter in type double
   Returns: perimeter
    */
    public double getPerimeter() {
        double perimeter = 4 * this.side;
        perimeter  = Double.parseDouble(String.format("%.2f", perimeter));
        System.out.println("P = 4 * " + this.side);
        System.out.println("P = " + perimeter);
        System.out.println();
        return perimeter;
    }

    @Override
     /*
    Intent:To display information of square
    Post-condition: calls rectangleInfo method and displays the information for square
     */
    public void displayInformation() throws IOException {
        List<String> squareInfo = squareInfo();
        for(String line: squareInfo){
            System.out.println(line);
        }

    }

    /*
    Intent: To store rectangle information on a list
    Post-condition: reads a text file "squareInfo.text". This file contains information of square.
    Post-condition : returns a List
     */
    public List<String> squareInfo() throws IOException {
        String str;
        List<String> list = new ArrayList<>();

        try (
            BufferedReader in = new BufferedReader(new FileReader("squareInfo.txt"))){
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
    //Returns the string representation of the class
    public String toString() {
        return "Square{" +
                "side = " + side +
                '}';
    }
}

