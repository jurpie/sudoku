import java.util.Random;
import java.util.Scanner;

public class HelloWorld {
	public static void main(String sherry[]){
	
		Dog Jerome;
		Jerome = new Dog("Jerome");
		
		int start = 0;
		
		//Scanner inputFromUser = new Scanner(System.in);
		//int finish = inputFromUser.nextInt();
		int finish = 4;
		
		while (start < finish){
			Jerome.bark();
			Jerome.dig();
			
			start += 1;
		}
		
		Random r = new Random();
		Object randomness = r.nextBoolean();
		System.out.print(randomness);
	}
}
