package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int seleccion;
        do {
            System.out.println("1. Expressions Regulars");
            System.out.println("2. Sense Expressions Regulars");
            System.out.println("3. Sortir");
            System.out.println("Introduce un numero entre 1-3: ");
            seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1 -> ExpressionsRegulars();
                case 2 -> PareNoel();
                case 3 -> System.out.println("Adios...");
                default -> System.out.println("Introduce un numero entre 1 y 2");
            }
        } while (seleccion != 3);
    }

    public static void PareNoel() throws IOException {
        //Coger fichero y guardarlo en una variable y un reader.
        File santako = new File("D:\\Downloads\\SurgeryJDBC\\PareNoel\\src\\santako.txt");
        BufferedReader br = new BufferedReader(new FileReader(santako));

        String linea = br.readLine();

        for (int i = 0; i < 4; i++) {

            //Contadores para cada tipo
            int parenoelCounter = 0;
            int rensCounter = 0;
            int folletCounter = 0;

            //Comprobar lo que contiene cada linea
            if (linea.contains("*<]:-DOo")){
                parenoelCounter = linea.length() - linea.replaceAll("\\*<]:-DOo","").length();
                if (parenoelCounter >= 8){
                    parenoelCounter = parenoelCounter / 8;
                }
            } else if (linea.contains("<]:-D")){
                folletCounter = linea.length() - linea.replaceAll("<]:-D","").length() - 4;
                if (folletCounter >= 5){
                    folletCounter = folletCounter / 5;
                }
            }

            if (linea.contains(">:o)")){
                rensCounter = linea.length() - linea.replaceAll(">:o\\)","").length() - 3;
                if (rensCounter >= 4){
                    rensCounter = rensCounter / 4;
                }
            }



            //Print las veces que aparecen cada uno
            if (parenoelCounter != 0 ) {
                System.out.print("Pare Noel (" + parenoelCounter + ") ");
            }

            if (rensCounter != 0 ) {
                System.out.print("Ren (" + rensCounter + ") ");
            }

            if (folletCounter != 0) {
                System.out.print("Follet (" + folletCounter + ") ");
            }

            //Espacio de linea y lee la siguiente linea
            System.out.println("");
            linea = br.readLine();
        }
    }

    public static void ExpressionsRegulars() throws IOException {
        //Coger fichero y guardarlo en una variable y un reader.
        File santako = new File("D:\\Downloads\\SurgeryJDBC\\PareNoel\\src\\santako.txt");
        BufferedReader br = new BufferedReader(new FileReader(santako));

        //Patrones de papanoel, reno y ayudantes
        Pattern PareNoel = Pattern.compile("\\*<]:-DOo");
        Pattern Rens = Pattern.compile(">:o\\)");
        Pattern Follet = Pattern.compile("[^*]<]:-D");

        //Lee la linea del fichero
        String linea = br.readLine();

        for (int i = 0; i < 4; i++) {

            //Matchers para cada tipo
            Matcher mPareNoel = PareNoel.matcher(linea);
            Matcher mRens = Rens.matcher(linea);
            Matcher mFollet = Follet.matcher(linea);

            //Contadores para cada tipo
            int parenoelCounter = 0;
            int rensCounter = 0;
            int folletCounter = 0;


            //Ahora el find de papanoel, suma 1 al contador y imprime la cantidad de papanoels
            while (mPareNoel.find()){
                parenoelCounter++;
            }

            if (parenoelCounter != 0 ) {
                System.out.print("Pare Noel (" + parenoelCounter + ") ");
            }

            //Ahora el find de renos, suma 1 al contador y imprime la cantidad de renos
            while (mRens.find()){
                rensCounter++;
            }

            if (rensCounter != 0 ) {
                System.out.print("Ren (" + rensCounter + ") ");
            }

            //Ahora el find de ayudantes, suma 1 al contador y imprime la cantidad de ayudantes
            while (mFollet.find()){
                folletCounter++;
            }

            if (folletCounter != 0) {
                System.out.print("Follet (" + folletCounter + ") ");
            }

            //Espacio de linea y lee la siguiente linea
            System.out.println("");
            linea = br.readLine();
        }
        System.out.println(" ");
    }
}
