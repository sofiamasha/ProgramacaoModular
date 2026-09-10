import java.time.LocalDate;
import java.time.Period;

public class Aluno {

    // Atributos privados
    private String nome;
    private String sobrenome;
    private double coragem;
    private double inteligencia;
    private double ambicao;
    private double lealdade;
    private double estrategia;
    private double criatividade;
    private String casa;
    private LocalDate dataNascimento;
    private String codigoMatricula;

    // Construtor
    public Aluno(String nome, String sobrenome, LocalDate dataNascimento,
                 double coragem, double inteligencia, double ambicao,
                 double lealdade, double estrategia, double criatividade) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        this.casa = "Não selecionado";
        this.codigoMatricula = "Não gerado";
    }

    // Calcula as pontuações e define a casa
    public void calcularCasa() {

        double pontosGrifinoria = (2 * this.coragem) + this.lealdade;
        double pontosSonserina = (2 * this.ambicao) + this.estrategia;
        double pontosCorvinal = (2 * this.inteligencia) + this.criatividade;
        double pontosLufaLufa = ((2 * this.lealdade) + this.coragem) / 3.0;

        double maiorPontuacao = pontosGrifinoria;
        this.casa = "Grifinória";

        if (pontosSonserina > maiorPontuacao) {
            maiorPontuacao = pontosSonserina;
            this.casa = "Sonserina";
        }

        if (pontosCorvinal > maiorPontuacao) {
            maiorPontuacao = pontosCorvinal;
            this.casa = "Corvinal";
        }

        if (pontosLufaLufa > maiorPontuacao) {
            maiorPontuacao = pontosLufaLufa;
            this.casa = "Lufa-Lufa";
        }
    }

    // 1. Calcular idade
    public int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    // 2. Verificar maioridade mágica
    public boolean verificarMaioridadeMagica() {
        return calcularIdade() >= 17;
    }

    // 3. Formatar casa
    public String formatarCasa() {
        return casa.toUpperCase();
    }

    // 4. Gerar nome de usuário
    public String gerarNomeUsuario() {
        String primeiraLetra = nome.substring(0, 1).toLowerCase();

        return primeiraLetra + sobrenome.toLowerCase();
    }

    // 5. Gerar código de matrícula
    public String gerarCodigoMatricula(int posicao) {

        String iniciais = nome.substring(0, 1).toUpperCase()
                + sobrenome.substring(0, 1).toUpperCase();

        int ano = LocalDate.now().getYear();

        String numero = String.format("%02d", posicao + 1);

        codigoMatricula = iniciais + "-" + ano + "-" + numero;

        return codigoMatricula;
    }

    // 6. Verificar casa
    public boolean verificarCasa(String casaInformada) {
        return casa.equalsIgnoreCase(casaInformada);
    }

    // 7. Verificar presença de palavra
    public boolean verificarPalavra(String palavra) {
        return sobrenome.toLowerCase().contains(palavra.toLowerCase());
    }

    // Exibir informações
    public void exibirInformacoes() {

        System.out.println("\n--- INFORMAÇÕES DO ALUNO ---");
        System.out.println("Nome: " + nome + " " + sobrenome);
        System.out.println("Idade: " + calcularIdade() + " anos");
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Casa: " + formatarCasa());
        System.out.println("Nome de usuário: " + gerarNomeUsuario());
        System.out.println("Código de matrícula: " + codigoMatricula);
        System.out.println("----------------------------");
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public double getCoragem() {
        return coragem;
    }

    public void setCoragem(double coragem) {
        this.coragem = coragem;
    }

    public double getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(double inteligencia) {
        this.inteligencia = inteligencia;
    }

    public double getAmbicao() {
        return ambicao;
    }

    public void setAmbicao(double ambicao) {
        this.ambicao = ambicao;
    }

    public double getLealdade() {
        return lealdade;
    }

    public void setLealdade(double lealdade) {
        this.lealdade = lealdade;
    }

    public double getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(double estrategia) {
        this.estrategia = estrategia;
    }

    public double getCriatividade() {
        return criatividade;
    }

    public void setCriatividade(double criatividade) {
        this.criatividade = criatividade;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }
}