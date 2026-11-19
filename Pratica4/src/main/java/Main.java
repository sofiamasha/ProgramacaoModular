import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    static int proximoId = 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n=== SISTEMA DE PEDIDOS ===");
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Alterar status");
            System.out.println("3 - Processar pedidos");
            System.out.println("4 - Remover cancelados");
            System.out.println("5 - Exibir lista (sem cancelados)");
            System.out.println("6 - Exibir entregáveis");
            System.out.println("7 - Encerrar");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarPedido();
                    break;
                case 2:
                    alterarStatus();
                    break;
                case 3:
                    processarPedidos();
                    break;
                case 4:
                    removerCancelados();
                    break;
                case 5:
                    exibirSemCancelados();
                    break;
                case 6:
                    exibirEntregaveis();
                    break;
                case 7:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    static void cadastrarPedido() {
        System.out.println("Tipo: 1-Eletrônico  2-Roupa  3-Alimento");
        int tipo;
        try {
            tipo = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tipo inválido.");
            return;
        }

        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Valor: ");
        double valor;
        try {
            valor = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido.");
            return;
        }

        try {
            Pedido p;
            if (tipo == 1) {
                p = new PedidoEletronico(proximoId, nome, valor);
            } else if (tipo == 2) {
                p = new PedidoRoupa(proximoId, nome, valor);
            } else if (tipo == 3) {
                p = new PedidoAlimento(proximoId, nome, valor);
            } else {
                System.out.println("Tipo inválido.");
                return;
            }
            pedidos.add(p);
            proximoId++;
            System.out.println("Pedido cadastrado com sucesso! ID: " + p.getId());
        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void alterarStatus() {
        System.out.print("ID do pedido: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }

        Pedido pedido = buscarPorId(id);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        System.out.println("Status: 1-PENDENTE  2-PROCESSANDO  3-ENVIADO  4-ENTREGUE  5-CANCELADO");
        int op;
        try {
            op = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
            return;
        }

        StatusPedido novoStatus;
        switch (op) {
            case 1: novoStatus = StatusPedido.PENDENTE; break;
            case 2: novoStatus = StatusPedido.PROCESSANDO; break;
            case 3: novoStatus = StatusPedido.ENVIADO; break;
            case 4: novoStatus = StatusPedido.ENTREGUE; break;
            case 5: novoStatus = StatusPedido.CANCELADO; break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        try {
            pedido.alterarStatus(novoStatus);
            System.out.println("Status alterado para " + novoStatus);
        } catch (PedidoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void processarPedidos() {
        Iterator<Pedido> it = pedidos.iterator();
        int count = 0;
        while (it.hasNext()) {
            Pedido p = it.next();
            try {
                p.processarPedido();
                count++;
                System.out.println("Pedido #" + p.getId() + " processado.");
            } catch (PedidoInvalidoException e) {
                System.out.println("Pedido #" + p.getId() + ": " + e.getMessage());
            }
        }
        System.out.println("Total processados: " + count);
    }

    static void removerCancelados() {
        Iterator<Pedido> it = pedidos.iterator();
        int count = 0;
        while (it.hasNext()) {
            Pedido p = it.next();
            if (p.getStatus() == StatusPedido.CANCELADO) {
                it.remove();
                count++;
            }
        }
        System.out.println("Removidos: " + count + " pedido(s) cancelado(s).");
    }

    static void exibirSemCancelados() {
        System.out.println("\n--- Pedidos (sem cancelados) ---");
        int count = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);
            if (p.getStatus() != StatusPedido.CANCELADO) {
                System.out.println(p);
                count++;
            }
        }
        if (count == 0) System.out.println("Nenhum pedido.");
    }

    static void exibirEntregaveis() {
        System.out.println("\n--- Pedidos Entregáveis ---");
        int count = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);
            if (p instanceof Entregavel) {
                Entregavel e = (Entregavel) p;
                System.out.println(p + " | Frete: R$" + String.format("%.2f", e.calcularFrete()));
                count++;
            }
        }
        if (count == 0) System.out.println("Nenhum pedido entregável.");
    }

    static Pedido buscarPorId(int id) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == id) {
                return pedidos.get(i);
            }
        }
        return null;
    }
}
