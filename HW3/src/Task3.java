
public class Task3 {

	public static void main(String[] args) {

		int fibonacciNums[] = new int[20];
		
		fibonacciNums[0] = 1;
		fibonacciNums[1] = 1;

		for (int i = 2; i < fibonacciNums.length; i++) {

			fibonacciNums[i] = fibonacciNums[i - 2] + fibonacciNums[i - 1];

		}

		for (int fibonacciNum : fibonacciNums) {

			System.out.print(fibonacciNum + " ");

		}
	}

}
