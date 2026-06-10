package partie1;

public interface CanalEnvoi {
    void envoyer(String destinataire, String message);
}

class CanalEmail implements CanalEnvoi {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[EMAIL] -> " + destinataire + " : " + message);
    }
}

class CanalSMS implements CanalEnvoi {
    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[SMS] -> " + destinataire + " : " + message);
    }
}

abstract class Notification {
    protected CanalEnvoi canal;

    public Notification(CanalEnvoi canal) {
        this.canal = canal;
    }

    public abstract void notifier(String destinataire, String contenu);
}

class NotificationUrgente extends Notification {
    public NotificationUrgente(CanalEnvoi canal) { super(canal); }

    @Override
    public void notifier(String destinataire, String contenu) {
        canal.envoyer(destinataire, "[URGENT] " + contenu);
    }
}

class NotificationNormale extends Notification {
    public NotificationNormale(CanalEnvoi canal) { super(canal); }

    @Override
    public void notifier(String destinataire, String contenu) {
        canal.envoyer(destinataire, contenu);
    }
}