import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Gerente extends Funcionario {

    public Gerente(String nome, LocalDate dataContratacao, double salario) {
        super(nome, dataContratacao, salario);
    }

    // Anos completos de serviço, contados até hoje
    public long anosDeServico() {
        return ChronoUnit.YEARS.between(dataContratacao, LocalDate.now());
    }

    // Sobrescreve: percentual recebido + 1% por cada ano de serviço
    @Override
    public void aumentarSalario(double percentual) {
        double percentualTotal = percentual + anosDeServico();
        super.aumentarSalario(percentualTotal);
    }
}
