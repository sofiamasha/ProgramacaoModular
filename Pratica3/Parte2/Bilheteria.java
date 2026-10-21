import java.util.ArrayList;

public class Bilheteria {

    private ArrayList<Ingresso> ingressos;

    public Bilheteria()
    {
        ingressos=new ArrayList<>();
    }

    public void adicionarIngresso(Ingresso i)
    {
        ingressos.add(i);
        System.out.println("Ingresso adicionado com sucesso!");
    }

    public void removerIngresso(int codigo)
    {
        for (Ingresso i : ingressos)
        {
            if (i.getCodigo()==codigo)
            {
                ingressos.remove(i);
                System.out.println("Ingresso removido com sucesso!");
                return;
            }
        }
        System.out.println("Ingresso nao encontrado.");
    }

    public Ingresso buscarIngresso(int codigo)
    {
        for (Ingresso i : ingressos)
        {
            if (i.getCodigo()==codigo)
            {
                return i;
            }
        }
        return null;
    }

    public void listarIngressos()
    {
        if (ingressos.isEmpty())
        {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso i : ingressos)
        {
            System.out.println("-------------------");
            i.exibir();
        }
    }

    public double calcularArrecadacaoTotal()
    {
        double total=0;
        for (Ingresso i : ingressos)
        {
            total+=i.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios()
    {
        if (ingressos.isEmpty())
        {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso i : ingressos)
        {
            System.out.println("Codigo " + i.getCodigo() + ": " + i.obterBeneficios());
        }
    }
}