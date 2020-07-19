
public class Task2 {

	public static void main(String[] args) {

		int[] numbers = { 45, 67, 789, 1001, 1, 11256, 5632 };
		int[] lengthsOfNumbers = new int[numbers.length];

		int minElement = 10;
		int maxElement = 1;
		int coordinateOfMinElement = 0, coordinateOfMaxElement = 0;

		for (int i = 0; i < numbers.length; i++) {

			for (int n = 9; n >= 0; n--) {
				
				int divider = (int) Math.pow(10, n);
				
				if (numbers[i] / divider > 0) {

					lengthsOfNumbers[i] = n + 1;
					break;

				}
			}
		}

		for (int i = 0; i < lengthsOfNumbers.length; i++) {

			if (lengthsOfNumbers[i] < minElement) {

				minElement = lengthsOfNumbers[i];
				coordinateOfMinElement = i;

			}
		}

		for (int i = 0; i < lengthsOfNumbers.length; i++) {

			if (lengthsOfNumbers[i] > maxElement) {

				maxElement = lengthsOfNumbers[i];
				coordinateOfMaxElement = i;

			}
		}

		System.out.println("Max length of element is " + lengthsOfNumbers[coordinateOfMaxElement] + " ("
				+ numbers[coordinateOfMaxElement] + ")");
		
		System.out.println("Min length of element is " + lengthsOfNumbers[coordinateOfMinElement] + " ("
				+ numbers[coordinateOfMinElement] + ")");

	}
}
