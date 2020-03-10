package Tests;

import org.junit.jupiter.api.Test;
import pantinopleRandy.Parallelogram;
import pantinopleRandy.TwoDimensions;

import static org.junit.jupiter.api.Assertions.*;

class ParallelogramTest {
    TwoDimensions parallelogram = new Parallelogram(4,10, 15);

    @Test
    void getArea() {
        double area = parallelogram.getArea();
        assertEquals(40, area);
    }

    @Test
    void getPerimeter() {
        double perimeter = parallelogram.getPerimeter();
        assertEquals(38, perimeter);
    }

}