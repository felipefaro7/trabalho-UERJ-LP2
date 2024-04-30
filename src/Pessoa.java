import java.time.LocalDate;
import java.time.Period;


public class Pessoa {
    private String nome;
    private String sobrenome;
    private int diaNascimento;
    private int mesNascimento;
    private int anoNascimento;
    private long numCPF;
    private float peso;
    private float altura;
    public Pessoa(String nome, String sobrenome, int diaNascimento, int mesNascimento, int anoNascimento) {

    this.nome = nome;
    this.sobrenome = sobrenome;
    this.diaNascimento = diaNascimento;
    this.mesNascimento = mesNascimento;
    this.anoNascimento = anoNascimento;
    contadorPessoas++;
}
    public Pessoa(String nome, String sobrenome, int diaNascimento, int mesNascimento, int anoNascimento, long numCPF, float peso, float altura) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
        this.numCPF = numCPF;
        this.peso = peso;
        this.altura = altura;
        contadorPessoas++;
}
    public int calcularIdade() {
        LocalDate dataNascimento = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }
    
        //Getters
    public String getNome (){
        return nome;
    }
    public String getSobrenome (){
        return sobrenome;
    }
    public int getDiaNascimento (){
        return diaNascimento;
    }
    public int getMesNascimento(){
        return mesNascimento;
    }
    public int getAnoNascimento (){
        return anoNascimento;
    }
    public long getNumCPF (){
        return numCPF;
    }
    public float getPeso (){
        return peso;
    }
    public float getAltura (){
        return altura;
    }
        //Setters
        public void setNome (String nome){
            this.nome = nome;
        }
        public void setSobrenome (String sobrenome){
            this.sobrenome = sobrenome;
        }
        public void setDiaNascimento (int diaNascimento){
            this.diaNascimento = diaNascimento;
        }
        public void setMesNascimento (int mesNascimento){
            this.mesNascimento = mesNascimento;
        }
        public void setAnoNascimento(int anoNascimento){
            this.anoNascimento = anoNascimento;
        }
        public void setNumCPF (long numCPF){
            this.numCPF = numCPF;
        }
        public void setPeso (float peso){
            this.peso = peso;
        }
        public String toString() {
            return "Nome: " + nome + " " + sobrenome +
                   "\nData de Nascimento: " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento +
                   "\nCPF: " + numCPF +
                   "\nPeso: " + peso + " kg" +
                   "\nAltura: " + altura + " m";
        }
        
        private static int contadorPessoas = 0;
        public static int numPessoas (){
            return contadorPessoas;
        }


}