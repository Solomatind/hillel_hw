
public class Task1 {

	public static void main(String[] args) {

		int[] arrayOfNums1 = { 9, 2, 3, 8, 12, 3, 1, 8, 6, 2 };
		int[] arrayOfNums2 = { 12, 3, 1, 8 };

		boolean isBelong = false;
		int indexOfFirstElement = 0;

		for (int i = 0; i < arrayOfNums1.length; i++) {

			if (arrayOfNums2[0] == arrayOfNums1[i]) {

				int k = i;
				int j = 0;

				while (k < arrayOfNums1.length && arrayOfNums2[j] == arrayOfNums1[k]) {

					if (j == arrayOfNums2.length - 1) {

						isBelong = true;
						indexOfFirstElement = i;
						break;

					}

					j++;
					k++;

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
