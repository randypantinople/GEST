package Tests;

import org.junit.jupiter.api.Test;
import pantinopleRandy.Rectangle;
import pantinopleRandy.TwoDimensions;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    TwoDimensions rectangle = new Rectangle(12, 6);

    @Test
    void getArea() {
        double area = rectangle.getArea();
        assertEquals(72, area);
    }

    @Test
    void getPerimeter() {
        double perimeter = rectangle.getPerimeter();
        assertEquals(36, perimeter);
    }
}