
public class Task2 {

	public static void main(String[] args) {

		int[] numbers = { 5, 8, 13, 7, 42, 53, 41, 66, 102, 131, 143, 199, 201 };

		for (int number : numbers) {
			for (int i = 2; i < number; i++) {

				if (number % i == 0) {

					break;

				} else if (i == (number - 1)) {

					System.out.print(number + " ");

				}
			}
		}
	}
}
