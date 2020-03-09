package com.mygdx.gra.Serwer;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

class LoadConfigServerXML {
    static int portNumber;

    LoadConfigServerXML(){
        File file = new File("C:\\Users\\patry\\Desktop\\gierka\\core\\src\\com\\mygdx\\gra\\Serwer\\xml\\Port.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = Objects.requireNonNull(documentBuilder).parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        portNumber = Integer.parseInt(Objects.requireNonNull(document).getElementsByTagName("serverPort").item(0).getTextContent());
    }
}
