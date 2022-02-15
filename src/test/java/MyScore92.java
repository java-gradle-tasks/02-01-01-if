import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MyScore92 {

   @Test
   public void test() {
      String newLine="";
      if (System.getProperty("os.name").startsWith("Windows")) {
         newLine="\r\n";
      } else {
         newLine="\n";
      }

      InputStream stdin = System.in;

      int score=92;

      String input=String.valueOf(score)+newLine;
      System.setIn(new ByteArrayInputStream(input.getBytes()));

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(byteArrayOutputStream);
      PrintStream stdout = System.out;
      System.setOut(ps);

      MyScore.main(new String[0]);

      System.setIn(stdin);
      System.setOut(stdout);

      String expected="A kulonbseg:8"+newLine;
      String actual=byteArrayOutputStream.toString();

      System.out.println("Elvart:"+newLine+expected);
      System.out.println("Aktualis:"+newLine+actual);

      boolean found=actual.contains(expected);
      Assertions.assertTrue(found,"Nem jol hatarozta meg a kulonbseget!");

      expected="Az elteres:8"+newLine;
      actual=byteArrayOutputStream.toString();

      System.out.println("Elvart:"+newLine+expected);
      System.out.println("Aktualis:"+newLine+actual);

      found=actual.contains(expected);
      Assertions.assertTrue(found,"Nem jol hatarozta meg az elterest.");
   }
}
