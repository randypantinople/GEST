import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Trapezoid extends TwoDimensions {

    private double base1;
    private double base2;
    private double height;
    private double slantSide1;
    private double slantSide2;

    //constructor for the class
    public Trapezoid( double base1, double base2,  double height, double slantSide1, double slantSide2) {
        super("Trapezoid");
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.slantSide1 = slantSide1;
        this.slantSide2 = slantSide2;

    }

    @Override
       /*
    Intent: To solve the area of a trapezoid
    Post-condition: calculates the area of trapezoid
    Post-condition: Display the area of trapezoid
    Post-condition: returns area in type double
     */
    public double getArea() {
        double area = 0.5 * (this.base1 + this.base2) * this.height; // cast the answer to double
        area  = Double.parseDouble(String.format("%.2f", area));
        System.out.println("A =  0.5 * ( " + this.base1 + " + " + this.base2  + " ) * " + this.height );
        System.out.println("A = " + area);
        return area;
    }

    @Override
    /*
   Intent: To solve the perimeter of a trapezoid
   Post-condition: calculates the perimeter of trapezoid
   Post-condition: display the perimeter of trapezoid
   Post-condition: returns the perimeter in type double
 */
    public double getPerimeter() {
        double perimeter = this.base1 + this.base2 + this.slantSide1 + this.slantSide2;
        perimeter  = Double.parseDouble(String.format("%.2f", perimeter));
        System.out.println("P = " + this.base1 + " + " + this.base2 + " + " + this.slantSide1 + " + " + this.slantSide2);
        System.out.println("P = " + perimeter);
        return perimeter;
    }

    @Override
    /*
    Post-condition: calls trapezoidInfo method and displays the information for trapezoid.
     */
    public void displayInformation() throws IOException {
        List<String> trapezoidInfo = trapezoidInfo();
        for(String line: trapezoidInfo){
            System.out.println(line);
        }
    }

    /*
    Intent:To display information of rectangle
    Post-condition: calls trapezoidInfo method and displays the information for rectangle
     */

    public List<String> trapezoidInfo() throws IOException {
        String str;
        List<String> list = new ArrayList<>();

        try (
            BufferedReader in = new BufferedReader(new FileReader("trapezoidInfo.txt"))){
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
    //returns string representation for the class
    public String toString() {
        return "Trapezoid{" +
                "base1 = " + base1 +
                ", base2 = " + base2 +
                ", height = " + height +
                ", slantSide1 = " + slantSide1 +
                ", slantSide2 = " + slantSide2 +
                '}';
    }
}
