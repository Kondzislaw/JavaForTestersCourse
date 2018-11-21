package kondzislaw.sandbox;

public class Point_executable {

  public static void main(String[] args) {


    Point p1 = new Point(3,2);
    Point p2 = new Point(9,7);


    System.out.println("Distance between two points as a function " + Point.distance(p1,p2));


    Point p3 = new Point(3,2);
    Point p4 = new Point(9,7);

    System.out.println("Distance between two points with a method " + p3.distance2(p4));

  }




}
