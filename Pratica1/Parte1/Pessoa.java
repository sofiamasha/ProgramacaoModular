public class Pessoa {
    // Atributos privados (encapsulamento)
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    // Construtor
    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.imc = 0.0;
    }

    // Método para calcular o IMC
    public double calculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
        return this.imc;
    }

    // Método para classificar a faixa corporal baseada no IMC
    public String informaObesidade() {
        if (this.imc < 18.5) {
            return "Abaixo do peso";
        } else if (this.imc <= 24.9) {
            return "Peso normal";
        } else if (this.imc <= 29.9) {
            return "Sobrepeso";
        } else if (this.imc <= 34.9) {
            return "Obesidade grau 1";
        } else if (this.imc <= 39.9) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}