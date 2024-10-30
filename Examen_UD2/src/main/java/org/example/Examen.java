package org.example;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void ejercicio1(){
        Scanner entrada = new Scanner(System.in); //para obtener lo que introduce el usuario
        Random random = new Random(); //para que pueda obtener numeros random

        int num_adivinar = 0; //variables que voy a usar
        int num_usu = 0; //variables que voy a usar
        int fin = 0; //variables que voy a usar
        boolean error = true; //variables que voy a usar
        num_adivinar = random.nextInt(100); //numero random que va a servir, lo pongo aqui para que si salta el try catch no cambie
        while (error == true) { //por si salta el try catch no acabe el progrma
            try {
                for (int i = 0; i < 10; i++) { //hace 10 veces lo de dentro porque el usuario tiene 10 oportunidades.
                    System.out.println("Adivina un numero entre el 0 y el 100: "); //pide el numero
                    num_usu = entrada.nextInt(); //lo guarda
                    if (num_usu < num_adivinar) { //comprueba si es menor
                        System.out.println("Tu numero es menor al que he pensado"); //dice que es menor
                    } else if (num_usu > num_adivinar) { //comprueba si es mayorr
                        System.out.println("Tu numero es mayor al que he pensado"); // dice que es mayor
                    } else if (num_usu == num_adivinar) { // comprueba si es el numero
                        System.out.println("ENORABUENA, has adivinado, el numero era: " + num_adivinar); //dice que ha adivinado
                        fin = 1; //sirve para que compruebe que lo ha adivinado antes de usar todos los intentos
                        break;

                    }
                }
                if (fin == 0) { //si ha hecho todos los intentos y no lo ha acertado imprime eso
                    System.out.println("Que pena no lo has adivinado el numero era: " + num_adivinar);
                    break;
                }else { // si ha acertado el numero acaba el programa
                    break;
                }
            } catch (InputMismatchException e1) { //Comprueba que introduce numeros
                System.out.println("Error introduce el caracter correcto");
                entrada.nextLine();
            }
        }
    }
    public void ejercicio2(){
        Scanner entrada = new Scanner(System.in); //Obtiene lo que introduce el usuario
        int ano_usuario = 0; //creo variables para usar luego
        LocalDateTime ano_act = LocalDateTime.now(); //aquí saco la fecha actual
        int ano_ahora = ano_act.getYear(); // aquí me quedo con el año actual
        boolean error = true;//creo variables para usar luego
        int x = 0;//creo variables para usar luego
        int resscuatro = 0;//creo variables para usar luego
        int resscien= 0;//creo variables para usar luego
        int resscuatorcien = 0;//creo variables para usar luego
        int anosrecor = 0;//creo variables para usar luego
        int bisiesto = 0;//creo variables para usar luego
        while (error == true) { //si se activa el try catch no da error
            try {
                while (ano_usuario < 1900 || ano_usuario > ano_ahora) {//comprueba que no sea menor que 1900 y mayor que el año actual
                    System.out.println("Dime un año");
                    ano_usuario = entrada.nextInt();
                }

                anosrecor = ano_ahora - ano_usuario; //comprueba los años de diferencia que hay entre el introducicdo y el actual
                for (int i = 0; i <= anosrecor; i++) { //hace que se recorran todos los años desde el introducido hasta el actual
                    resscuatro = ano_usuario % 4; //saca el residuo de la división
                    resscien = ano_usuario % 100; //saca el residuo de la división
                    resscuatorcien = ano_usuario % 400; //saca el residuo de la división
                    ano_usuario += 1; //suma 1 al año introducido para obtener el siguiente para cuando pase la siguiente vez
                    if (resscien != 0 && resscuatro == 0) { //si es divisible entre 4 y no entre 100 súma 1 a bisiestos
                        bisiesto++;
                        continue;
                    }else if (resscien == 0 && resscuatorcien == 0) {//si es divisible entre 400 y entre 100 súma 1 a bisiestos
                        bisiesto++;
                        continue;
                    }else if (resscien == 0 && resscuatorcien != 0) { //si es divisible entre 100 y no entre 400 pasa al siguiente año
                        continue;
                    }else if (resscien == 0 && resscuatorcien == 0 && resscuatro == 0) { //si es divisible entre 4 y entre 100 y entre 400 súma 1 a bisiestos
                        bisiesto++;
                        continue;
                    }else if (resscien == 0 && resscuatro != 0 && resscuatro != 0) { //si es divisible entre 100 y no entre 400 y entre 4 pasa al siguiente año
                        continue;
                    }

                }
                System.out.println("Ha habido " + bisiesto + " años bisiestos"); //dice los años bisiestos
                break;
            } catch (InputMismatchException e1) { //Comprueba que se introducen numeros
                System.out.println("Error introduce el caracter correcto");
                entrada.nextLine();
            }
        }
    }
}
