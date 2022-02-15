import java.util.Scanner;

public class MyScore {

	public static void main(final String[] args) {
		// Write your solution here
		System.out.println("Celba dobas!");
		System.out.println("A cel a 100 pontos dobas.");
		System.out.print("On mennyit dobott:");
		Scanner input=new Scanner(System.in);
		int dobas =input.nextInt();
		int kulonbseg=100-dobas;
		System.out.println("A kulonbseg:"+kulonbseg);
		if (kulonbseg<0) {
			kulonbseg = -1 * kulonbseg;
		}
		System.out.println("Az elteres:"+kulonbseg);
	}
}
