import java.util.Locale;
import java.util.Scanner;

public class P1nX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Define o local para aceitar ponto como separador decimal
        
        // Verifica se há parâmetros suficientes
        if (args.length < 9) {
            System.out.println("Erro: Parâmetros insuficientes. Use a seguinte sintaxe:");
            System.out.println("java P1nX <genero> <nome> <sobre> <dia> <mes> <ano> <CPF> <peso> <altura>");
            // Permite ao usuário inserir os parâmetros manualmente
            System.out.println("Por favor, insira os parâmetros manualmente:");

            try {
                System.out.print("Gênero (mulher ou homem): ");
                String genero = scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Sobrenome: ");
                String sobrenome = scanner.nextLine();
                System.out.print("Dia de nascimento: ");
                int diaNascimento = scanner.nextInt();
                System.out.print("Mês de nascimento: ");
                int mesNascimento = scanner.nextInt();
                System.out.print("Ano de nascimento: ");
                int anoNascimento = scanner.nextInt();
                System.out.print("CPF: ");
                long numCPF = scanner.nextLong();
                System.out.print("Peso: ");
                float peso = scanner.nextFloat();
                System.out.print("Altura: ");
                float altura = scanner.nextFloat();
                
                // Cria o objeto com os parâmetros fornecidos
                Pessoa pessoa;
                if (genero.equalsIgnoreCase("mulher")) {
                    pessoa = new Mulher(nome, sobrenome, diaNascimento, mesNascimento, anoNascimento, numCPF, peso, altura);
                } else if (genero.equalsIgnoreCase("homem")) {
                    pessoa = new Homem(nome, sobrenome, diaNascimento, mesNascimento, anoNascimento, numCPF, peso, altura);
                } else {
                    System.out.println("Gênero inválido. Use 'mulher' ou 'homem'.");
                    return;
                }

                // Exibe as informações do objeto criado
                System.out.println("Informações do objeto criado:");
                System.out.println(pessoa);

                // Pergunta ao usuário quantos elementos adicionais deseja criar
                System.out.print("Quantos elementos adicionais você deseja criar? ");
                int numElementos = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                // Cria o array de tamanho especificado pelo usuário
                Pessoa[] pessoas = new Pessoa[numElementos + 1];
                pessoas[0] = pessoa; // Adiciona o primeiro objeto criado

                // Loop para criar objetos adicionais
                for (int i = 1; i <= numElementos; i++) {
                    boolean dadosValidos = false;
                    while (!dadosValidos) {
                        System.out.print("Digite o gênero (mulher ou homem) do próximo elemento: ");
                        String novoGenero = scanner.nextLine();

                        // Variáveis para armazenar os dados do novo objeto
                        String novoNome, novoSobrenome;
                        int novoDiaNascimento, novoMesNascimento, novoAnoNascimento;
                        long novoNumCPF;
                        float novoPeso, novaAltura;

                        // Leitura dos dados do novo objeto
                        System.out.print("Digite o nome: ");
                        novoNome = scanner.nextLine();
                        System.out.print("Digite o sobrenome: ");
                        novoSobrenome = scanner.nextLine();
                        System.out.print("Digite o dia de nascimento: ");
                        novoDiaNascimento = scanner.nextInt();
                        System.out.print("Digite o mês de nascimento: ");
                        novoMesNascimento = scanner.nextInt();
                        System.out.print("Digite o ano de nascimento: ");
                        novoAnoNascimento = scanner.nextInt();
                        System.out.print("Digite o CPF: ");
                        novoNumCPF = scanner.nextLong();
                        System.out.print("Digite o peso: ");
                        novoPeso = scanner.nextFloat();
                        System.out.print("Digite a altura: ");
                        novaAltura = scanner.nextFloat();
                        scanner.nextLine(); // Limpa o buffer do scanner

                        // Criação do novo objeto com os dados fornecidos
                        try {
                            if (novoGenero.equalsIgnoreCase("mulher")) {
                                pessoas[i] = new Mulher(novoNome, novoSobrenome, novoDiaNascimento, novoMesNascimento, novoAnoNascimento, novoNumCPF, novoPeso, novaAltura);
                                dadosValidos = true; // Se chegou até aqui, os dados são válidos
                            } else if (novoGenero.equalsIgnoreCase("homem")) {
                                pessoas[i] = new Homem(novoNome, novoSobrenome, novoDiaNascimento, novoMesNascimento, novoAnoNascimento, novoNumCPF, novoPeso, novaAltura);
                                dadosValidos = true; // Se chegou até aqui, os dados são válidos
                            } else {
                                System.out.println("Gênero inválido. Use 'mulher' ou 'homem'.");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro ao criar objeto: " + e.getMessage());
                            scanner.nextLine(); // Limpa o buffer do scanner em caso de erro
                        }
                    }
                }

                // Exibe todos os elementos do array
                System.out.println("Elementos do array:");
                for (Pessoa p : pessoas) {
                    if (p != null) {
                        System.out.println(p);
                    }
                }

                // Exibe o número de objetos de cada gênero
                int numMulheres = 0;
                int numHomens = 0;
                for (Pessoa p : pessoas) {
                    if (p instanceof Mulher) {
                        numMulheres++;
                    } else if (p instanceof Homem) {
                        numHomens++;
                    }
                }
                System.out.println("Número de mulheres: " + numMulheres);
                System.out.println("Número de homens: " + numHomens);
            } catch (Exception e) {
                System.out.println("Erro ao processar entrada: " + e.getMessage());
            }
        }
    }
}
