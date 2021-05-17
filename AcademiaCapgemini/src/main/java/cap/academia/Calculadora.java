package cap.academia;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
		imprimir("Insira a data de in�cio do an�ncio neste formato: Ex: 01/01/2021\n");
		String dataInicio = sc.next();
		imprimir("\n");
		imprimir("Insira a data de t�rmino do an�ncio neste formato: Ex: 01/01/2021\n");
		String dataTermino = sc.next();
		imprimir("\n");

		// este processo recebe a data em formato normal, e trasnforma em horas, para assim fazer o calculo e ficar somente a diferen�a dos dias.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date primeiraDt = sdf.parse(dataInicio);
		Date segundaDt = sdf.parse(dataTermino);
		long diffEmMil = Math.abs(segundaDt.getTime() - primeiraDt.getTime());
		long diff = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);
		int dias = (int) (diffEmMil / (1000 * 60 * 60 * 24));


		//processo de c�lculo para resultados finais
		double visuOriginal = Math.round(investimento * 30); //  a cada 1 real investido, 30 pessoas visualizam.

		double clicam = Math.round(visuOriginal * 0.12); // se a cada 100 pessoas que visualizam 12 clicam, ent�o 12 vira porcentagem.

		double compartilhamRede = Math.round(clicam * 0.15); //se a cada 20 pessoas que clicam 3 compartilham, ent�o 3 vira porcentagem.

		double novasVisualizacoes = Math.round(compartilhamRede * 40); // a cada compartilhamento, 40 pessoas novas visualizam.
		//
		double cliquesGeradosPosCompartilhamento = 0;
		double pessoasQueCompartilharamSecundario = 0;
		//
		for (int i = 1; i < 4; i++) {      // o for � a sequencia de compartilhamentos que vai da primeira pessoa que viu at� a quarta.
			for (int j = 0; j < compartilhamRede; j++) {   
				novasVisualizacoes = novasVisualizacoes + 40;
				cliquesGeradosPosCompartilhamento = Math.round(novasVisualizacoes * 0.12);
				pessoasQueCompartilharamSecundario = Math.round(cliquesGeradosPosCompartilhamento * 0.15);
			}
		}

		double totaisVisualizam = (novasVisualizacoes + visuOriginal);   // soma total das pessoas que visualizaram contando as visualiza��es originais mais as dos compartilhamentos.
		double projecaoCliques = clicam + cliquesGeradosPosCompartilhamento;     // soma total das pessoas que clicaram contando os cliques originais mais as dos compartilhamentos.
		double projecaoCompartilhamento = compartilhamRede + pessoasQueCompartilharamSecundario;     // soma total das pessoas que compartilharam contando os originais mais as dos compartilhamentos.




		// impress�o dos valores obtidos nos c�lculos acima.

		System.out.println("Seu valor de investimento foi de: " +  dias +" dias\n");
		System.out.println("Seu valor de investimento foi de R$: " + (investimento * dias) +"\n");
		System.out.println("Seu anuncio teve aproximadamente " + new DecimalFormat("#0").format(projecaoCliques * dias) + " cliques\n");
		System.out.println("Seu anuncio teve aproximadamente " + new DecimalFormat("#0").format(projecaoCompartilhamento* dias) + " compartilhamentos\n");
		System.out.println( "e o total de visualiza��es � aproximadamente : " + new DecimalFormat("#0").format(totaisVisualizam* dias) );  // valor aproximado da quantidade de visualiza��es, somado os originais mais os compartilhamentos.
		imprimir("\n");


	}

	public static void imprimir(String txt) {
		System.out.print(txt);
	}

}
