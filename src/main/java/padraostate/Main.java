package padraostate;

public class Main {
    static void main() {
        Pedido pedido = new Pedido();
        pedido.setDescricao("Pedido #1");
        IO.println(pedido.getDescricao() + " - estado inicial: " + pedido.getNomeEstado());

        IO.println("Enviar antes de pagar: " + pedido.enviar() + " -> " + pedido.getNomeEstado());
        IO.println("Pagar: " + pedido.pagar() + " -> " + pedido.getNomeEstado());
        IO.println("Enviar: " + pedido.enviar() + " -> " + pedido.getNomeEstado());
        IO.println("Cancelar após envio: " + pedido.cancelar() + " -> " + pedido.getNomeEstado());
        IO.println("Entregar: " + pedido.entregar() + " -> " + pedido.getNomeEstado());

        Pedido outro = new Pedido();
        outro.setDescricao("Pedido #2");
        IO.println(outro.getDescricao() + " - cancelar: " + outro.cancelar() + " -> " + outro.getNomeEstado());
        IO.println(outro.getDescricao() + " - pagar cancelado: " + outro.pagar() + " -> " + outro.getNomeEstado());
    }
}
