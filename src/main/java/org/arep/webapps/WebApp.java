package org.arep.webapps;

import org.arep.server.HttpServer;

import java.io.IOException;

public class WebApp {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        server.addService("/form", new FormHTMLService());
        server.addService("/style", new FormCSSService());
        server.run(args);
    }
}
