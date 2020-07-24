
public class Task6 {

    int result;
    
    void printNumberInOrder(int number) {
        if (number == 0) {
            return;
        } else {
            printNumberInOrder(number - 1);
        }
        System.out.print(number + " ");
    }

    int sumOfDigits(int numberWithDigits) {
        result += (numberWithDigits % 10);
        if (numberWithDigits == 0) {
            return result;
        } else {
            sumOfDigits(numberWithDigits / 10);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 9;
        Task6 ob = new Task6();
        ob.printNumberInOrder(n);
        System.out.println();
        System.out.println(ob.sumOfDigits(2567));
    }

}
