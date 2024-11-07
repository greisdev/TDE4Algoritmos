import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] arquivos = {
            "conjuntosDeDados/aleatorio_100.csv",
            "conjuntosDeDados/aleatorio_1000.csv",
            "conjuntosDeDados/aleatorio_10000.csv",
            "conjuntosDeDados/crescente_100.csv",
            "conjuntosDeDados/crescente_1000.csv",
            "conjuntosDeDados/crescente_10000.csv",
            "conjuntosDeDados/decrescente_100.csv",
            "conjuntosDeDados/decrescente_1000.csv",
            "conjuntosDeDados/decrescente_10000.csv"
        };

        System.out.printf("%-40s %-20s %-20s %-20s%n", "Arquivo", "Bubble Sort (ns)", "Insertion Sort (ns)", "Quick Sort (ns)");

        for (String arquivo : arquivos) {
            int[] dados = lerCSV(arquivo);
            System.out.printf("%-40s ", arquivo);

            
            int[] bubbleData = dados.clone();
            long inicioBubble = System.nanoTime();
            BubbleSort.sort(bubbleData);
            long tempoBubble = System.nanoTime() - inicioBubble;
            System.out.printf("%-20d ", tempoBubble);

            
            int[] insertionData = dados.clone();
            long inicioInsertion = System.nanoTime();
            InsertionSort.sort(insertionData);
            long tempoInsertion = System.nanoTime() - inicioInsertion;
            System.out.printf("%-20d ", tempoInsertion);

            
            int[] quickData = dados.clone();
            long inicioQuick = System.nanoTime();
            QuickSort.sort(quickData, 0, quickData.length - 1);
            long tempoQuick = System.nanoTime() - inicioQuick;
            System.out.printf("%-20d%n", tempoQuick);
        }
    }

    public static int[] lerCSV(String arquivo) {
        List<Integer> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine(); 
            while ((linha = br.readLine()) != null) {
                lista.add(Integer.parseInt(linha.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista.stream().mapToInt(i -> i).toArray();
    }
}
