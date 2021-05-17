package cap.academia.classe;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalculadoraAnuncios {

	private String nome;
	private String cliente;
	private String dataInicio;
	private String dataTermino;
	private double investimentoPorDia;

	public String calculadora() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date primeiraDt = sdf.parse(this.dataInicio);
		Date segundaDt = sdf.parse(this.dataTermino);
		long diffEmMil = Math.abs(segundaDt.getTime() - primeiraDt.getTime());
		long diff = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);
		int dias = (int) (diffEmMil / (1000 * 60 * 60 * 24));

		Double investimento = (this.investimentoPorDia * dias);
		String valorTotalInvestido = String.format("%.2f", (this.investimentoPorDia * dias));


		// Processo de cálculo para resultados finais
		double visuOriginal = Math.round(this.investimentoPorDia * 30); //  a cada 1 real investido, 30 pessoas visualizam.

		double clicam = Math.round(visuOriginal * 0.12); // se a cada 100 pessoas que visualizam 12 clicam, então 12 vira porcentagem.

		double compartilhamRede = Math.round(clicam * 0.15); //se a cada 20 pessoas que clicam 3 compartilham, então 3 vira porcentagem.

		double novasVisualizacoes = Math.round(compartilhamRede * 40); // a cada compartilhamento, 40 pessoas novas visualizam.

		double cliquesGeradosPosCompartilhamento = 0;
		double pessoasQueCompartilharamSecundario = 0;

		for (int i = 1; i < 4; i++) {      // o for é a sequencia de compartilhamentos que vai da primeira pessoa que viu até a quarta.
			for (int j = 0; j < compartilhamRede; j++) {   
				novasVisualizacoes = novasVisualizacoes + 40;
				cliquesGeradosPosCompartilhamento = Math.round(novasVisualizacoes * 0.12);
				pessoasQueCompartilharamSecundario = Math.round(cliquesGeradosPosCompartilhamento * 0.15);
			}
		}

		double totaisVisualizam = novasVisualizacoes + visuOriginal;   // soma total das pessoas que visualizaram contando as visualizações originais mais as dos compartilhamentos.
		double projecaoCliques = clicam + cliquesGeradosPosCompartilhamento;     // soma total das pessoas que clicaram contando os cliques originais mais as dos compartilhamentos.
		double projecaoCompartilhamento = compartilhamRede + pessoasQueCompartilharamSecundario;     // soma total das pessoas que compartilharam contando os originais mais as dos compartilhamentos.

		// Impressão dos valores obtidos nos cálculos acima.
		System.out.println("Seu investimento foi de: " +  dias +" dias\n");
		System.out.println("Seu valor de investimento foi de R$: " + (this.investimentoPorDia * dias) +"\n");
		System.out.println( "e o total de visualizações é aproximadamente : " + new DecimalFormat("#0").format(totaisVisualizam * dias) + "\n");  // valor aproximado da quantidade de visualizações, somado os originais mais os compartilhamentos.
		System.out.println("Seu anuncio teve aproximadamente " + new DecimalFormat("#0").format(projecaoCliques * dias) + " cliques\n");
		System.out.println("Seu anuncio teve aproximadamente " + new DecimalFormat("#0").format(projecaoCompartilhamento * dias) + " compartilhamentos\n");

		return valorTotalInvestido;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String[] nome) {
		this.nome = nome[0];
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String[] cliente) {
		this.cliente = cliente[1];
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setInvestimentoPorDia(String[] infoAnuncios) {
		this.investimentoPorDia = Double.parseDouble(infoAnuncios[2]);
	}
	public void setDataInicio(String[] dataInicio) {
		this.dataInicio = dataInicio[3];
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String[] dataTermino) {
		this.dataTermino = dataTermino[4];
	}
	public double getInvestimentoPorDia() {
		return investimentoPorDia;
	}

	public static void imprimir(String txt) {
		System.out.print(txt);
	}

}
