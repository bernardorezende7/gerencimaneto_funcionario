abstract class Funcionario {

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
                System.out.print("CPF INVÁLDIO");
            }
            
        }
        else {
            System.out.print("CPF INVÁLDIO");
        }
    } 

    public void setSalarioBase(double novoSalarioBase) {
        if(novoSalarioBase > 0) {
            this.salarioBase = novoSalarioBase;
        }
    }

    //Métodos:

    abstract double calcularSalario();

    public void exibirResumo() {
        System.out.print("Nome: " + getNome());
        System.out.print("\nCPF: " + getCpf());
        System.out.print("\nSalario: " + calcularSalario());
    }

}