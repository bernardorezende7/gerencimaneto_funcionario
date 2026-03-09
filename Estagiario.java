

public class Estagiario extends Funcionario {
    private double bolsaAuxilio;

    public Estagiario(String nome, String cpf, double salarioBase, double bolsaAuxilio) {
        super(nome, cpf, salarioBase);
        this.bolsaAuxilio = bolsaAuxilio;
    }

    @Override
    double calcularSalario() {
        double salario = getSalarioBase() + bolsaAuxilio;
        if(salario > 2000) {
            System.out.print("SALÁRIO INVÁLIDO");
        }
        return salario;
        
    }

}
