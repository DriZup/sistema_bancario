package notificacoes;

public class NotificadorSMS implements INotificador {

    private String telefone;

    public NotificadorSMS(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void notificar(String mensagem) {

    }
}
