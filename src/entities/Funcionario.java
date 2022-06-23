package entities;

public class Funcionario {
	private Integer id;
	private String nome;
	private Double salario;

	public Funcionario(Integer id, String nome, Double salary) {
		this.id = id;
		this.nome = nome;
		this.salario = salary;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalary() {
		return salario;
	}

	public void incrementarSalario(int percentual) {
		salario += salario * percentual / 100;
	}

	@Override
	public String toString() {
		return "id: " + id + "\n" + "Nome: " + nome + "\n" + "Salario: " + String.format("%.2f", salario);
	}

}
