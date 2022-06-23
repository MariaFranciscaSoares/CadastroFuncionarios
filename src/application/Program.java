package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.println("Digite o numero de funcionários que será cadastrados: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Funcionáro " + "0" + (i + 1) + ":");
			System.out.println("Digite o Id do funcinário: ");
			Integer numId = sc.nextInt();
			while (hasId(list, numId)) {
				System.out.println("Id já existente. Digite outro Id:");
				numId = sc.nextInt();
			}

			System.out.println("Digite o nome do funcinário: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Digite o salário do funcinário: ");
			Double salario = sc.nextDouble();
			list.add(new Funcionario(numId, nome, salario));
		}
		System.out.println();
		System.out.println("Informe o Id do funcionário que terá aumento salarial:");
		int id = sc.nextInt();
		Funcionario fun = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		if (fun == null)
			System.out.println("Id não existente!");
		else {
			System.out.println("Digite o percetual de aumento salarial: ");
			int percetual = sc.nextInt();
			fun.incrementarSalario(percetual);
		}

		System.out.println("Lista dos Funcionarios");

		for (Funcionario obj : list) {
			System.out.println();
			System.out.println(obj);
		}

		sc.close();
	}

	public static boolean hasId(List<Funcionario> listBusca, int id) {
		Funcionario fun = listBusca.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return fun != null;
	}

}
