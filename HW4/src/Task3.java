
public class Task3 {

	public static void main(String[] args) {

		int[] numbers = { 12, 221, 345, 1003, 1233, 22, 41, 111, 5551, 1555, 1331, 567, 981, 1231 };

		int modulo;
		int compareModulo;
		int number;
		int resultOfDivision;

		for (int i = 0; i < numbers.length; i++) {
			
			boolean isDiffNumbers = true;
			number = numbers[i];
			
			do {

				modulo = number % 10;

				number /= 10;

				resultOfDivision = number;

				while (resultOfDivision > 0) {

					compareModulo = resultOfDivision % 10;

					resultOfDivision /= 10;

					if (modulo == compareModulo) {

						isDiffNumbers = false;
						break;

					}
				}

				if (!isDiffNumbers) {
					
					break;
					
				}
				
			} while (number != 0);

			if (isDiffNumbers) {
				
				System.out.println(numbers[i]);
				
			}
		}
	}
}
