public class IngressoComum extends Ingresso {

    public IngressoComum(int codigo, String nomeEvento, String setor, double valorBase)
    {
        super(codigo, nomeEvento, setor, valorBase);
    }

    public double calcularValorFinal()
    {
        return getValorBase();
    }

    public String obterBeneficios()
    {
        return "Sem beneficios adicionais.";
    }

    public void exibir()
    {
        super.exibir();
        System.out.println("Tipo: Comum");
        System.out.println("Valor final: " + calcularValorFinal());
    }
}