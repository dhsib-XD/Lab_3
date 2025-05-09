/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author CarlosXl
 */
public class Lab_3 {

    /**
     * @param args the command line arguments
     */
 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int menu = 0;
        int max = 0;
        String l = "";
        int a = 0; // Esta variable parece no estar en uso
        String cadena = "";
        String palindromo = "No"; // Se usa solo en el case 1 para la palabra más larga
        int ct = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        String invertida = "";

        while (true) {
            System.out.println("Favor ingrese una de las siguientes opciones:");
            System.out.println("1....Palabra Alrevez");
            System.out.println("2....Numero perfecto");
            System.out.println("3....Primos");
            System.out.println("4....Votacion");
            System.out.println("5....Salir");
            System.out.print("Su elección es: ");
            menu = scanner.nextInt();

            if (menu == 5) {
                System.out.println("\nHa entrado a los programas esta cantidad de veces:");
                System.out.println("1...Palabra Alrevez: " + c1);
                System.out.println("2...Numero Perfectos: " + c2);
                System.out.println("3...Primos: " + c3);
                System.out.println("4...Votacion: " + c4);
                System.out.println("El total de veces ingresadas es: " + ct);
                break; // Salir del bucle while y terminar el programa
            }

            switch (menu) {
                case 1: {
                    ct++;
                    c1++;
                    System.out.print("Cuantas palabras desea?: ");
                    int cant = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    max = 0;
                    l = "";

                    for (int i = 0; i < cant; i++) {
                        System.out.println("Favor ingrese una cadena de caracteres:");
                        cadena = scanner.nextLine();

                        // Verificar palabra más larga
                        if (cadena.length() > max) {
                            max = cadena.length();
                            l = cadena;
                        }
                    }

                    invertida = new StringBuilder(l).reverse().toString();
                    String esPalindromo = (l.equals(invertida)) ? "Si" : "No";

                    System.out.println("La palabra mas larga es: " + l);
                    System.out.println("Es un palindromo: " + esPalindromo);
                    break;
                }
                case 2: {
                    ct++;
                    c2++;
                    System.out.print("Ingrese un numero para verificar si es perfecto: ");
                    int num = scanner.nextInt();

                    int suma = 0;
                    for (int i = 1; i < num; i++) {
                        if (num % i == 0) {
                            suma += i;
                        }
                    }

                    if (suma == num) {
                        System.out.println(num + " es un numero perfecto.");
                    } else {
                        System.out.println(num + " no es un numero perfecto.");
                    }
                    break;
                }
                case 3: {
                    ct++;
                    c3++;
                    int aleatorio = random.nextInt(100) + 1;
                    int divisores = 0;
                    String lista = "";

                    for (int i = 1; i <= aleatorio; i++) {
                        if (aleatorio % i == 0) {
                            divisores++;
                            lista += i + " ";
                        }
                    }

                    if (divisores == 2) {
                        System.out.println("El numero " + aleatorio + " es primo.");
                    } else {
                        System.out.println("El numero " + aleatorio + " no es primo.");
                    }

                    System.out.println("Tiene " + divisores + " divisores.");
                    System.out.println("Divisores: " + lista);
                    break;
                }
                case 4: {
                    ct++;
                    c4++;
                    System.out.print("Ingrese la cantidad de votantes en el pais: ");
                    int total = scanner.nextInt();
                    int Azul = 0, Rojo = 0, Negro = 0, Amarillo = 0, Nulo = 0;

                    for (int i = 1; i <= total; i++) {
                        System.out.print("Ingrese el voto #" + i + " (AZUL, ROJO, NEGRO, AMARILLO): ");
                        String voto = scanner.next().toUpperCase();
                        switch (voto) {
                            case "AZUL":
                                Azul++;
                                break;
                            case "ROJO":
                                Rojo++;
                                break;
                            case "NEGRO":
                                Negro++;
                                break;
                            case "AMARILLO":
                                Amarillo++;
                                break;
                            default:
                                Nulo++;
                                System.out.println("Voto nulo.");
                                break;
                        }
                    }

                    double porcentajeVotosValidos = ((double) (Azul + Rojo + Negro + Amarillo) / total) * 100;
                    if (porcentajeVotosValidos < 60) {
                        System.out.println("VOTACION FALLIDA");
                    } else {
                        String ganador = (Azul > Rojo && Azul > Negro && Azul > Amarillo) ? "AZUL"
                                : (Rojo > Azul && Rojo > Negro && Rojo > Amarillo) ? "ROJO"
                                : (Negro > Azul && Negro > Rojo && Negro > Amarillo) ? "NEGRO" : "AMARILLO";
                        System.out.println("La planilla ganadora es: " + ganador);
                    }
                    break;
                }
                default:
                    System.out.println("Numero no valido favor ingrese otro numero");
            }
            break;
        }
        
    }
}