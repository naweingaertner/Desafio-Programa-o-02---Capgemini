package CAPGEMINI_002;

import java.util.Scanner;

public class questao1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tamanho = 0;
        int[] numeros = new int[0];

        // validamos se o tamanho do array escolhido é ímpar
        while (tamanho % 2 == 0){
            System.out.println("Digite o tamanho do array a ser preenchido (deve ser ímpar): ");
            System.out.println("Digite 99 para executar o exemplo teste = [9, 2, 1, 4, 6]");
            tamanho = scan.nextInt();
            if (tamanho == 99){
                numeros = new int[]{9, 2, 1, 4, 6};
                break;
            }
            if (tamanho % 2 == 0)
                System.out.println("O número informado não é ímpar");
            else{
                // populamos o array
                numeros = new int[tamanho];
                for (int i = 0; i < tamanho; i++){
                    System.out.println("Digite o "+(i+1)+"ª elemento do array");
                    numeros[i] = scan.nextInt();
                }
            }

        }

        // primeiramente devemos ordenar o array em ordem crescente. Para isso
        // iteramos toda a lista. Para cada elemento pegamos os seus antecessores
        // e os substituimos caso o valor atual da iteração seja maior seu antecessor
        for (int i = 1; i < numeros.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numeros[j] < numeros[j - 1]) {
                    // usamos um auxiliar para realizar a troca entre as posições
                    int aux = numeros[j];
                    numeros[j] = numeros[j - 1];
                    numeros[j - 1] = aux;
                }
            }
        }
        // como ocorre a validação, garantimos que o array é impar. Sabendo que o indice inicial é 0,
        // a subtração de 1 e a divisão por 2 com certeza sempre trará a mediana do array
        int mediana = (numeros.length - 1) / 2;
        mediana = numeros[mediana];
        System.out.println("A mediana é: "+mediana);
    }
}