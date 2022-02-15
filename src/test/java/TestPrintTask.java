import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

   public class TestPrintTask {

      @Test
      public void testInput() {

         String newLine="";
         if (System.getProperty("os.name").startsWith("Windows")) {
            newLine="\r\n";
         } else {
            newLine="\n";
         }

         InputStream stdin = System.in;

         int score=120;

         String input=String.valueOf(score)+newLine;
         System.setIn(new ByteArrayInputStream(input.getBytes()));

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(byteArrayOutputStream);
         PrintStream stdout = System.out;
         System.setOut(ps);

         MyScore.main(new String[0]);

         System.setIn(stdin);
         System.setOut(stdout);

         String expected="Celba dobas!" +newLine;
         expected+="A cel a 100 pontos dobas."+newLine;
         String actual=byteArrayOutputStream.toString();

         System.out.println("Elvart:"+newLine+expected);
         System.out.println("Aktualis:"+newLine+actual);

         boolean found=actual.contains(expected);

         Assertions.assertTrue(found,"Nem irta ki a feladatot!");
      }
   }
