package Tests;

import org.junit.jupiter.api.Test;
import pantinopleRandy.Circle;
import pantinopleRandy.Square;
import pantinopleRandy.TwoDimensions;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    TwoDimensions square = new Square(4);

    @Test
    void getArea() {
        double area = square.getArea();
        assertEquals(16, area);
    }

    @Test
    void getPerimeter() {
        double perimeter = square.getPerimeter();
        assertEquals(16, perimeter);
    }
}