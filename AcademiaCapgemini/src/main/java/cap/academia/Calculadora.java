package cap.academia;

import java.text.DecimalFormat;
import java.util.Scanner;

/*1ª Parte - Considere os seguintes critérios fictícios para desenvolver a calculadora de alcance de anúncio:

Baseados em dados de análise de anúncios anteriores, a agência tem os seguintes dados:

a cada 100 pessoas que visualizam o anúncio 12 clicam nele.    ok
a cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.    ok
cada compartilhamento nas redes sociais gera 40 novas visualizações.   ok
30 pessoas visualizam o anúncio original (não compartilhado) a cada R$ 1,00 investido.   ok
o mesmo anúncio é compartilhado no máximo 4 vezes em sequência
(1ª pessoa -> compartilha -> 2ª pessoa -> compartilha - > 3ª pessoa -> compartilha -> 4ª pessoa)   ok

Crie um script em sua linguagem de programação preferida que receba o valor investido em reais
e retorne uma projeção aproximada da quantidade máxima de pessoas que visualizarão
o mesmo anúncio (considerando o anúncio original + os compartilhamentos)*/


public class Calculadora {

	public static void main(String[] args) {

		//processo de leitura dos dados inseridos
		Scanner sc = new Scanner(System.in);
		DecimalFormat decimalFormat = new DecimalFormat("#0");

		//processo de entrada de dados
		System.out.println("Insira seu valor de investimento em reais : ");
		long investimento = sc.nextLong();
		System.out.println("Seu valor de investimento foi de R$ : " + investimento);

		//processo de cálculo para resultados finais

		long visuOriginal = (investimento * 30); //  a cada 1 real investido, 30 pessoas visualizam.

		long clicam = (long) (visuOriginal * 0.12); // se a cada 100 pessoas que visualizam 12 clicam, então 12 vira porcentagem.

		long compartilhamRede = (long) (clicam * 0.15); //se a cada 20 pessoas que clicam 3 compartilham, então 3 vira porcentagem.

		long novasVisualizacoes = (compartilhamRede * 40); // a cada compartilhamento, 40 pessoas novas visualizam.

		long  x = (40 * compartilhamRede) * 3;


		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < compartilhamRede; j++) {   // o for é a sequencia de compartilhamentos que vai da primeira pessoa que viu até a quarta.
				novasVisualizacoes = novasVisualizacoes + 40;
			}
		}

		long totaisVisualizam = (novasVisualizacoes + visuOriginal);   // soma total das pessoas que visualizaram contando as visualizações originais mais as dos compartilhamentos.

		System.out.println(visuOriginal + x);

		// impressão dos valores obtidos nos cálculos acima.

		System.out.println( "a cada " + investimento +  " investido : " + new DecimalFormat("#0").format(visuOriginal) + " pessoas visualizam" ); // valor das pessoas que visualizam de acordo com o investimento.

		System.out.println( "a cada " + new DecimalFormat("#0").format(visuOriginal) + " visualizam : " + new DecimalFormat("#0").format(clicam) + " pessoas clicam" );  // valor das pessoas que clicam de acordo com as visualizações.

		System.out.println( "a cada " + new DecimalFormat("#0").format(clicam) + " clicam : " + new DecimalFormat("#0").format(compartilhamRede) + " pessoas compartilham" ); // valor das pessoas que compartilham de acordo com o valor dos cliques.

		System.out.println( "a cada " + new DecimalFormat("#0").format(compartilhamRede) + " compartilham : " + new DecimalFormat("#0").format(novasVisualizacoes) + " novas pessoas visualizam");  // valor das novas visualizações de acordo com a sequencia de compartilhamentos.

		System.out.println( "e o total de visualizações é aproximadamente : " + new DecimalFormat("#0").format(totaisVisualizam) );  // valor aproximado da quantidade de visualizações, somado os originais mais os compartilhamentos.


		sc.close();

	}

}
