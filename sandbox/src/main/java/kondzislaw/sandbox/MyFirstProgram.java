package kondzislaw.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");

    double a = 4;
    double b = 6;
    System.out.println("Powierzchnia prostokąta o bokach "  + a +  " i " + b + " = " + area(a, b));

    double len = 5;
    System.out.println("Powierzchnia kwadratu o boku " + len + " = " + area(len));

  }

  public static void hello(String somebody) {
       System.out.println("Hello," + somebody + "!");

  }

  public static double area(double l) {
    return l * l;

  }

  public static double area(double a, double b) {
    return a * b;

  }

}