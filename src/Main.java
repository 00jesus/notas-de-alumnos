import java.util.Scanner;

// 5 notas x 50 estudiantes
public class Main {
    public static void main(String[] args) {
        menu();

    }
    public static void menu () {
        Scanner entrada = new Scanner(System.in);
        int resp = -1;
        double [][] matriz = iniciarMatriz(50,5);
        while (resp!=0) {
            System.out.println("""
                    1 Agregar estudiantes
                    2 Mostrar aprobados, reprobados, examenes
                    3 Llenar con notas aleatorias
                    4 Mostrar alumnos(vertical) y notas(horizontal)""");
            System.out.print("Ingrese opcion: ");
            resp = entrada.nextInt();

            if (resp == 1) agregarEstudiante(matriz);
            if (resp == 2) apruebanReprueban(matriz);
            if (resp ==3) notaAleatoria(matriz);
            if (resp ==4) mostrarMatriz(matriz);
            if (resp == 5 ) calcularPromedios(matriz);

            else {
                System.out.println(" "); //solo espacio
            }
        }
    }
    public static void apruebanReprueban (double [][] matriz) {
        int aprueban = 0;
        int reprueban = 0;
        int examen = 0;
        double aux;
        for (int i = 0; i < matriz.length; i++) {
            aux = calcularPromedio(matriz, i);
            if (aux >= 4) {
                aprueban = aprueban + 1;
            } else if (aux>3.5 && aux<4) {
                examen = examen +1;
            }else if (aux<3.6) {
                reprueban = reprueban +1;
            }
        }
        System.out.println("Reprueban: "+ reprueban);
        System.out.println("Aprueban: "+ aprueban);
        System.out.println("Examen: "+ examen);
    }
    public static void calcularPromedios(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("promedio de alumno:"+(i+1)+ calcularPromedio(matriz,i));
        }
    }
    public static double calcularPromedio (double [][]matriz, int estudiante) {
        double acumulador = 0;
        double promedio = 0;
        double nota1 = matriz[estudiante][0];
        double nota2 = matriz[estudiante][1];
        double nota3 = matriz[estudiante][2];
        double nota4 = matriz[estudiante][3];
        double nota5 = matriz[estudiante][4];
        promedio = (nota1*25 + nota2*25 + nota3*25 + nota4*15 + nota5*10)/5;
        return promedio;
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
            System.out.print("Estudiante: "+(i+1));
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0.0) {
                    System.out.print(" nota: "+(j+1)+": ");
                    matriz[i][j] = validarDouble();
                } else if (matriz[i][j] != 0) {
                    System.out.println("Ya hay nota en estudiante: "+(i+1)+" nota n°:"+(j+1));
                }

            }
        }
        return matriz;
    }
    public static double [][] notaAleatoria (double [][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = Math.random()*6+1;
            }
        }
        return matriz;
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