import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double [][] matriz = iniciarMatriz(50, 5);
        System.out.println(matriz);
        mostrarMatriz(matriz);
        agregarEstudiante(matriz);
        mostrarMatriz(matriz);
// 5 notas x 50 estudiantes
    }
    public static double validarDouble () {
        Scanner teclado = new Scanner(System.in);
        Double valor = null;
        while (valor == null || valor < 1 || valor > 7) {
                try {
                    valor = Double.parseDouble(teclado.nextLine());
                    if (valor <1 || valor >7) {
                        System.out.println("Ingrese valores entre 1.0 y 7.0");
                        }
                    }
                catch (Exception ex) {
                    System.out.println("ERROR. Introduzca valores numericos");
                }
            }
        return valor;
    }
    public static double[][] agregarEstudiante (double [][]matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Estudiante: "+(i+1));
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0.0) {
                    matriz[i][j] = validarDouble();
                    System.out.println(matriz[i][j]+", ");
                } else if (matriz[i][j] != 0) {
                    System.out.println("ya hay nota en estudiante: "+(i+1)+" nota n°:"+(j+1));
                }
                //metodos
            }
        }
        return matriz;
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