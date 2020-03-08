
import java.io.IOException;

public abstract class TwoDimensions {
    private String name;

	// Constructor without parameter
    public TwoDimensions(String name) {
        this.name = name;
    }

	//Constructor without parameter
    public TwoDimensions() {
    }

    //abstract methods
    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract void displayInformation() throws IOException;

}
