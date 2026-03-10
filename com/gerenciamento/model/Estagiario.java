package com.gerenciamento.model;
import com.gerenciamento.exceptions.DadosInvalidosException;

public class Estagiario extends Funcionario {
    private double bolsaAuxilio;

    public Estagiario(String nome, String cpf, double salarioBase, double bolsaAuxilio) {
        super(nome, cpf, salarioBase);
        if(salarioBase < 0 ) {
            throw new DadosInvalidosException("Erro! Salário base não pode ser negativo!");
        }
        this.bolsaAuxilio = bolsaAuxilio;
    }

    @Override
    public double calcularSalario() {
        double salario = getSalarioBase() + bolsaAuxilio;
        if(salario > 2000) {
            throw new DadosInvalidosException("Salário do estagiário não pode ultrapassar R$ 2.000!");
        }
        return salario;
        
    }

}
