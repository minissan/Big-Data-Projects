
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SerialMatrixVectorMultiplication {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        long startTime = System.currentTimeMillis();//start time
        int[][] matrix_A = new int[1000][1000];
        int[][] matrix_B = new int[1000][1];
        int[][] matrix_C = new int[1000][1];

        File myObj = new File("C:\\Users\\minis\\input.txt");
        // File myObj2 = new File("C:\\Users\\minis\\output.txt");
        FileWriter myWriter = new FileWriter("C:\\Users\\minis\\output.txt");

        String data;
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                String[] in = data.split(",");
                //System.out.println(data);

                if (in[0].equals("A")) {

                    int i = Integer.parseInt(in[1]);
                    int j = Integer.parseInt(in[2]);
                    matrix_A[i][j] = Integer.parseInt(in[3]);

                } else {

                    int i = Integer.parseInt(in[1]);
                    int j = Integer.parseInt(in[2]);
                    matrix_B[i][j] = Integer.parseInt(in[3]);

                }
                //System.out.println(data);
            }
        }
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1; j++) {
                matrix_C[i][j] = 0;
                for (int k = 0; k < 1000; k++) {
                    matrix_C[i][j] += matrix_A[i][k] * matrix_B[k][j];

                }
            }
        }

        for (int m = 0; m < matrix_C.length; m++) {
            myWriter.write(matrix_C[m][0] + "\n");
            //System.out.println(matrix_C[m][0]);
        }

        System.out.println("done");
      
        long endTime = System.currentTimeMillis();

        long duration = (endTime - startTime);  //Total execution time in milli seconds

        System.out.println(duration);
        myWriter.write("Total Time Spent: " + duration);
        myWriter.close();

    }

}
