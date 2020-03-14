import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parallelogram extends TwoDimensions {

    private double base;
    private double height;
    private double slantHeight;

    // constructor for the class
    public Parallelogram( double base, double height, double slantHeight) {
        super("Parallelogram");
        this.base = base;
        this.height = height;
        this.slantHeight= slantHeight;
    }

    @Override
     /*
    Intent: To solve the area of a parallelogram
    Post-condition: calculates the area of parallelogram
    Post-condition: Display the area of parallelogram
    Post-condition: returns area in type double
     */
    public double getArea() {
        double area = this.base * this.height;
        area = Double.parseDouble(String.format("%.2f", area)); // cast the answer to double
        System.out.println("Area = "+ this.base + " * " + this.height);
        System.out.println("Area = " + area + "\n");
        return area;
    }

    @Override
   /*
   Intent: To solve the perimeter of a parallelogram
   Post-condition: calculates the perimeter of parallelogram
   Post-condition: display the perimeter of parallelogram
   Post-condition: returns the perimeter in type double
   Returns: perimeter
    */
    public double getPerimeter() {
        double perimeter = (2 * this.base) + (2 * this.slantHeight);
        perimeter  = Double.parseDouble(String.format("%.2f", perimeter)); // cast to double
        System.out.println("P = ( 2 * " + this.base + " ) + ( 2 * " + this.slantHeight + " )");
        System.out.println("P = " + perimeter);
        return perimeter;
    }

    @Override
      /*
    Intent:To display information of parallelogram
    Post-condition: calls rectangleInfo method and displays the information for parallelogram
     */
    public void displayInformation() throws IOException {
        List<String> parallelogramInfo = parallelogramInfo();
        for(String line: parallelogramInfo){
            System.out.println(line);
        }

    }

    /*
    Intent: To store rectangle information on a list
    Post-condition: reads a text file "parallelogramInfo.text". This file contains information of rectangle.
    Post-condition : returns a List
     */
    public List<String> parallelogramInfo() throws IOException {
        String str;
        List<String> list = new ArrayList<>();

        try (
            BufferedReader in = new BufferedReader(new FileReader("parallelogramInfo.txt"))){
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
    // returns string representation of the class
    public String toString() {
        return "Parallelogram{" +
                "base = " + base +
                ", height = " + height +
                ", slantHeight = " + slantHeight +
                '}';
    }
}
