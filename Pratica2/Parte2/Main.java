package Pratica2.Parte2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produto produto1 = new Produto("Mouse", 1, 50.00);
        Produto produto2 = new Produto("Teclado", 2, 100.00);
        Produto produto3 = new Produto("Headset", 3, 150.00);

        produto1.adicionarEstoque(10);
        produto2.adicionarEstoque(8);
        produto3.adicionarEstoque(4);

        Estoque estoque = new Estoque();

        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        estoque.adicionarProduto(produto3);

        Fatura fatura = new Fatura();

        int opcao = 0;

        while (opcao != 10) {

            System.out.println();
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Excluir item");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Consultar Produto");
            System.out.println("6 - Adicionar Produto ao Estoque");
            System.out.println("7 - Remover Produto");
            System.out.println("8 - Repor Estoque");
            System.out.println("9 - Produtos com Estoque Baixo");
            System.out.println("10 - Finalizar");
            System.out.print("Opcao: ");

            opcao = scanner.nextInt();

            if (opcao == 1) {
                comprar(scanner, fatura, estoque);
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

            if (opcao == 5) {
                consultarProduto(scanner, estoque);
            }

            if (opcao == 6) {
                adicionarProduto(scanner, estoque);
            }

            if (opcao == 7) {
                removerProduto(scanner, estoque);
            }

            if (opcao == 8) {
                reporEstoque(scanner, estoque);
            }

            if (opcao == 9) {
                estoqueBaixo(scanner, estoque);
            }
        }

        System.out.println();
        System.out.println("Compra finalizada.");
        System.out.printf("Valor final: R$ %.2f%n", fatura.getValorTotal());

        scanner.close();
    }

    public static void comprar(Scanner scanner, Fatura fatura,
                               Estoque estoque) {

        System.out.println();
        System.out.println("Produtos:");

        estoque.listarProdutos();

        System.out.println("0 - Voltar");
        System.out.print("Codigo do produto: ");

        int codigo = scanner.nextInt();

        if (codigo == 0) {
            System.out.println("Voltando...");
        }

        if (codigo != 0) {

            Produto produto = estoque.buscarProduto(codigo);

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

                    if (quantidade <= produto.getQuantidadeEstoque()) {

                        Item item = buscarItem(fatura, codigo);

                        if (item == null) {

                            Item novoItem = new Item(produto, quantidade);

                            fatura.incluirItem(novoItem);
                            produto.retirarEstoque(quantidade);

                            System.out.println("Compra realizada.");
                        }

                        if (item != null) {

                            int novaQuantidade =
                                    item.getQuantidade() + quantidade;

                            item.realizarCompra(novaQuantidade);
                            produto.retirarEstoque(quantidade);
                            fatura.calcularValorTotal();

                            System.out.println("Compra realizada.");
                        }
                    }

                    if (quantidade > produto.getQuantidadeEstoque()) {
                        System.out.println("Quantidade indisponivel no estoque.");
                    }
                }
            }
        }
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
                System.out.println("Produto: "
                        + item.getProduto().getNome());
                System.out.println("Codigo: "
                        + item.getProduto().getCodigo());
                System.out.println("Quantidade: "
                        + item.getQuantidade());

                System.out.printf("Preco: R$ %.2f%n",
                        item.getProduto().getPreco());

                System.out.printf("Total: R$ %.2f%n",
                        item.getValorTotal());
            }

            System.out.printf("%nValor total: R$ %.2f%n",
                    fatura.getValorTotal());
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
                        (i + 1) + " - "
                        + item.getProduto().getNome()
                        + " - Quantidade: "
                        + item.getQuantidade()
                );
            }

            System.out.println("0 - Voltar");
            System.out.print("Escolha o item: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Voltando...");
            }

            if (opcao > 0 && opcao <= fatura.getItens().size()) {

                Item item = fatura.getItens().get(opcao - 1);

                item.getProduto().adicionarEstoque(
                        item.getQuantidade()
                );

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
                        (i + 1) + " - "
                        + item.getProduto().getNome()
                        + " - Quantidade: "
                        + item.getQuantidade()
                );
            }

            System.out.println("0 - Voltar");
            System.out.print("Escolha o item: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Voltando...");
            }

            if (opcao > 0 && opcao <= fatura.getItens().size()) {

                Item item = fatura.getItens().get(opcao - 1);

                System.out.print("Nova quantidade: ");
                int quantidade = scanner.nextInt();

                if (quantidade <= 0) {
                    System.out.println("Quantidade invalida.");
                }

                if (quantidade > 0) {

                    int quantidadeAtual = item.getQuantidade();

                    int diferenca = quantidade - quantidadeAtual;

                    if (diferenca > 0) {

                        if (diferenca <= item.getProduto()
                                .getQuantidadeEstoque()) {

                            item.realizarCompra(quantidade);
                            item.getProduto().retirarEstoque(diferenca);
                            fatura.calcularValorTotal();

                            System.out.println("Item alterado.");
                        }

                        if (diferenca > item.getProduto()
                                .getQuantidadeEstoque()) {

                            System.out.println(
                                    "Nao ha estoque suficiente."
                            );
                        }
                    }

                    if (diferenca < 0) {

                        item.realizarCompra(quantidade);

                        item.getProduto().adicionarEstoque(
                                diferenca * -1
                        );

                        fatura.calcularValorTotal();

                        System.out.println("Item alterado.");
                    }

                    if (diferenca == 0) {
                        System.out.println("A quantidade nao foi alterada.");
                    }
                }
            }

            if (opcao < 0 || opcao > fatura.getItens().size()) {
                System.out.println("Opcao invalida.");
            }
        }
    }

    public static void consultarProduto(Scanner scanner,
                                        Estoque estoque) {

        System.out.println();
        System.out.println("0 - Voltar");
        System.out.print("Codigo do produto: ");

        int codigo = scanner.nextInt();

        if (codigo == 0) {
            System.out.println("Voltando...");
        }

        if (codigo != 0) {

            Produto produto = estoque.buscarProduto(codigo);

            if (produto == null) {
                System.out.println("Produto nao encontrado.");
            }

            if (produto != null) {

                System.out.println("Nome: " + produto.getNome());
                System.out.println("Codigo: " + produto.getCodigo());

                System.out.printf("Preco: R$ %.2f%n",
                        produto.getPreco());

                System.out.println("Quantidade em estoque: "
                        + produto.getQuantidadeEstoque());
            }
        }
    }

    public static void adicionarProduto(Scanner scanner,
                                         Estoque estoque) {

        System.out.println();
        System.out.println("0 - Voltar");

        System.out.print("Nome do produto: ");
        String nome = scanner.next();

        if (nome.equals("0")) {
            System.out.println("Voltando...");
        }

        if (!nome.equals("0")) {

            System.out.print("Codigo: ");
            int codigo = scanner.nextInt();

            if (estoque.verificarExistencia(codigo)) {
                System.out.println("Ja existe um produto com esse codigo.");
            }

            if (!estoque.verificarExistencia(codigo)) {

                System.out.print("Preco: ");
                double preco = scanner.nextDouble();

                System.out.print("Quantidade inicial: ");
                int quantidade = scanner.nextInt();

                if (quantidade < 0) {
                    System.out.println("Quantidade invalida.");
                }

                if (quantidade >= 0) {

                    Produto produto = new Produto(nome, codigo, preco);

                    produto.adicionarEstoque(quantidade);

                    estoque.adicionarProduto(produto);

                    System.out.println("Produto adicionado.");
                }
            }
        }
    }

    public static void removerProduto(Scanner scanner,
                                      Estoque estoque) {

        System.out.println();
        System.out.println("0 - Voltar");
        System.out.print("Codigo do produto: ");

        int codigo = scanner.nextInt();

        if (codigo == 0) {
            System.out.println("Voltando...");
        }

        if (codigo != 0) {

            boolean removeu = estoque.removerProduto(codigo);

            if (removeu) {
                System.out.println("Produto removido.");
            }

            if (!removeu) {
                System.out.println("Produto nao encontrado.");
            }
        }
    }

    public static void reporEstoque(Scanner scanner,
                                    Estoque estoque) {

        System.out.println();
        System.out.println("0 - Voltar");
        System.out.print("Codigo do produto: ");

        int codigo = scanner.nextInt();

        if (codigo == 0) {
            System.out.println("Voltando...");
        }

        if (codigo != 0) {

            Produto produto = estoque.buscarProduto(codigo);

            if (produto == null) {
                System.out.println("Produto nao encontrado.");
            }

            if (produto != null) {

                System.out.print("Quantidade para adicionar: ");
                int quantidade = scanner.nextInt();

                if (quantidade <= 0) {
                    System.out.println("Quantidade invalida.");
                }

                if (quantidade > 0) {

                    produto.adicionarEstoque(quantidade);

                    System.out.println("Estoque atualizado.");
                }
            }
        }
    }

    public static void estoqueBaixo(Scanner scanner,
                                    Estoque estoque) {

        System.out.println();
        System.out.println("Produtos com estoque baixo:");

        boolean encontrou = false;

        for (Integer codigo : estoque.getProdutos().keySet()) {

            Produto produto = estoque.buscarProduto(codigo);

            if (produto.getQuantidadeEstoque() < 5) {

                System.out.println();
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Codigo: " + produto.getCodigo());
                System.out.println("Quantidade: "
                        + produto.getQuantidadeEstoque());

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto com estoque baixo.");
        }

        System.out.println();
        System.out.println("0 - Voltar");
        System.out.print("Opcao: ");

        scanner.nextInt();
    }
}