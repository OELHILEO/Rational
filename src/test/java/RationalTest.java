import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RationalTest {
    Rational r1;
    Rational r2;

    // Setup: runs before each test
    @Before
    public void createRationals() {
        System.out.println("Initializing the two Rational numbers.");
        r1 = new Rational();
        r2 = new Rational();
    }

    // Test addition: 1/2 + 1/4 = 3/4
    @Test
    public void testAdd() {
        r1.numerator = 1;
        r1.denominator = 2;
        r2.numerator = 1;
        r2.denominator = 4;
        r1.add(r2);
        Assert.assertEquals(3, r1.numerator);
        Assert.assertEquals(4, r1.denominator);
    }

    // Test subtraction: 1/2 - 1/4 = 1/4
    @Test
    public void testSubtract() {
        r1.numerator = 1;
        r1.denominator = 2;
        r2.numerator = 1;
        r2.denominator = 4;
        r1.subtract(r2);
        Assert.assertEquals(1, r1.numerator);
        Assert.assertEquals(4, r1.denominator);
    }

    // Test multiplication: 2/3 * 3/4 = 1/2
    @Test
    public void testMultiply() {
        r1.numerator = 2;
        r1.denominator = 3;
        r2.numerator = 3;
        r2.denominator = 4;
        r1.multiply(r2);
        Assert.assertEquals(1, r1.numerator);
        Assert.assertEquals(2, r1.denominator);
    }

    // Test division: (1/2) / (1/4) = 2/1
    @Test
    public void testDivide() {
        r1.numerator = 1;
        r1.denominator = 2;
        r2.numerator = 1;
        r2.denominator = 4;
        r1.divide(r2);
        Assert.assertEquals(2, r1.numerator);
        Assert.assertEquals(1, r1.denominator);
    }

    // Test equality between fractions
    @Test
    public void testEquals() {
        r1.numerator = 1;
        r1.denominator = 2;
        r2.numerator = 2;
        r2.denominator = 4;
        Assert.assertEquals(r1, r2);

        r2.numerator = 1;
        r2.denominator = 3;
        Assert.assertNotEquals(r1, r2);

        r2.numerator = 2;
        r2.denominator = 3;
        Assert.assertNotEquals(r1, r2);
    }

    // Test comparison: -1 (less), 0 (equal), 1 (greater)
    @Test
    public void testCompareTo() {
        r1.numerator = 1;
        r1.denominator = 2;
        r2.numerator = 3;
        r2.denominator = 4;
        Assert.assertEquals(-1, r1.compareTo(r2));

        r1.numerator = 3;
        r1.denominator = 4;
        r2.numerator = 1;
        r2.denominator = 2;
        Assert.assertEquals(1, r1.compareTo(r2));

        r1.numerator = 1;
        r1.denominator = 2;
        r2.numerator = 2;
        r2.denominator = 4;
        Assert.assertEquals(0, r1.compareTo(r2));
    }

    // Test toString output
    @Test
    public void testToString() {
        r1.numerator = 1;
        r1.denominator = 2;
        Assert.assertEquals("1/2", r1.toString());

        r2.numerator = 3;
        r2.denominator = 4;
        Assert.assertEquals("3/4", r2.toString());
    }

    // Test default constructor: 0/1
    @Test
    public void testDefaultConstructor() {
        Rational r = new Rational();
        Assert.assertEquals(0, r.numerator);
        Assert.assertEquals(1, r.denominator);
    }

    // Test constructor with values: 2/4 becomes 1/2
    @Test
    public void testParameterizedConstructor() throws Rational.Illegal {
        Rational r = new Rational(2, 4);
        Assert.assertEquals(1, r.numerator);
        Assert.assertEquals(2, r.denominator);
    }

    // Test constructor throws error when denominator is 0
    @Test(expected = Rational.Illegal.class)
    public void testConstructorWithZeroDenominator() throws Rational.Illegal {
        new Rational(1, 0);
    }

    // Cleanup: runs after each test
    @After
    public void clearUp() {
        System.out.println("Clear up the two Rational numbers.");
        r1 = null;
        r2 = null;
    }
}
