import java.text.DecimalFormat;
import java.util.Scanner;

public class MatrixSum {
    public static void main(String[] args) {
        // Пример матрицы
        int[][] matrix = {
                {1, -2, 3, 4, -5},
                {-1, 2, 3, -4, 5},
                {6, -7, -8, 9, 10}
        };

        for (int i = 0; i < matrix.length; i++) {
            int sum = sumBetweenPositive(matrix[i]);
            if (sum != -1) {
                System.out.println("Сумма элементов между первым и вторым положительными элементами в строке " + (i + 1) + ": " + sum);
            } else {
                System.out.println("В строке " + (i + 1) + " недостаточно положительных элементов.");
            }
        }
    }

    public static int sumBetweenPositive(int[] row) {
        int firstPos = -1;
        int secondPos = -1;
        int sum = 0;
        boolean foundFirst = false;

        for (int i = 0; i < row.length; i++) {
            if (row[i] > 0) {
                if (!foundFirst) {
                    firstPos = i;
                    foundFirst = true;
                } else {
                    secondPos = i;
                    break;
                }
            }
        }

        if (firstPos != -1 && secondPos != -1) {
            for (int i = firstPos + 1; i < secondPos; i++) {
                sum += row[i];
            }
            return sum;
        }

        return -1;
    }
}
