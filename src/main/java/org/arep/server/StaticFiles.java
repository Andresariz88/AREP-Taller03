package org.arep.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StaticFiles {
    private String location;
    public static final String ROOT = "src/main/resources";

    public StaticFiles() {
        location = "/public";
    }


    public boolean checkFile(String file) {
        boolean res;
        try {
            Files.readAllBytes(Paths.get(location + file));
            res = true;
        } catch (IOException e) {
            res = false;
        }
        return res;
    }

    public String getFile(String file) {
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get(location + file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String body = new String(fileContent);
        HttpResponse httpResponse = new HttpResponse(body);
        httpResponse.setSpecificType(file);
        return httpResponse.getResponse();
    }

    public byte[] getImg(String file) {
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get(location + file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent;
    }

    public String location() {
        return location;
    }

    public void location(String location) {
        this.location = ROOT + location;
    }
}
