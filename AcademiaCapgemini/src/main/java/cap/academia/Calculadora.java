package cap.academia;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

	public static void main(String[] args) throws ParseException {

		//processo de leitura dos dados inseridos
		Scanner sc = new Scanner(System.in);
		DecimalFormat decimalFormat = new DecimalFormat("#0");
		//processo de entrada de dados
		imprimir("Insira o nome do cliente\n");

		String nomeCliente = sc.nextLine();
		imprimir("\n");
		imprimir("Insira o nome do anuncio\n");
		String nomeAnuncio = sc.nextLine();
		imprimir("\n");
		imprimir("Insira seu valor de investimento por dia em reais : \n");
		double investimento = sc.nextFloat();
		imprimir("\n");
		imprimir("Insira a data de início do anúncio neste formato: Ex: 01/01/2021\n");
		String dataInicio = sc.next();
		imprimir("\n");
		imprimir("Insira a data de término do anúncio neste formato: Ex: 01/01/2021\n");
		String dataTermino = sc.next();
		imprimir("\n");

		// este processo recebe a data em formato normal, e trasnforma em horas, para assim fazer o calculo e ficar somente a diferença dos dias.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date primeiraDt = sdf.parse(dataInicio);
		Date segundaDt = sdf.parse(dataTermino);
		long diffEmMil = Math.abs(segundaDt.getTime() - primeiraDt.getTime());
		long diff = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);
		int dias = (int) (diffEmMil / (1000 * 60 * 60 * 24));


		//processo de cálculo para resultados finais
		double visuOriginal = Math.round(investimento * 30); //  a cada 1 real investido, 30 pessoas visualizam.

		double clicam = Math.round(visuOriginal * 0.12); // se a cada 100 pessoas que visualizam 12 clicam, então 12 vira porcentagem.

		double compartilhamRede = Math.round(clicam * 0.15); //se a cada 20 pessoas que clicam 3 compartilham, então 3 vira porcentagem.

		double novasVisualizacoes = Math.round(compartilhamRede * 40); // a cada compartilhamento, 40 pessoas novas visualizam.
		//
		double cliquesGeradosPosCompartilhamento = 0;
		double pessoasQueCompartilharamSecundario = 0;
		//
		for (int i = 1; i < 4; i++) {      // o for é a sequencia de compartilhamentos que vai da primeira pessoa que viu até a quarta.
			for (int j = 0; j < compartilhamRede; j++) {   
				novasVisualizacoes = novasVisualizacoes + 40;
				cliquesGeradosPosCompartilhamento = Math.round(novasVisualizacoes * 0.12);
				pessoasQueCompartilharamSecundario = Math.round(cliquesGeradosPosCompartilhamento * 0.15);
			}
		}

		double totaisVisualizam = (novasVisualizacoes + visuOriginal);   // soma total das pessoas que visualizaram contando as visualizações originais mais as dos compartilhamentos.
		double projecaoCliques = clicam + cliquesGeradosPosCompartilhamento;     // soma total das pessoas que clicaram contando os cliques originais mais as dos compartilhamentos.
		double projecaoCompartilhamento = compartilhamRede + pessoasQueCompartilharamSecundario;     // soma total das pessoas que compartilharam contando os originais mais as dos compartilhamentos.




		// impressão dos valores obtidos nos cálculos acima.

		System.out.println("Seu valor de investimento foi de: " +  dias +" dias\n");
		System.out.println("Seu valor de investimento foi de R$: " + (investimento * dias) +"\n");
		System.out.println("Seu anuncio teve aproximadamente " + new DecimalFormat("#0").format(projecaoCliques * dias) + " cliques\n");
		System.out.println("Seu anuncio teve aproximadamente " + new DecimalFormat("#0").format(projecaoCompartilhamento* dias) + " compartilhamentos\n");
		System.out.println( "e o total de visualizações é aproximadamente : " + new DecimalFormat("#0").format(totaisVisualizam* dias) );  // valor aproximado da quantidade de visualizações, somado os originais mais os compartilhamentos.
		imprimir("\n");


	}

	public static void imprimir(String txt) {
		System.out.print(txt);
	}

}
