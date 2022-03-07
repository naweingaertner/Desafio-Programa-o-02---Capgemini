package CAPGEMINI_002;

import java.util.Objects;
import java.util.Scanner;

public class questao3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // captamos a string
        System.out.println("Informa a palavra/frase a ser criptografada");
        System.out.println("Digite 'exemplo' para selecionar a do exemplo = 'tenha um bom dia' ");
        String palavra = scan.nextLine();
        if (Objects.equals(palavra, "exemplo"))
            palavra = "tenha um bom dia";

        // removemos os espaços e transformamos A PALAVRA em um array de chars
        palavra = palavra.replaceAll("\\s+","");
        char[] list = palavra.toCharArray();

        // tiramos a raiz quadrada comprimento da string e arrendodamos para cima caso necessário,
        // para não faltar espaços
        double raiz = Math.ceil(Math.sqrt(palavra.length()));
        int size  = (int) raiz;

        // declaramos a matriz (grid) do tamanho da raiz encontrada.
        // Populamos ela com os elementos do array anterriormente feito
        char[][] enigma = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                // para conseguir o indice corretto do array multiplicamos
                //  a quantidade de linhas ja percorridas pelo seu comprimento e somamos com a posição da linha atual
                int idx = i*size + j;
                if (idx > palavra.length()-1)
                    break;
                enigma[i][j] = list[idx];
            }
        }
        // montamos a mensagem encriptografada percorrendo a matriz anterior
        // no sentido inverso ao convencional (coluna -> linha)
        String mensagem = "";
        for (int i = 0; i < size; i++){
            mensagem +=" ";
            for (int j = 0; j < size; j++){
                // verificação para chars da matriz não definidos não serem adicionados a mensagem
                if (Character.isIdentifierIgnorable(enigma[j][i]))
                    continue;
                mensagem+=enigma[j][i];
            }
        }
        System.out.println("A mensagem criptografada é: "+mensagem);
    }
}