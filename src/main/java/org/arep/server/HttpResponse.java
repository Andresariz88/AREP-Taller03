package org.arep.server;

/**
 * Class corresponding to the Http Server Responses.
 * By default, it is a Text/HTML response.
 */
public class HttpResponse {
    int SC_OK = 200;
    int SC_BAD_REQUEST = 400;
    private String status;
    private String type;
    private String body;

    public HttpResponse() {
        status = "HTTP/1.1 200 OK";
        type = "Content-type: text/html";
    }

    public String getResponse() {
        /*if (type.split("/")[1].equals("html")) {
            return "a";
        }
        return "e";*/
        return status + "\r\n" + type + "\r\n" + "\r\n" + body;
    }

    public String status() {
        return status;
    }

    public void status(String status) {
        this.status = status;
    }

    public String type() {
        return type;
    }

    public void type(String type) {
        this.type = "Content-type: " + type;
    }

    public String body() {
        return body;
    }

    public void body(String body) {
        this.body = body;
    }
}
