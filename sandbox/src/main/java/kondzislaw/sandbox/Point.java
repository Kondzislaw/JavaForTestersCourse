package kondzislaw.sandbox;

//TASK 1 - create a class POINT
public class Point {


  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2.0) + Math.pow(p1.y - p2.y, 2.0));

  }

  public double distance2(Point p4) {
    return Math.sqrt(Math.pow(this.x - p4.x, 2.0) + Math.pow(this.y - p4.y, 2.0));

  }


}
