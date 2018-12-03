package kondzislaw.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Collections {

  public static void main (String[] args) {
    String [] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = new ArrayList<String>();
    languages.add ("JAVA");
    languages.add ("C#");
    languages.add ("PYTHON");

for (String l : languages) {
  System.out.println("To są różne języki " + l);
}
  }
}
