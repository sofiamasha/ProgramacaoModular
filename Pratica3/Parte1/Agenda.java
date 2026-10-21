import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contato> contatos;
    private int tamanho;

    public Agenda() {
        contatos = new ArrayList<>();
        tamanho  = 0;
    }

    public int getTamanho() { return tamanho; }

    // Adicionar
    public void adicionarContato(Contato c) {
        contatos.add(c);
        tamanho++;
        System.out.println("Contato adicionado com sucesso!");
    }

    // Remover
    public void removerContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(c);
                tamanho--;
                System.out.println("Contato removido com sucesso!");
                return;
            }
        }
        System.out.println("Contato não encontrado.");
    }

    // Buscar por nome
    public Contato buscarPorNome(String nome) {
        for (Contato c : contatos)
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        return null;
    }

    // Buscar por email
    public Contato buscarPorEmail(String email) {
        for (Contato c : contatos)
            if (c.getEmail().equalsIgnoreCase(email)) return c;
        return null;
    }

    // Buscar por telefone
    public Contato buscarPorTelefone(String telefone) {
        for (Contato c : contatos)
            if (c.getTelefone().equals(telefone)) return c;
        return null;
    }
}