
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "dados.json";
        Scanner sc = new Scanner(System.in);

        //1 Valor da soma é 91
        System.out.println("Valor da soma é 91");

        //2
        System.out.println("Testar se numero é um fibonacci: ");
        int fibo = sc.nextInt();
        System.out.println(new Fibonacci().fibonacci(fibo));


        //3
        FaturamentoLeitorArquivo leitor = new FaturamentoLeitorArquivo(caminhoArquivo);
        FaturamentoMensal faturamentoMensal = new FaturamentoMensal();

        Map<Integer, Double> faturamentoMap = null;
        try {
            faturamentoMap = leitor.lerFaturamentoMensal();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (faturamentoMap != null) {
            double menorValor = faturamentoMensal.menorValor(new HashMap<>(faturamentoMap));
            double maiorValor = faturamentoMensal.maiorValor(new HashMap<>(faturamentoMap));
            int valoresAcimaDaMedia = faturamentoMensal.mediaValor(new HashMap<>(faturamentoMap));

            System.out.println("Menor valor de faturamento: R$ " + menorValor);
            System.out.println("Maior valor de faturamento: R$ " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + valoresAcimaDaMedia);
        }


        //4 Porcentagem de faturamento de cada estado

        HashMap<String, Double> distribuidoraMap = new HashMap<>();
        distribuidoraMap.put("SP", 67836.43);
        distribuidoraMap.put("RJ", 36678.66);
        distribuidoraMap.put("MG", 29229.88);
        distribuidoraMap.put("ES", 27165.48);

        FaturamentoDistribuidora fd = new FaturamentoDistribuidora();
        Map<String, Double> porcentagem = fd.percentualEstado(distribuidoraMap);

        for (Map.Entry<String, Double> entry : porcentagem.entrySet()) {
            String estado = entry.getKey();
            Double percentual = entry.getValue();
            System.out.printf("Estado: %s, Percentual: %.2f%%%n", estado, percentual);
        }

        //5 Inverter String
        System.out.println("Inverter String: ");
        String string = sc.next();
        System.out.println(new InverterString().inverterString(string));

    }
}