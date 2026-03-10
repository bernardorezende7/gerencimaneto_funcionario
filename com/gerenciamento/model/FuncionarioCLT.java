package com.gerenciamento.model;
import com.gerenciamento.interfaces.Tributavel;
import com.gerenciamento.exceptions.DadosInvalidosException;

public class FuncionarioCLT extends Funcionario implements Tributavel {

    private double percentualBonus;

    public FuncionarioCLT(String nome, String cpf, double salarioBase, double percentualBonus) {
        super(nome, cpf, salarioBase);
        if(salarioBase < 0 ) {
            throw new DadosInvalidosException("Erro! Salário base não pode ser negativo!");
        }
        this.percentualBonus = percentualBonus;
    }

    public void setPercentualBonus(double percentualBonus) {
        if(percentualBonus >= 0) {
            this.percentualBonus = percentualBonus;
        }
    }

    @Override
    double calcularSalario() {
        double salario = getSalarioBase() + (getSalarioBase() * percentualBonus / 100);
        return salario;
    }

    @Override
    public double calcularImposto() {
        double salarioComImposto = (calcularSalario() * 15) / 100;
        return salarioComImposto;
    }

    @Override
    public String descricaoImposto() {
        String descricao = "CLT → imposto = 15% do salário calculado";
        return descricao;
    }
}