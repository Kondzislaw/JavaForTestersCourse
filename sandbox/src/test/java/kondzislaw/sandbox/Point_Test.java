package kondzislaw.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Point_Test {

  // TEST FOR THE FUNCTION POSITIVE
  @Test
  public void testDistance() {

    Point p1 = new Point(3, 2);
    Point p2 = new Point(9, 7);

    Assert.assertEquals(Point.distance(p1, p2), 7.810249675906654);

  }

  // TEST FOR THE METHOD POSITIVE
  @Test
  public void testDistance2() {

    Point p3 = new Point(7, 8);
    Point p4 = new Point(11, 12);

    Assert.assertEquals(p3.distance2(p4), 5.656854249492381);


  }

  // TEST FOR THE FUNCTION NEGATIVE
  @Test
  public void testDistance3() {

    Point p1 = new Point(3, 2);
    Point p2 = new Point(9, 7);

    Assert.assertNotEquals(Point.distance(p1, p2), 7.20);

  }

  // TEST FOR THE METHOD NEGATIVE
  @Test
  public void testDistance4() {
    Point p3 = new Point(7, 8);
    Point p4 = new Point(11, 12);

    Assert.assertNotEquals(p3.distance2(p4), 5);


  }

}
