package com.gerenciamento.model;

import com.gerenciamento.interfaces.Tributavel;
import com.gerenciamento.exceptions.DadosInvalidosException;

public class FuncionarioPJ extends Funcionario implements Tributavel {
    private int horasTrabalhadas;
    private double valorHora;

    public FuncionarioPJ(String nome, String cpf, int horasTrabalhadas, double valorHora) {
        super(nome, cpf, 0);
        if(horasTrabalhadas < 1 || horasTrabalhadas > 220) {
            throw new DadosInvalidosException("Erro! As horas trabalhadas devem está entre 1 e 220!");
        }
        if(valorHora < 0) {
            throw new DadosInvalidosException("Erro! O valor por hora não pode ser negativo!");
        }
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double valorHora() {
        return valorHora;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        if(horasTrabalhadas >= 1 && horasTrabalhadas <= 220) {
            this.horasTrabalhadas = horasTrabalhadas;
        }
        
    }

    public void setValorHora(double valorHora) {
        if(valorHora >= 0) {
            this.valorHora = valorHora;
        }
        
    }

    @Override
    public double calcularSalario() {
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