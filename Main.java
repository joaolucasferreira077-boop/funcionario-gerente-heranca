import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // 2. Instanciando e usando as classes
        Funcionario func = new Funcionario("Maria Silva", LocalDate.of(2020, 3, 10), 3000.00);
        Gerente ger = new Gerente("Carlos Souza", LocalDate.of(2015, 6, 1), 8000.00);

        double percentual = 10; // 10%

        System.out.println("=== ANTES DO AUMENTO ===");
        System.out.println(func);
        System.out.println(ger);

        double salarioFuncAntes = func.getSalario();
        double salarioGerAntes = ger.getSalario();

        func.aumentarSalario(percentual);
        ger.aumentarSalario(percentual);

        System.out.println("\n=== DEPOIS DO AUMENTO (" + percentual + "%) ===");
        System.out.println(func);
        System.out.println(ger);

        System.out.println("\n=== COMPARAÇÃO ===");
        System.out.printf("%s: R$ %.2f -> R$ %.2f (diferença: R$ %.2f)%n",
                func.getNome(), salarioFuncAntes, func.getSalario(),
                func.getSalario() - salarioFuncAntes);
        System.out.printf("%s: R$ %.2f -> R$ %.2f (diferença: R$ %.2f) | %d anos de serviço = %.0f%% no total%n",
                ger.getNome(), salarioGerAntes, ger.getSalario(),
                ger.getSalario() - salarioGerAntes,
                ger.anosDeServico(), percentual + ger.anosDeServico());

        // 3. BÔNUS: mensagem polimórfica
        // A mesma chamada aumentarSalario() se comporta diferente conforme o objeto real.
        System.out.println("\n=== POLIMORFISMO ===");
        Funcionario[] equipe = {
                new Funcionario("Ana Lima", LocalDate.of(2022, 1, 15), 2500.00),
                new Gerente("Pedro Alves", LocalDate.of(2010, 9, 20), 9000.00),
                new Gerente("Julia Costa", LocalDate.of(2023, 2, 1), 7000.00)
        };

        for (Funcionario f : equipe) {
            double antes = f.getSalario();
            f.aumentarSalario(5); // mesma mensagem para todos
            System.out.printf("%-12s (%s): R$ %.2f -> R$ %.2f%n",
                    f.getNome(), f.getClass().getSimpleName(), antes, f.getSalario());
        }
    }
}
