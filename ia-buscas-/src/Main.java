import espacoDeEstados.*;
import estrategiasDeBusca.cega.*;
import estrategiasDeBusca.heuristica.*;

import javax.swing.*;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		String buscaDesejada = JOptionPane.showInputDialog("" + "1 - Busca em Largura, " + "2 - Busca Em Profundidade, \n"
				+ "3 - Busca em profundidade Limitada, " + "4 - Busca Informada Best First, \n"
				+ "5 - Busca Informada ASTar, " + "6 - Busca Informada HillClimbing");

		int recuperaValorBuscaDesejada = Integer.valueOf(buscaDesejada);
//
		char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'}; // Inicio
		char[] cfgEnd = { '1', '2', '3', '4', '5', '6', '7', ' ', '8' }; // Fim


//        char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
//        char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
//		  char[] cfgIni = { ' ', '2', '3', '1', '4', '6', '7', '5', '8' };
//        char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'};

		Puzzle8 puzzleInicial = new Puzzle8();
		puzzleInicial.setEstado(cfgIni);
		puzzleInicial.setCusto(0);
		puzzleInicial.setAvaliacao(puzzleInicial.heuristica(cfgEnd));

		Puzzle8 puzzleFinal = new Puzzle8();
		puzzleFinal.setEstado(cfgEnd);
		puzzleFinal.setCusto(0);
		puzzleFinal.setAvaliacao(0);

		/* Realiza escolha de algoritmo */
		switch (recuperaValorBuscaDesejada) {
			case 1:
				long startTime = System.nanoTime();
				BuscaCega busca = new BuscaEmLargura();
				System.out.println("Iniciando em..." + busca.getNomeDaEstrategia());
				busca.setInicio(puzzleInicial);
				busca.setObjetivo(puzzleFinal);
				busca.buscar();

				long endTime = System.nanoTime();

				long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

				for (Estado e : busca.getCaminhoSolucao()) {
					System.out.println(e);
				}
				JOptionPane.showMessageDialog(null,
						"Resultado para" + busca.getNomeDaEstrategia() + " Realizada com sucesso!"+" tendo duração de: "+ duration +" segundos" );
				System.exit(0);
				break;

			case 2:
				BuscaCega buscaEmProfundidade = new BuscaEmProfundidade();
				System.out.println("Iniciando em..." + buscaEmProfundidade.getNomeDaEstrategia());
				buscaEmProfundidade.setInicio(puzzleInicial);
				buscaEmProfundidade.setObjetivo(puzzleFinal);
				buscaEmProfundidade.buscar();



				for (Estado e : buscaEmProfundidade.getCaminhoSolucao()) {
					System.out.println(e);
				}

				JOptionPane.showMessageDialog(null,
						"Resultado para" + buscaEmProfundidade.getNomeDaEstrategia() + " Realizada com sucesso!");
				System.exit(0);
				break;

			case 3:
				BuscaCega buscaEmProfundidadeLimitada = new BuscaEmProfundidadeLimitada(null, null, 16);
				System.out.println("Iniciando em..." + buscaEmProfundidadeLimitada.getNomeDaEstrategia());
				buscaEmProfundidadeLimitada.setInicio(puzzleInicial);
				buscaEmProfundidadeLimitada.setObjetivo(puzzleFinal);
				buscaEmProfundidadeLimitada.buscar();

				for (Estado e : buscaEmProfundidadeLimitada.getCaminhoSolucao()) {
					System.out.println(e);
				}

				JOptionPane.showMessageDialog(null,
						"Resultado para" + buscaEmProfundidadeLimitada.getNomeDaEstrategia() + " Realizada com sucesso!");
				System.exit(0);
				break;

			case 4:
				BuscaInformada buscaInformada = new BestFirst();
				System.out.println("Iniciando em..." + buscaInformada.getNomeDaEstrategia());
				buscaInformada.setInicio(puzzleInicial);
				buscaInformada.setObjetivo(puzzleFinal);
				buscaInformada.buscar();

				for (Estado e : buscaInformada.getCaminhoSolucao()) {
					System.out.println(e);
				}

				JOptionPane.showMessageDialog(null,
						"Resultado para" + buscaInformada.getNomeDaEstrategia() + " Realizada com sucesso!");
				System.exit(0);
				break;
			case 5:
				BuscaInformada buscaInformataAstar = new AStar();
				System.out.println("Iniciando em..." + buscaInformataAstar.getNomeDaEstrategia());
				buscaInformataAstar.setInicio(puzzleInicial);
				buscaInformataAstar.setObjetivo(puzzleFinal);
				buscaInformataAstar.buscar();

				for (Estado e : buscaInformataAstar.getCaminhoSolucao()) {
					System.out.println(e);
				}

				JOptionPane.showMessageDialog(null,
						"Resultado para" + buscaInformataAstar.getNomeDaEstrategia() + " Realizada com sucesso!");
				System.exit(0);
				break;

			case 6:
				BuscaInformada buscaHillClimbing = new HillClimbing();
				System.out.println("Iniciando em..." + buscaHillClimbing.getNomeDaEstrategia());
				buscaHillClimbing.setInicio(puzzleInicial);
				buscaHillClimbing.setObjetivo(puzzleFinal);
				buscaHillClimbing.buscar();

				for (Estado e : buscaHillClimbing.getCaminhoSolucao()) {
					System.out.println(e);
				}

				JOptionPane.showMessageDialog(null,
						"Resultado para" + buscaHillClimbing.getNomeDaEstrategia() + " Realizada com sucesso!");
				System.exit(0);
		}

//		BuscaCega busca = new BuscaEmLargura();
//		BuscaCega busca = new BuscaEmProfundidade();
//		BuscaCega busca = new BuscaEmProfundidadeLimitada(null, null, 16);

//		BuscaInformada busca = new BestFirst();
//		BuscaInformada busca = new AStar();
//		BuscaInformada busca = new HillClimbing();

//		busca.setInicio(puzzleInicial);
//		busca.setObjetivo(puzzleFinal);
//		busca.buscar();

//		for(Estado e : busca.getCaminhoSolucao()) {
//			System.out.println(e);
//		}

	}

}
