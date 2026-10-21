public class ContatoProfissional extends Contato {

    private String empresa;
    private String cargo;

    public ContatoProfissional(String nome, String email, String telefone,
                               String empresa, String cargo) {
        super(nome, email, telefone);
        this.empresa = empresa;
        this.cargo   = cargo;
    }

    public String getEmpresa(){
         return empresa; 
     }
    public String getCargo(){ 
        return cargo; 
    }
    public void setEmpresa(String e){ 
        this.empresa = e; 
    }
    public void setCargo(String c){ 
        this.cargo = c; 
    }

    public void exibir() {
        super.exibir();
        System.out.println("Empresa: " + empresa);
        System.out.println("Cargo: "   + cargo);
    }
}