package partie1;

public class GameServer {

    private final int port;
    private int connectedPlayers = 0;

    private static volatile GameServer instance;

    private GameServer() {
        this.port = 8080;
    }

    public static GameServer getInstance() {
        if (instance == null) {
            synchronized (GameServer.class) {
                if (instance == null) {
                    instance = new GameServer();
                }
            }
        }
        return instance;
    }

    public void connect() {
        connectedPlayers++;
    }

    public int getConnectedPlayers() {
        return connectedPlayers;
    }

    public int getPort() {
        return port;
    }
}