import java.time.LocalDate;

public class Funcionario {

    protected String nome;
    protected LocalDate dataContratacao;
    protected double salario;

    public Funcionario(String nome, LocalDate dataContratacao, double salario) {
        this.nome = nome;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }

    // Aumenta o salário segundo o percentual recebido (ex.: 10 = 10%)
    public void aumentarSalario(double percentual) {
        salario = salario + salario * percentual / 100;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format("%s | contratado em %s | salário: R$ %.2f",
                nome, dataContratacao, salario);
    }
}
