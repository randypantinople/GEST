import org.junit.jupiter.api.Test;
import pantinopleRandy.Circle;
import pantinopleRandy.TwoDimensions;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    TwoDimensions circle = new Circle(8);

    @Test
    void getArea() {
        double area = circle.getArea();
        assertEquals(200.96, area);
    }

    @Test
    void getPerimeter() {
        double perimeter = circle.getPerimeter();
        assertEquals(50.24, perimeter);
    }
}