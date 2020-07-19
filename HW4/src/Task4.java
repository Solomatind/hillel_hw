
public class Task4 {

	public static void main(String[] args) {

		int[] numbers = { 1, 3, 5, 6, 9, 0, 2, 4, 3, 2, 3, 5, 8, 2, 5, 9, 1 };
		int[][] matrixOfNumbers;
		int dimensionOfMatrix;
		int indexOfArray = 0;

		dimensionOfMatrix = (int) Math.ceil(Math.sqrt(numbers.length));
		matrixOfNumbers = new int[dimensionOfMatrix][dimensionOfMatrix];

		for (int i = 0; i < dimensionOfMatrix; i++) {
			for (int j = 0; j < dimensionOfMatrix; j++) {
				
				if (indexOfArray < numbers.length) {
					
					matrixOfNumbers[i][j] = numbers[indexOfArray];
					indexOfArray++;
					
				} else {
					
					matrixOfNumbers[i][j] = 0;
					
				}
			}
		}

		for (int i = 0; i < dimensionOfMatrix; i++) {
			for (int j = 0; j < dimensionOfMatrix; j++) {

				System.out.print(matrixOfNumbers[i][j] + " ");
				
			}

			System.out.println();
			
		}
	}
}
