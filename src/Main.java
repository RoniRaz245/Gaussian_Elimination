//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    static int rows;
    static int columns;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double[][] matrix=getMatrixFromUser(scan);

        //make sure user entered matrix correctly
        System.out.println("\nData you entered :");
        printMatrix(matrix);
        System.out.println("is this correct? Write true or false");
        if(!scan.nextBoolean()){
            System.out.println("Reenter matrix");
            matrix=getMatrixFromUser(scan);
        }

        //start gaussian elimination itself
        int rowIndex=0;
        int columnIndex=0;
        int rowWithoutPivot=0;
        while(columnIndex<columns){
            while(rowIndex<rows) {
                if (matrix[rowIndex][columnIndex] == 0)
                    rowIndex++;
                else{
                    for(int i=rowIndex+1;i<rows;i++){
                        if(matrix[i][columnIndex]!=0) {
                            double scalar=(-1*(matrix[i][columnIndex]))/(matrix[rowIndex][columnIndex]);
                            addToRow(matrix, i, rowIndex, scalar);
                        }
                    }
                    if(rowWithoutPivot<rows) {
                        switchRows(matrix, rowIndex, rowWithoutPivot);
                        rowWithoutPivot++;
                    }
                    break;
                }
            }
            rowIndex=rowWithoutPivot;
            columnIndex++;
        }
    System.out.println("the matrix after Gaussian elimination is:");
    printMatrix(matrix);
    }
    protected static void printMatrix(double[][] matrix){
        for(double[] x:matrix){
            for(double y:x){
                System.out.print(y+"        ");
            }
            System.out.print("\n");
        }
    }
    protected static double[][] getMatrixFromUser(Scanner scan){
        //make matrix based on user input
        System.out.println("Enter 2D matrix size : ");
        rows=scan.nextInt();
        columns=scan.nextInt();

        System.out.println("Enter elements of matrix : ");
        double[][] matrix =new double[rows][columns];
        for(int i=0; i<rows;i++)
        {
            for(int j=0; j<columns;j++)
            {
                matrix[i][j]=scan.nextDouble();
            }
        }
        return matrix;
    }
    protected static void addToRow(double[][] matrix, int addTo, int otherRow, double scalar){
        for(int i = 0;i<columns;i++)
            matrix[addTo][i]+= scalar * matrix[otherRow][i];
    }
    protected static void switchRows(double[][] matrix, int rowOne, int rowTwo){
        double[] temp=matrix[rowOne].clone();
        for(int i=0;i<columns;i++) {
            matrix[rowOne][i] = matrix[rowTwo][i];
            matrix[rowTwo][i] = temp[i];
        }
    }
}