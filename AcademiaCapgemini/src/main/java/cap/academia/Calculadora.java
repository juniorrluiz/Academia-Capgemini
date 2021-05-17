package cap.academia;

import java.text.DecimalFormat;
import java.util.Scanner;

/*1� Parte - Considere os seguintes crit�rios fict�cios para desenvolver a calculadora de alcance de an�ncio:

Baseados em dados de an�lise de an�ncios anteriores, a ag�ncia tem os seguintes dados:

a cada 100 pessoas que visualizam o an�ncio 12 clicam nele.    ok
a cada 20 pessoas que clicam no an�ncio 3 compartilham nas redes sociais.    ok
cada compartilhamento nas redes sociais gera 40 novas visualiza��es.   ok
30 pessoas visualizam o an�ncio original (n�o compartilhado) a cada R$ 1,00 investido.   ok
o mesmo an�ncio � compartilhado no m�ximo 4 vezes em sequ�ncia
(1� pessoa -> compartilha -> 2� pessoa -> compartilha - > 3� pessoa -> compartilha -> 4� pessoa)   ok

Crie um script em sua linguagem de programa��o preferida que receba o valor investido em reais
e retorne uma proje��o aproximada da quantidade m�xima de pessoas que visualizar�o
o mesmo an�ncio (considerando o an�ncio original + os compartilhamentos)*/


public class Calculadora {

	public static void main(String[] args) {

		//processo de leitura dos dados inseridos
		Scanner sc = new Scanner(System.in);
		DecimalFormat decimalFormat = new DecimalFormat("#0");

		//processo de entrada de dados
		System.out.println("Insira seu valor de investimento em reais : ");
		long investimento = sc.nextLong();
		System.out.println("Seu valor de investimento foi de R$ : " + investimento);

		//processo de c�lculo para resultados finais

		long visuOriginal = (investimento * 30); //  a cada 1 real investido, 30 pessoas visualizam.

		long clicam = (long) (visuOriginal * 0.12); // se a cada 100 pessoas que visualizam 12 clicam, ent�o 12 vira porcentagem.

		long compartilhamRede = (long) (clicam * 0.15); //se a cada 20 pessoas que clicam 3 compartilham, ent�o 3 vira porcentagem.

		long novasVisualizacoes = (compartilhamRede * 40); // a cada compartilhamento, 40 pessoas novas visualizam.

		long  x = (40 * compartilhamRede) * 3;


		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < compartilhamRede; j++) {   // o for � a sequencia de compartilhamentos que vai da primeira pessoa que viu at� a quarta.
				novasVisualizacoes = novasVisualizacoes + 40;
			}
		}

		long totaisVisualizam = (novasVisualizacoes + visuOriginal);   // soma total das pessoas que visualizaram contando as visualiza��es originais mais as dos compartilhamentos.

		System.out.println(visuOriginal + x);

		// impress�o dos valores obtidos nos c�lculos acima.

		System.out.println( "a cada " + investimento +  " investido : " + new DecimalFormat("#0").format(visuOriginal) + " pessoas visualizam" ); // valor das pessoas que visualizam de acordo com o investimento.

		System.out.println( "a cada " + new DecimalFormat("#0").format(visuOriginal) + " visualizam : " + new DecimalFormat("#0").format(clicam) + " pessoas clicam" );  // valor das pessoas que clicam de acordo com as visualiza��es.

		System.out.println( "a cada " + new DecimalFormat("#0").format(clicam) + " clicam : " + new DecimalFormat("#0").format(compartilhamRede) + " pessoas compartilham" ); // valor das pessoas que compartilham de acordo com o valor dos cliques.

		System.out.println( "a cada " + new DecimalFormat("#0").format(compartilhamRede) + " compartilham : " + new DecimalFormat("#0").format(novasVisualizacoes) + " novas pessoas visualizam");  // valor das novas visualiza��es de acordo com a sequencia de compartilhamentos.

		System.out.println( "e o total de visualiza��es � aproximadamente : " + new DecimalFormat("#0").format(totaisVisualizam) );  // valor aproximado da quantidade de visualiza��es, somado os originais mais os compartilhamentos.


		sc.close();

	}

}
