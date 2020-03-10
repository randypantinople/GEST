package Tests;

import org.junit.jupiter.api.Test;
import pantinopleRandy.Trapezoid;
import pantinopleRandy.TwoDimensions;

import static org.junit.jupiter.api.Assertions.*;

class TrapezoidTest {
    TwoDimensions trapezoid = new Trapezoid(10, 8, 15, 16, 16);

    @Test
    void getArea() {
        double area = trapezoid.getArea();
        assertEquals(135, area);
    }

    @Test
    void getPerimeter() {
        double perimeter = trapezoid.getPerimeter();
        assertEquals(50, perimeter);
}

}