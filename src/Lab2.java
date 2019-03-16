public class Lab2 {
    public static void main(String[] args) {
        int rows_A = 3;
        int colomns_A = 3;
        int rows_B = 3;
        int colomns_B = 3;
        int [][] A ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int [][] B={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int [][] C = new int [3][3];

        System.out.println("A matrix: ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }


        System.out.println("\nB matrix: ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(B[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i=0;i<3;i++){

            for (int j=0;j<3;j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("\nC matrix:");

        for (int i=0;i<3;i++){

            for (int j=0;j<3;j++){
                System.out.print(C[i][j]+"\t ");
            }
            System.out.println();
        }
    }
}