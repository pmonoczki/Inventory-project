package com.codecool;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertStoreParameters;
import java.util.ArrayList;
import java.util.List;

abstract class Store implements StoreCapable {

    private final String FILE_NAME = "products.xml";

    protected Product createProduct(String type, String name, int price, int size) {
        if (type.equals("CD")) {
            return new CDProduct(name, price, size);
        } else {
            return new BookProduct(name, price, size);
        }
    }

    protected void storeProduct(Product product) {

    }

    private void saveToXml(Product product) {

    }

    public void store(Product product) {
        saveToXml(product);
        storeProduct(product);

    }

    private List<Product> loadProducts() {
        List<Product> l = new ArrayList<Product>();
        try {
            InputStream is = new FileInputStream("");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(is);


        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(SAXException se){
            se.printStackTrace();
        }
        return l;
    }
}
