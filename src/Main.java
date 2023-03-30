public class Main {
    public static void main(String[] args) {

        double [][] matriz = iniciarMatriz(50, 5);
        System.out.println(matriz);
        mostrarMatriz(matriz);
        notasAleatorias(matriz);
        mostrarMatriz(matriz);
// 5 notas x 50 estudiantes
    }

    public static double [][] notasAleatorias (double [][] mat) {
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (Math.random()*6+1);
            }
        }
        return mat;
    }
    public static double [][] iniciarMatriz (int estudiantes, int notas) {
        return new double[estudiantes][notas];
    }
    public static void mostrarMatriz (double [][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                System.out.print(matriz[i][j]+", ");
            }
            System.out.println(" ");
        }
    }
}