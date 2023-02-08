package org.arep.webapps;

import org.arep.server.HttpServer;

import java.io.IOException;

public class WebApp {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        server.addService("/form", new FormService());
        server.run(args);
    }
}
