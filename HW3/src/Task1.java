public class Task1 {
    public static void main(String[] args) {

        int [] numbers = { 2, 3, 7, 15, 20, 76, 51, 93 };
        int [] evenNumbers = new int [numbers.length] ;
        int [] oddNumbers = new int [numbers.length];

        //for (int num : numbers) {
			for (int i =0; i<8; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers[i] = numbers[i];
            }
            else {
                oddNumbers[i] = numbers[i];
            }
        }

			 System.out.print("Even numbers: ");	
        for (int evenNum : evenNumbers) {
             System.out.print(evenNum + " ");
        }

        System.out.println("");
        System.out.print("Odd numbers: ");
        
        for (int oddNum : oddNumbers) {
        	
             System.out.print(oddNum + " ");

    }
}
}