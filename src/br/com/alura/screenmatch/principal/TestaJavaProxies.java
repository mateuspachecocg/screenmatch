package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.*;

public class TestaJavaProxies {
    public static void main(String[] args) throws IOException {
        System.setProperty("http.proxyHost", "http://f7021234:42551265@127.0.0.1:40080");
        System.setProperty("https.proxyHost", "http://f7021234:42551265@127.0.0.1:40080");
        SocketAddress addr = new
                InetSocketAddress("127.0.0.1", 40080);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
        var conn = new URL("www.google.com").openConnection(proxy);

    }
}
