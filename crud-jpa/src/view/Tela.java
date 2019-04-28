
package view;

import java.util.Scanner;

import model.FuncionarioDAO;

public class Tela extends FuncionarioDAO {

	private Scanner s;

	public void tela() {

		s = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("\n\n### Seja bem vindo ao Sistema de cadastro de funcionario! ###");
			System.out.println("\n                  ====================================");
			System.out.println("                  |     1 - Cadastrar funcionario    |");
			System.out.println("                  |     2 - Listar funcionarios      |");
			System.out.println("                  |     3 - Atualizar funcionario    |");
			System.out.println("                  |     4 - Deletar funcionario      |");
			System.out.println("                  |     0 - Sair                     |");
			System.out.println("                  |==================================|\n");
			opcao = s.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 1:
				this.salvarFuncionario();
				break;
			case 2:
				this.listarFuncionario();
				break;
			case 3:
				this.AtualizarFuncionario();
				break;
			case 4:
				this.excluirFuncionaio(null);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		} while (opcao != 0);

	}

}
