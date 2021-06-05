package com.ranishll.demoproject.impl;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

import java.io.*;
import java.util.Iterator;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.ranishll.demoproject.services.UserServices;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class UserServiceImplement implements UserServices {

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    @Override
    public String findAllUsers() throws Exception {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        String file;
        file = "C:/Users/user/IdeaProjects/demoproject/src/main/resources/data.json";
        String json = readFileAsString(file);
        System.out.println(json);

        //create XML
        String[] temp;
        String mine = ",";
        temp = json.split(mine);
        System.out.println(temp.length);

        String[] temp1;
        String mine2 = ":";
        temp1 = temp[0].split(mine2);
        System.out.println(temp.length);

        String[] temp2;
        //String mine2 = ":";
        temp2 = temp[1].split(mine2);
        System.out.println(temp.length);



        Element rootElement = doc.createElement("dev");
        doc.appendChild(rootElement);

        Element supercar = doc.createElement("dev1");
        rootElement.appendChild(supercar);

        Element carname1 = doc.createElement("first");
        Attr attrType1 = doc.createAttribute("type");
        attrType1.setValue(temp1[0]);
        carname1.setAttributeNode(attrType1);
        carname1.appendChild(doc.createTextNode(temp1[1]));
        supercar.appendChild(carname1);

        Element carname2 = doc.createElement("second");
        Attr attrType2 = doc.createAttribute("type");
        attrType2.setValue(temp2[0]);
        carname2.setAttributeNode(attrType2);
        carname2.appendChild(doc.createTextNode(temp2[1]));
        supercar.appendChild(carname2);

        //2nd part


        /*
        Element rootElement = doc.createElement("dev");
        doc.appendChild(rootElement);

        Element supercar = doc.createElement("dev1");
        rootElement.appendChild(supercar);

        Element carname1 = doc.createElement("first");
        Attr attrType1 = doc.createAttribute("type");
        attrType1.setValue(temp[0]);
        carname1.setAttributeNode(attrType1);
        carname1.appendChild(doc.createTextNode(temp[1]));
        supercar.appendChild(carname1);

        */

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File("C:/Users/user/IdeaProjects/demoproject/src/main/resources/result.xml"));
        transformer.transform(source, result);







        //InputStream fis = new FileInputStream("data123.json");


        return json;
    }
}
