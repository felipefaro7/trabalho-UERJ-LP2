public class Homem extends Pessoa {
    public Homem(String nome, String sobrenome, int diaNascimento, int mesNascimento, int anoNascimento) {
        super(nome, sobrenome, diaNascimento, mesNascimento, anoNascimento);
    }

    public Homem(String nome, String sobrenome, int diaNascimento, int mesNascimento, int anoNascimento, long numCPF, float peso, float altura) {
        super(nome, sobrenome, diaNascimento, mesNascimento, anoNascimento, numCPF, peso, altura);
    }

    @Override
    public String toString() {
        String genero = "Homem";
        int idade = calcularIdade();
        return super.toString() + "\nGênero: " + genero + "\nIdade: " + idade + " anos";
    }
}