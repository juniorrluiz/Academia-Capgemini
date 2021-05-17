package cap.academia.classe;

import java.text.ParseException;
import java.util.Scanner;


public class CadastroAnuncios {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo ao Divulga Tudo!\n");
		System.out.println("Insira quantos anuncios deseja cadastrar: \n");
		int anuncios = sc.nextInt();

		String[] infoAnuncios = new String [5];
		String inf = "";

		CalculadoraAnuncios dadosDoAnuncio[] =  new CalculadoraAnuncios[anuncios];

		String[] dadosAnuncio = {"o nome do anuncio", "o cliente","o valor investido por dia (em reais)",
				"a data de início (dd/mm/yyyy)", "a data de término (dd/mm/yyyy)",};

		for (int i = 0; i<anuncios; i++) {
			int j = 0;
			while(j<5) {
				System.out.println("Para inserir os dados do anuncio, digite " + dadosAnuncio[j] + ":");
				inf = sc.next();
				infoAnuncios[j] = inf;
				j++;
			}
			dadosDoAnuncio[i] = new CalculadoraAnuncios();
			dadosDoAnuncio[i].setNome(infoAnuncios);
			dadosDoAnuncio[i].setCliente(infoAnuncios);
			dadosDoAnuncio[i].setInvestimentoPorDia(infoAnuncios);
			dadosDoAnuncio[i].setDataInicio(infoAnuncios);
			dadosDoAnuncio[i].setDataTermino(infoAnuncios);
			System.out.println("\n");
			System.out.println("Anuncio cadastrado com sucesso! \n");
		}

		System.out.println("Para ver os relatorios do anuncio inserido digite o numero do anuncio (Lembrando que o anuncio começa com 0: \n");
		int relatorio = sc.nextInt();
		System.out.println("\n");

		System.out.println("Valor total investido: R$" + dadosDoAnuncio[relatorio].calculadora() + "\n");
		System.out.println("\n");

		int opcao = 4;
		while (opcao != 0) {
			System.out.println("Para ir ao relatorio por cliente digite o numero (1), "
					+ "para intervalo de tempo digite o numero( 2). "
					+ "Para encerrar digite 0 (zero):");
			opcao = sc.nextInt();
			System.out.println("\n");
			if (opcao == 0) {
				System.out.println("Obrigado por utilizar nossos sistemas, até a próxima!");
			}
			else if (opcao == 1) {	
				System.out.println("Digite o nome do cliente cadastrado: ");
				String nomeCliente = sc.next();

				for (int i=0; i<anuncios; i++) {
					if (nomeCliente.equals(dadosDoAnuncio[i].getCliente())) {
						System.out.println(" Relatório(s) cadastrado(s) pelo cliente " + nomeCliente + ": \n");
						System.out.println("Valor total investido: R$" + dadosDoAnuncio[i].calculadora());
						System.out.println("\n");
					}
				}
			} else if (opcao == 2) {
				System.out.println("Digite uma data (dd/mm/yyyy): ");
				String data = sc.next();

				for (int i=0; i<anuncios; i++) {
					if (data.equals(dadosDoAnuncio[i].getDataInicio()) || data.equals(dadosDoAnuncio[i].getDataTermino())) {
						System.out.println("Relatório(s) cadastrado(s) pela data " + data + ": \n");
						System.out.println("Nome do Cliente: " + dadosDoAnuncio[i].getCliente());
						System.out.println("Valor total investido: R$" + dadosDoAnuncio[i].calculadora());
						System.out.println("\n");
					} else {
						System.out.println("Data inserida não encontrada no Anúncio " + anuncios);
						System.out.println("\n");
					}
				}
			} 
		}
	}
}
