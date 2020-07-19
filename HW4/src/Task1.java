
public class Task1 {

	public static void main(String[] args) {

		int[] arrayOfNums1 = { 9, 2, 3, 8, 12, 3, 1, 8, 6, 2 };
		int[] arrayOfNums2 = { 12, 3, 1, 8 };

		boolean isBelong = false;
		int indexOfFirstElement = 0;

		for (int i = 0; i < arrayOfNums1.length; i++) {

			if (arrayOfNums2[0] == arrayOfNums1[i]) {

				int indexOfSubsequence = i;
				int indexOfSequence = 0;

				while (indexOfSubsequence < arrayOfNums1.length && arrayOfNums2[indexOfSequence] == arrayOfNums1[indexOfSubsequence]) {

					if (indexOfSequence == arrayOfNums2.length - 1) {

						isBelong = true;
						indexOfFirstElement = i;
						break;

					}

					indexOfSequence++;
					indexOfSubsequence++;

				}

				if (isBelong) {

					break;

				}
			}
		}

		if (isBelong) {

			System.out.println("Array2 belongs to array1 and starts from " + indexOfFirstElement + " element");

		} else {

			System.out.println("Array2 doesn't belong to array1");

		}
	}
}
