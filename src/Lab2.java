public class Lab2 {
    public static void main(String[] args) {
        int [][] A ={
                {1,2,4},
                {4,5,3},
                {7,8,7}
        };

        int [][] B={
                {1,2,4},
                {4,5,2},
                {7,8,2}
        };

        int [][] C = new int [3][3] ;

        System.out.println("A matrix: ");

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }


        System.out.println("\nB matrix: ");

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                System.out.print(B[i][j] + "\t");
            }
            System.out.println();
        }
        if (A.length == B.length || A[0].length == B[0].length) {
            for (int i=0;i<C.length;i++){

                for (int j=0;j<C.length;j++) {
                    C[i][j] = A[i][j] + B[i][j];
                }
            }
            System.out.println("\nC matrix:");
        }
        else {
            System.out.println("Matrices have different shapes!");
        }

        for (int i=0;i<C.length;i++){

            for (int j=0;j<C.length;j++){
                System.out.print(C[i][j]+"\t ");
            }
            System.out.println();
        }
        int temp;
        int sum_min = 0;
        for (int i = 0; i < C.length; i++) {
            temp = C[i][0];

            for (int j = 1; j < C.length; j++) {
                if (C[i][j] < temp) {
                    temp = C[i][j];
                }
            }
            sum_min += temp;

        }
        System.out.println();
        System.out.println("SUM_SMALL = " + sum_min);

    }
}