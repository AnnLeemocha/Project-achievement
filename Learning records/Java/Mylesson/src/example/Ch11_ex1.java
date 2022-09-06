package example;

import example.example.Server;

/**
 * ■ 請完成Ch11.test
 * _ ■ 程式主要功能，當Server發生連接逾時時呼叫ServerTimeoutException
 * _ ■ ServerTimeoutException 已完成
 * _ ■ 請完成其他功能部份
 */
public class Ch11_ex1 {
    public static void main(String[] args) {
        // 產生 Server 物件
        Server server = new Server();
        // 進行連結
        try {
            server.connent("192.168.1.1", 80);
        } catch (Server.ServerTimeoutException ex) {
            System.out.println(ex);
        }

        // 離開 Server
        server.close();
    }
}
