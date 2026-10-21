public class Contato {

    private String nome;
    private String email;
    private String telefone;

    public Contato(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Gets e Sets
    public String getNome()
    { 
        return nome; 
    }
    public String getEmail()
    { 
        return email; 
    }
    public String getTelefone(){ 
        return telefone;
 }

    public void setNome(String nome){ 
        this.nome = nome; 
        
    }
    public void setEmail(String email){ 
        this.email = email; 
    }
    public void setTelefone(String telefone) { 
        this.telefone = telefone; 
    }

    public void exibir() {
        System.out.println("Nome: "     + nome);
        System.out.println("Email: "    + email);
        System.out.println("Telefone: " + telefone);
    }
}