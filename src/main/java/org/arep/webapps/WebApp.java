package org.arep.webapps;

import org.arep.server.HttpServer;
import org.arep.server.Route;

import java.io.IOException;

public class WebApp {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        server.addService("/form", new FormHTMLService());
        server.addService("/style", new FormCSSService());
        server.addService("/script", new FormJSService());
        server.addService("/image", new FormImgService());
        server.addService("/404", new Error404Service());

        server.get("/hello", (req, res) -> "Hello Worldffff");
        server.get("/get-json", (req, res) -> {
            res.type("application/json");
            return "{\"name\"; \"Daniel\"}";
        });
        server.get("/get-css", (req, res) -> {
            res.type("text/css");
            return "* {\n" +
                    "    font-family: sans-serif;\n" +
                    "    background-color: #f5f6fa;\n" +
                    "}";
        });

        server.run(args);

    }
}
