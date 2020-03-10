package Tests;

import org.junit.jupiter.api.Test;
import pantinopleRandy.RightTriangle;
import pantinopleRandy.TwoDimensions;

import static org.junit.jupiter.api.Assertions.*;

class RightTriangleTest {
    TwoDimensions rightTriangle = new RightTriangle(3,4,5);

    @Test
    void getArea() {
        double area = rightTriangle.getArea();
        assertEquals(6, area);
    }

    @Test
    void getPerimeter() {
        double perimeter = rightTriangle.getPerimeter();
        assertEquals(12, perimeter);
    }
}