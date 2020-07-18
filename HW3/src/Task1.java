
public class Task1 {

	public static void main(String[] args) {

		int[] numbers = { 2, 3, 7, 15, 20, 76, 51, 93 };

		System.out.print("Even numbers: ");

		for (int number : numbers) {

			if ((number % 2) == 0) {

				System.out.print(number + " ");

			}
		}

		System.out.print('\n' + "Odd numbers: ");

		for (int number : numbers) {

			if ((number % 2) != 0) {

				System.out.print(number + " ");

			}
		}
	}
}