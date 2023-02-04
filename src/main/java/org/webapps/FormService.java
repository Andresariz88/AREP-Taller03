package org.webapps;

import org.arep.RESTService;

public class FormService implements RESTService {
    @Override
    public String getHeader() {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/html\r\n" +
                "\r\n";
    }

    @Override
    public String getResponse() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>Búsqueda</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <style>\n" +
                "      @import url(\"https://fonts.googleapis.com/css?family=Roboto&display=swap\");\n" +
                "\n" +
                "      * {\n" +
                "        font-family: \"Roboto\", sans-serif;\n" +
                "        background-color: #f5f6fa;\n" +
                "      }\n" +
                "\n" +
                "      h1 {\n" +
                "        padding: 5px;\n" +
                "        margin: 15px 0px;\n" +
                "      }\n" +
                "\n" +
                "      .form {\n" +
                "        padding: 5px;\n" +
                "      }\n" +
                "\n" +
                "      .form label {\n" +
                "        margin: 5px 2px;\n" +
                "      }\n" +
                "\n" +
                "      .form input {\n" +
                "        margin: 5px 2px;\n" +
                "        padding: 8px;\n" +
                "        font-size: 15px;\n" +
                "        border-radius: 3px;\n" +
                "        border: 1px solid rgba(0, 0, 0, 0);\n" +
                "        box-shadow: 0 6px 10px 0 rgba(0, 0, 0 , .15);\n" +
                "        transition: all 200ms ease;\n" +
                "      }\n" +
                "\n" +
                "      .form input:hover {\n" +
                "        border: 1px solid rgba(0, 0, 0, 0.281);\n" +
                "        box-shadow: 0 6px 10px 0 rgba(0, 0, 0 , .22);\n" +
                "      }\n" +
                "\n" +
                "      .form input:focus {\n" +
                "        outline: none !important;\n" +
                "        border: 1px solid #6c7ff2;\n" +
                "      }\n" +
                "\n" +
                "      .btn {\n" +
                "        color: white;\n" +
                "        background-color: #7f8ff4;\n" +
                "        transition: all 200ms ease;\n" +
                "        cursor: pointer;\n" +
                "      }\n" +
                "\n" +
                "      .btn:hover {\n" +
                "        background-color: #6c7ff2;\n" +
                "      }\n" +
                "\n" +
                "      .container {\n" +
                "        margin: 5px 2px;\n" +
                "        padding: 8px;\n" +
                "      }\n" +
                "\n" +
                "    </style>\n" +
                "  </head>\n" +
                "\n" +
                "  <body>\n" +
                "    <h1>Busca una Película</h1>\n" +
                "    <form class=\"form\" action=\"/form\">\n" +
                "      <label for=\"postname\">Nombre:</label><br>\n" +
                "      <input type=\"text\" id=\"postname\" name=\"s\" value=\"John\" placeholder=\"Ingresa el nombre\" required><br>\n" +
                "      <input class=\"btn\" type=\"button\" value=\"Buscar\" onclick=\"loadPostMsg(postname)\">\n" +
                "    </form>\n" +
                "      <div class=\"container\" id=\"postrespmsg\"></div>\n" +
                "      <script>\n" +
                "        function displayJson(json, div) {\n" +
                "            for (const key of Object.keys(json)) {\n" +
                "                if (key == \"Ratings\") {\n" +
                "                    div.innerHTML += \"Ratings: \"\n" +
                "                    for (const ratingKey of Object.keys(json[key])) {\n" +
                "                        div.innerHTML += json[key][ratingKey][\"Source\"] + \": \" + json[key][ratingKey][\"Value\"] + \", \";\n" +
                "                    }\n" +
                "                    div.innerHTML += \"<br/>\"\n" +
                "                } else {\n" +
                "                    div.innerHTML += key + \": \" + json[key] + \"<br/>\";\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        function loadPostMsg(name){\n" +
                "            let movie;\n" +
                "            let url = \"/form?s=\" + name.value;\n" +
                "            fetch (url, {method: 'POST'})\n" +
                "                .then(response => response.json())\n" +
                "                .then(data => {\n" +
                "                    let div = document.getElementById(\"postrespmsg\");\n" +
                "                    div.innerHTML = \"\";\n" +
                "                    console.log(data);\n" +
                "                    displayJson(data, div);\n" +
                "                } /*document.getElementById(\"postrespmsg\").innerHTML = data*/);\n" +
                "          }\n" +
                "      </script>\n" +
                "  </body>\n" +
                "</html>";
    }
}
