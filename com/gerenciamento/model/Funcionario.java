package src.com.gerenciamento.model;
public abstract class Funcionario {

    private String nome;
    private String cpf;
    private double salarioBase;

    public Funcionario(String nome, String cpf, double salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
    }

    //Getters:

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    //Setters:

    public void setNome(String novoNome) {
        if(novoNome != null && !novoNome.isEmpty()) {
            this.nome = novoNome;
        }
    }

    public void setCpf(String novoCpf) {
        
        if(novoCpf != null) {
            novoCpf = novoCpf.replace(".", "").replace("-", "");

            if(novoCpf.length() == 11 && novoCpf.matches("\\d{11}")) {
                this.cpf = novoCpf;
            }
            else {
                System.out.print("CPF INVÁLIDO");
            }
            
        }
        else {
            System.out.print("CPF INVÁLIDO");
        }
    } 

    public void setSalarioBase(double novoSalarioBase) {
        if(novoSalarioBase > 0) {
            this.salarioBase = novoSalarioBase;
        }
    }

    //Métodos:

    public abstract double calcularSalario();

    public String exibirResumo() {
        return "Nome: " + getNome() + "\nCpf: " + getCpf() + "\nSalario: " + calcularSalario() + "\n";
    }

}