
package gaussianEliminationMethod;

import java.util.Arrays;

public class gaussianElimination {
        public static void main(String[] args) {
            double[][] equation = {{19,3,2,9},{3,15,1,11},{1,2,-3,10}};
            System.out.println("Equation Matrix");
            printMatrix(equation);
            solve(equation);
        
    }
    static void solve(double[][] equation){
        int size = equation.length;

        //Forward Elimination
        //First column only
        System.out.println("\n First Column");
        for (int i = 1; i < size; i++) {
            double temp = equation[i][0]/equation[0][0];
            
            for (int j = 0; j < equation[0].length; j++) {
                
                equation[i][j]-=equation[i-i][j]*temp;
            }
            System.out.println("After process "+i);
            printMatrix(equation);
            System.out.println("");
        }
        // From Second column and greater than
        System.out.println("\n >= Second Column");
        for (int i = 2; i < size; i++) {
            double temp = equation[i][i-(i-1)]/equation[i-(i-1)][i-(i-1)];
            //System.out.println("i"+i+" temp "+temp +" "+equation[i][i-(i-1)]+"/"+equation[i-(i-1)][i-(i-1)]);
            //Ex System.out.println("i"+i+" temp "+temp +" "+equation[i][i-(i-1)]+"/"+equation[i-(i-1)][i-(i-1)]);
            for (int j = 1; j < equation[0].length; j++) {
                equation[i][j]-=equation[i-(i-1)][j]*temp;
                
                //System.out.print(equation[i-(i-1)][j]*temp+" ");
            }
            System.out.println("After process "+(i-1));
            printMatrix(equation);
            System.out.println("");
        }
        
        //Back Elimination
        double[] X = new double[size];
        for (int i = size-1 ; i >= 0; i--) {
            double sum = 0f;
            for (int j = 0; j < size; j++) {
                sum+=(equation[i][j])*X[j];              
            }
            X[i]=(equation[i][size]-sum)/equation[i][i];
        }
        System.out.println("=====================================");
        System.out.println("Result");
        printAns(X);
    }
    
    static void printMatrix(double[][] Matrix){
        for (int i = 0; i < Matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < Matrix[0].length; j++) {
                System.out.printf("%10.4f",Matrix[i][j]);
                if(j<Matrix[0].length-2) System.out.print(", ");
                if(j==2 && i==1) System.out.print("  |   =   |");
                else if (j==Matrix[0].length-2) System.out.print("  |       |");
                
            }
            System.out.print("   |");
            System.out.println("");
        }
    }
        static void printAns(double[] Ans){
        for (int i = 0; i < Ans.length; i++) {
                System.out.printf("X_%d = %10.4f\n",(i+1),Ans[i]);
        }
    }
}
