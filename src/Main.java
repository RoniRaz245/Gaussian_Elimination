//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {

    }
    protected int[][] addToRow(int[][] matrix, int addTo, int otherRow, int scalar){
        for(int i = 0;i<matrix[addTo].length;i++)
            matrix[addTo][i]+= scalar * matrix[otherRow][i];
        return matrix;
    }
    protected int[][] switchRows(int[][] matrix, int rowOne, int rowTwo){
        int[] temp=matrix[rowOne].clone();
        for(int i=0;i<matrix[rowOne].length;i++) {
            matrix[rowOne][i] = matrix[rowTwo][i];
            matrix[rowTwo][i] = temp[i];
        }
        return matrix;
    }
}