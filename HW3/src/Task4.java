
public class Task4 {

	public static void main(String[] args) {

		int[] arrayOfNums = { 40, 23, 2, 67, 32, 7, 91, 43, 76, 55, -4, -56, 5 };

		int minElement = Integer.MAX_VALUE;
		int maxElement = Integer.MIN_VALUE;

		for (int number : arrayOfNums) {

			if (number < minElement) {

				minElement = number;

			}
		}

		for (int number : arrayOfNums) {

			if (number > maxElement) {

				maxElement = number;

			}
		}

		System.out.println("Min value = " + minElement);
		System.out.println("Max value = " + maxElement);

	}
}
