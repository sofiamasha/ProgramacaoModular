public class Pilha {

    private int[] vetor;
    private int topo;

    public Pilha(int tamanho) {
        vetor = new int[tamanho];
        topo = -1;
    }

    public void push(int valor) {
        topo++;
        vetor[topo] = valor;
    }

    public int pop() {
        int valor = vetor[topo];
        topo--;
        return valor;
    }

    public int peek() {
        return vetor[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == vetor.length - 1;
    }
}