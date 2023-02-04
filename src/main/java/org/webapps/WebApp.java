package org.webapps;

import org.arep.HttpServer;
import org.arep.RESTService;

import java.io.IOException;

public class WebApp {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        server.addService("/form", new FormService());
        server.run(args);
    }
}
