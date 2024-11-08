import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Arquivos {
    public static int[] lerCSV(String caminho) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        StringBuilder sb = new StringBuilder();

        
        br.readLine(); 

        
        while ((linha = br.readLine()) != null) {
            sb.append(linha).append("\n");
        }
        br.close();

        
        String[] valores = sb.toString().split("\n");
        int[] array = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            array[i] = Integer.parseInt(valores[i].trim());
        }
        return array;
    }
}
