import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        FuncionarioCLT clt1 = new FuncionarioCLT("Andre", "15298574812", 5000, 15);
        FuncionarioPJ pj1 = new FuncionarioPJ("Carlos", "28392837218", 36, 20);
        Estagiario estg1 = new Estagiario("Fernanda", "94826378932", 1000, 900);
        FuncionarioCLT clt2 = new FuncionarioCLT("Julio Cesar", "89273647182", 9000, 10);
        FuncionarioPJ pj2 = new FuncionarioPJ("Antonio", "72836475621", 60, 30);
        
        funcionarios.add(clt1);
        funcionarios.add(pj1);
        funcionarios.add(estg1);
        funcionarios.add(clt2);
        funcionarios.add(pj2);

        while (true) {
        System.out.println("\n=== SISTEMA DE FUNCIONÁRIOS ===\n");
        System.out.println("1 - Listar todos os funcionários\n" + //
                            "2 - Adicionar funcionário\n" + //
                            "3 - Calcular folha de pagamento total\n" + //
                            "4 - Listar apenas tributáveis (com imposto)\n" + //
                            "5 - Buscar funcionário por CPF\n" + //
                            "0 - Sair");
        int escolharMenu = sc.nextInt();
        
        switch (escolharMenu) {
            // Listar funcionários: 
            case 1:
                System.out.println("FUNCIONÁRIOS:\n");
                System.out.println("========================");
                for(Funcionario funcionario : funcionarios) {
                    System.out.println("Nome: " + funcionario.getNome());
                    System.out.println("Cpf: " + funcionario.getCpf());
                    System.out.println("========================");
                }
                break;

            // Adicionar funcionário: 
            case 2:
                System.out.println("\n=== ADICIONAR FUNCIONÁRIO ===\n");
                System.out.println("1. CLT\n" + 
                                    "2. PJ\n" + 
                                    "3. Estagiario");

                int escolhaTipoFuncionario = sc.nextInt();
                sc.nextLine();

                switch (escolhaTipoFuncionario) {
                    case 1:
                        System.out.println("Nome: ");
                        String nomeCLT = sc.nextLine();

                        System.out.println("Cpf: ");
                        String cpfCLT = sc.nextLine();

                        System.out.println("Salário base: ");
                        double salarioCLT = sc.nextDouble();

                        System.out.println("Percentual de bônus: ");
                        double percentualCLT = sc.nextDouble();

                        FuncionarioCLT escolhaCLT = new FuncionarioCLT(nomeCLT, cpfCLT, salarioCLT, percentualCLT);
                        funcionarios.add(escolhaCLT);
                        break;

                    case 2:
                        
                        System.out.println("Nome: ");
                        String nomePJ = sc.nextLine();

                        System.out.println("Cpf: ");
                        String cpfPJ = sc.nextLine();

                        System.out.println("Horas trabalhadas: ");
                        int horasTrabalhadasPJ = sc.nextInt();

                        System.out.println("Valor por hora: ");
                        double valorPorHoraPJ = sc.nextDouble();

                        FuncionarioPJ escolhaPJ = new FuncionarioPJ(nomePJ, cpfPJ, horasTrabalhadasPJ, valorPorHoraPJ);
                        funcionarios.add(escolhaPJ);

                        break;

                    case 3:
                        System.out.println("Nome: ");
                        String nomeESTG = sc.nextLine();

                        System.out.println("Cpf: ");
                        String cpfESTG = sc.nextLine();

                        System.out.println("Salário base: ");
                        double salarioESTG = sc.nextDouble();

                        System.out.println("Bolsa auxílio: ");
                        double bolsaAuxilioESTG = sc.nextDouble();

                        Estagiario escolhaESTG = new Estagiario(nomeESTG, cpfESTG, salarioESTG, bolsaAuxilioESTG);
                        funcionarios.add(escolhaESTG);

                        break;
                }

                break;

            case 3:
                System.out.println("\n=== FOLHA PAGAMENTO TOTAL ===\n");
                double folhaPagamentoTotal = 0;
                for(Funcionario f : funcionarios) {
                    folhaPagamentoTotal = folhaPagamentoTotal + f.calcularSalario();
                }
                System.out.println("Folha Pagamento Total: " + folhaPagamentoTotal);
                break;

            case 4:
                System.out.println("\n=== LISTA TRIBUTÁVEIS ===\n");
                for(Funcionario f : funcionarios) {
                    if(f instanceof Tributavel t) {
                        System.out.println("Nome: " + f.getNome());
                        System.out.println("Salário: " + f.calcularSalario());
                        System.out.println("Imposto: " + t.calcularImposto() + "(" + t.descricaoImposto() + ")");
                    }
                }
                break;

            case 5:
                sc.nextLine();
                String cpf;

                System.out.println("\n=== BUSCA FUNCIONÁRIO CPF ===\n");

                System.out.println("Digite o CPF: ");
                cpf = sc.nextLine();

                if(cpf != null) {

                    cpf = cpf.replace(".", "").replace("-", "");
                    
                    if(cpf.length() == 11 && cpf.matches("\\d{11}")) {

                        for(Funcionario f : funcionarios) {

                            if(f.getCpf().equals(cpf)) {
                                System.out.println("Nome: " + f.getNome());
                                System.out.println("Cpf: " + f.getCpf());
                            }
                        }
                    }
                    else {
                        System.out.println("CPF INVÁLIDO");
                    }
                }
                else {
                    System.out.println("CPF INVÁLIDO");
                }
                break;

            case 0:
                System.out.println("Encerrando programa...");
                break;
            
            default:
                System.out.println("Digite algo válido!");
                continue;

            }

            break;

        }
    }
}
