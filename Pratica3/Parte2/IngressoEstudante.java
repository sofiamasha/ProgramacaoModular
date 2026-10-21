public class IngressoEstudante extends Ingresso {

    private String instituicaoEnsino;

    public IngressoEstudante(int codigo, String nomeEvento, String setor,
                             double valorBase, String instituicaoEnsino)
    {
        super(codigo, nomeEvento, setor, valorBase);
        this.instituicaoEnsino=instituicaoEnsino;
    }

    public String getInstituicaoEnsino()
    {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String inst)
    {
        this.instituicaoEnsino=inst;
    }

    public double calcularValorFinal()
    {
        return getValorBase() * 0.5;
    }

    public String obterBeneficios()
    {
        return "Meia-entrada para estudantes.";
    }

    public void exibir()
    {
        super.exibir();
        System.out.println("Tipo: Estudante");
        System.out.println("Instituicao: " + instituicaoEnsino);
        System.out.println("Valor final: " + calcularValorFinal());
    }
}