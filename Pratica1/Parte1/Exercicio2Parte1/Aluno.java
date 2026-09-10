public class Aluno {
    // Atributos privados (encapsulamento)
    private String nome;
    private int idade;
    private double coragem;
    private double inteligencia;
    private double ambicao;
    private double lealdade;
    private double estrategia;
    private double criatividade;
    private String casa;

    // Construtor
    public Aluno(String nome, int idade, double coragem, double inteligencia, double ambicao, double lealdade, double estrategia, double criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        this.casa = "Não selecionado";
    }

    // Método para calcular as pontuações e definir a casa com a MAIOR pontuação
    public void calcularCasa() {
        double pontosGrifinoria = (2 * this.coragem) + this.lealdade;
        double pontosSonserina = (2 * this.ambicao) + this.estrategia;
        double pontosCorvinal = (2 * this.inteligencia) + this.criatividade;
        double pontosLufaLufa = ((2 * this.lealdade) + this.coragem) / 3.0;

        // Compara qual pontuação foi a maior
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

    // Método para exibir as informações do aluno
    public void exibirInformacoes() {
        System.out.println("\n--- INFORMAÇÕES DO ALUNO ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade + " anos");
        System.out.println("Casa selecionada: " + this.casa);
        System.out.println("----------------------------\n");
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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