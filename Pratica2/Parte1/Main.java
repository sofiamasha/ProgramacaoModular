package Pratica2.Parte1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produto produto1 = new Produto("Mouse", 1, 50.00);
        Produto produto2 = new Produto("Teclado", 2, 100.00);
        Produto produto3 = new Produto("Headset", 3, 150.00);

        Fatura fatura = new Fatura();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println();
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Excluir item");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Finalizar");
            System.out.print("Opcao: ");

            opcao = scanner.nextInt();

            if (opcao == 1) {
                comprar(scanner, fatura, produto1, produto2, produto3);
            }

            if (opcao == 2) {
                verFatura(scanner, fatura);
            }

            if (opcao == 3) {
                excluirItem(scanner, fatura);
            }

            if (opcao == 4) {
                alterarItem(scanner, fatura);
            }
        }

        System.out.println();
        System.out.println("Compra finalizada.");
        System.out.printf("Valor final: R$ %.2f%n", fatura.getValorTotal());

        scanner.close();
    }

    public static void comprar(Scanner scanner, Fatura fatura,
                               Produto produto1, Produto produto2, Produto produto3) {

        System.out.println();
        System.out.println("Produtos:");
        System.out.println("1 - " + produto1.getNome() + " - R$ " + produto1.getPreco());
        System.out.println("2 - " + produto2.getNome() + " - R$ " + produto2.getPreco());
        System.out.println("3 - " + produto3.getNome() + " - R$ " + produto3.getPreco());
        System.out.println("0 - Voltar");

        System.out.print("Codigo do produto: ");
        int codigo = scanner.nextInt();

        if (codigo == 0) {
            System.out.println("Voltando...");
        }

        if (codigo != 0) {

            Produto produto = buscarProduto(codigo, produto1, produto2, produto3);

            if (produto == null) {
                System.out.println("Produto nao encontrado.");
            }

            if (produto != null) {

                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();

                if (quantidade <= 0) {
                    System.out.println("Quantidade invalida.");
                }

                if (quantidade > 0) {

                    Item item = buscarItem(fatura, codigo);

                    if (item == null) {
                        Item novoItem = new Item(produto, quantidade);
                        fatura.incluirItem(novoItem);
                        System.out.println("Produto adicionado.");
                    }

                    if (item != null) {
                        int novaQuantidade = item.getQuantidade() + quantidade;
                        item.realizarCompra(novaQuantidade);
                        fatura.calcularValorTotal();
                        System.out.println("Quantidade atualizada.");
                    }
                }
            }
        }
    }

    public static Produto buscarProduto(int codigo,
                                        Produto produto1,
                                        Produto produto2,
                                        Produto produto3) {

        Produto produto = null;

        if (codigo == produto1.getCodigo()) {
            produto = produto1;
        }

        if (codigo == produto2.getCodigo()) {
            produto = produto2;
        }

        if (codigo == produto3.getCodigo()) {
            produto = produto3;
        }

        return produto;
    }

    public static Item buscarItem(Fatura fatura, int codigo) {

        Item itemEncontrado = null;

        for (int i = 0; i < fatura.getItens().size(); i++) {

            Item item = fatura.getItens().get(i);

            if (item.getProduto().getCodigo() == codigo) {
                itemEncontrado = item;
            }
        }

        return itemEncontrado;
    }

    public static void verFatura(Scanner scanner, Fatura fatura) {

        System.out.println();

        if (fatura.getItens().size() == 0) {
            System.out.println("A fatura esta vazia.");
        }

        if (fatura.getItens().size() > 0) {

            for (int i = 0; i < fatura.getItens().size(); i++) {

                Item item = fatura.getItens().get(i);

                System.out.println();
                System.out.println("Item " + (i + 1));
                System.out.println("Produto: " + item.getProduto().getNome());
                System.out.println("Codigo: " + item.getProduto().getCodigo());
                System.out.println("Quantidade: " + item.getQuantidade());
                System.out.printf("Preco: R$ %.2f%n", item.getProduto().getPreco());
                System.out.printf("Total: R$ %.2f%n", item.getValorTotal());
            }

            System.out.printf("%nValor total: R$ %.2f%n", fatura.getValorTotal());
        }

        System.out.println();
        System.out.println("0 - Voltar");
        System.out.print("Opcao: ");
        scanner.nextInt();
    }

    public static void excluirItem(Scanner scanner, Fatura fatura) {

        System.out.println();

        if (fatura.getItens().size() == 0) {
            System.out.println("A fatura esta vazia.");
        }

        if (fatura.getItens().size() > 0) {

            for (int i = 0; i < fatura.getItens().size(); i++) {

                Item item = fatura.getItens().get(i);

                System.out.println(
                    (i + 1) + " - " +
                    item.getProduto().getNome() +
                    " - Quantidade: " +
                    item.getQuantidade()
                );
            }

            System.out.println("0 - Voltar");
            System.out.print("Escolha o item: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Voltando...");
            }

            if (opcao > 0 && opcao <= fatura.getItens().size()) {
                fatura.excluirItem(opcao - 1);
                System.out.println("Item excluido.");
            }

            if (opcao < 0 || opcao > fatura.getItens().size()) {
                System.out.println("Opcao invalida.");
            }
        }
    }

    public static void alterarItem(Scanner scanner, Fatura fatura) {

        System.out.println();

        if (fatura.getItens().size() == 0) {
            System.out.println("A fatura esta vazia.");
        }

        if (fatura.getItens().size() > 0) {

            for (int i = 0; i < fatura.getItens().size(); i++) {

                Item item = fatura.getItens().get(i);

                System.out.println(
                    (i + 1) + " - " +
                    item.getProduto().getNome() +
                    " - Quantidade: " +
                    item.getQuantidade()
                );
            }

            System.out.println("0 - Voltar");
            System.out.print("Escolha o item: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Voltando...");
            }

            if (opcao > 0 && opcao <= fatura.getItens().size()) {

                System.out.print("Nova quantidade: ");
                int quantidade = scanner.nextInt();

                if (quantidade > 0) {
                    fatura.alterarItem(opcao - 1, quantidade);
                    System.out.println("Item alterado.");
                }

                if (quantidade <= 0) {
                    System.out.println("Quantidade invalida.");
                }
            }

            if (opcao < 0 || opcao > fatura.getItens().size()) {
                System.out.println("Opcao invalida.");
            }
        }
    }
}