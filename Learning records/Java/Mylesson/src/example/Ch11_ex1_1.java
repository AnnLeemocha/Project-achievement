package example;

/**
 * ■ 請完成Ch11.test
 * _ ■ 程式主要功能，當Server發生連接逾時時呼叫ServerTimeoutException
 * _ ■ ServerTimeoutException 已完成
 * _ ■ 請完成其他功能部份
 */
public class Ch11_ex1_1 {
    // 主程式
    public static void main(String[] args) {
        // 產生 Server 物件
        Server server = new Server();
        // 進行連結
        try {
            server.connent("192.168.1.1", 80);
        } catch (ServerTimeoutException ex) {
            // } catch (Server.ServerTimeoutException ex) {
            System.out.println(ex);
        }

        // 離開 Server
        server.close();
    }
}

// 產生類別 + 例外處理丟出
class Server {
    private int timeDelay;

    public void connent(String ip, int port) throws ServerTimeoutException {
        // 強制逾時
        while (true) {
            if (++timeDelay >= 1000) {
                // 拋出例外
                String message = ip + " 處理逾時...";
                throw new ServerTimeoutException(message, port);
            }
        }
    }

    public void close() {
        System.out.println("Server 關閉...");
    }

    // public class ServerTimeoutException extends Exception {
    // private int port;
    // private String message;

    // ServerTimeoutException(String message, int port) {
    // this.port = port;
    // this.message = message;
    // }

    // public int getPort() {
    // return port;
    // }

    // @Override
    // public String toString() {
    // return "ServerTimeoutException { " +
    // "port=" + port +
    // ", message='" + message + "\'" +
    // " }";
    // }
    // }

}

// 例外處理
class ServerTimeoutException extends Exception {
    private int port;
    private String message;

    ServerTimeoutException(String message, int port) {
        this.port = port;
        this.message = message;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "ServerTimeoutException { " +
                "port=" + port +
                ",  message='" + message + "\'" +
                " }";
    }
}
