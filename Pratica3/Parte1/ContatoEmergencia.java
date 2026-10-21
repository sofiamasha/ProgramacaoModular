public class ContatoEmergencia extends Contato {

    private int grauPrioridade; // 1 a 5
    private String observacao;

    public ContatoEmergencia(String nome, String email, String telefone,
                             int grauPrioridade, String observacao) {
        super(nome, email, telefone);
        this.grauPrioridade = grauPrioridade;
        this.observacao     = observacao;
    }

    public int    getGrauPrioridade()          { return grauPrioridade; }
    public String getObservacao()              { return observacao; }
    public void   setGrauPrioridade(int g)     { this.grauPrioridade = g; }
    public void   setObservacao(String o)      { this.observacao = o; }

    public void exibir() {
        super.exibir();
        System.out.println("Prioridade: " + grauPrioridade);
        System.out.println("Observação: " + observacao);
    }
}