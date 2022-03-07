package CAPGEMINI_002;

import java.util.Scanner;

public class questao2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // declaramos o array com o tamanho informado pelo usuário
        int[] numeros;
        System.out.println("Digite o tamanho do array a ser preenchido: ");
        System.out.println("Digite 99 para executar o exemplo teste = [1, 5, 3, 4, 2]");
        int tamanho = scan.nextInt();
        if (tamanho == 99) {
            numeros = new int[]{1, 5, 3, 4, 2};
        } else {
            // ceclaramos o array
            numeros = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                System.out.println("Digite o " + (i + 1) + "ª elemento do array");
                numeros[i] = scan.nextInt();

            }
        }

        // declaramos o o valor a ser calculado na diferença pelo input do usuário
        System.out.println("o valor da diferença a ser calculada no intervalo: ");
        int diferenca = scan.nextInt();
        int intervalos = 0;


        //  para cada elemento do array, pegamos todos os seus sucessores e
        //  subtraimos ambos das duas formas (a-b | b-a) para garantir que ali há ou não o intervalo
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int aux = i; aux < numeros.length; aux++) {
                if (numeros[i] - numeros[aux] == diferenca || numeros[aux] - numeros[i] == diferenca) {
                    intervalos++;
                }
            }
        }
        System.out.println(intervalos);

    }
}