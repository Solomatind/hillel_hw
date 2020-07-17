import java.util.*;

public class Task1 {
	public static void main(String[] args) {

		int[] numbers = { 2, 3, 7, 15, 20, 76, 51, 93 };
		//int[] evenNumbers = new int[numbers.length];
		//int[] oddNumbers = new int[numbers.length];
		ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
		ArrayList<Integer> oddNumbers = new ArrayList<Integer>();
		// for (int num : numbers) {
		for (int i = 0; i < 8; i++) {
			if (numbers[i] % 2 == 0) {
				evenNumbers.add(numbers[i]);
			} else {
				//oddNumbers[i] = numbers[i];
				oddNumbers.add(numbers[i]);
			}
		}

		System.out.print("Even numbers: ");
		
		for (int evenNumber : evenNumbers) {
			System.out.print(evenNumber + " ");
		}
		/*for (int evenNum : evenNumbers) {
			System.out.print(evenNum + " ");
		}*/

		System.out.println("");
		System.out.print("Odd numbers: ");

		for (int oddNumber : oddNumbers) {
			System.out.print(oddNumber + " ");
		}
		/*for (int oddNum : oddNumbers) {

			System.out.print(oddNum + " ");

		}*/
	}
}