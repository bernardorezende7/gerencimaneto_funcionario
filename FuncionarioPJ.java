public class FuncionarioPJ extends Funcionario implements Tributavel {
    private int horasTrabalhadas;
    private double valorHora;

    public FuncionarioPJ(String nome, String cpf, int horasTrabalhadas, double valorHora) {
        super(nome, cpf, 0);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    double calcularSalario() {
        double salario = horasTrabalhadas * valorHora;
        return salario;
    }

    @Override
    public double calcularImposto() {
        double salarioComImposto = (calcularSalario() * 20) / 100;
        return salarioComImposto;

    }

    @Override
    public String descricaoImposto() {
        String descricao = "PJ → imposto = 20% do salário calculado";
        return descricao;
    }
}