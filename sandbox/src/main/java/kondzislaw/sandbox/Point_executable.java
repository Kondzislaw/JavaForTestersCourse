package kondzislaw.sandbox;

public class Point_executable {

  public static void main(String[] args) {

    //  TASK 3
//    double p1 = 6;
//    double p2 = 11;
    System.out.println("Result of the function from the second task is " + distance(6, 11));


    //  TASK 4
    Point p = new Point(10, 20);
    System.out.println("Result of the method from the fourth task is " + p.distance());



  }

  //  TASK 2 - create a function for distance calculation

  public static double distance(double p1, double p2) {
    return p2 - p1;

  }




}
