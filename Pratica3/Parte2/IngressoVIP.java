public class IngressoVIP extends Ingresso {

    private boolean acessoBackstage;
    private int numeroLounge;

    public IngressoVIP(int codigo, String nomeEvento, String setor,
                       double valorBase, boolean acessoBackstage, int numeroLounge) {
        super(codigo, nomeEvento, setor, valorBase);
        this.acessoBackstage=acessoBackstage;
        this.numeroLounge=numeroLounge;
    }

    public boolean getAcessoBackstage()
    {
        return acessoBackstage;
    }

    public int getNumeroLounge()
    {
        return numeroLounge;
    }

    public void setAcessoBackstage(boolean acesso)
    {
        this.acessoBackstage=acesso;
    }

    public void setNumeroLounge(int lounge)
    {
        this.numeroLounge=lounge;
    }

    public double calcularValorFinal()
    {
        return getValorBase() * 1.8;
    }

    public String obterBeneficios()
    {
        String beneficios = "Acesso ao lounge " + numeroLounge + ".";
        if (acessoBackstage)
        {
            beneficios += " Acesso ao backstage incluso.";
        }
        return beneficios;
    }

    public void exibir()
    {
        super.exibir();
        System.out.println("Tipo: VIP");
        System.out.println("Lounge: " + numeroLounge);
        System.out.println("Backstage: " + (acessoBackstage ? "Sim" : "Nao"));
        System.out.println("Valor final: " + calcularValorFinal());
    }
}