package notificacoes;

public class NotificadorEmail implements INotificador {


    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);


    }
}
