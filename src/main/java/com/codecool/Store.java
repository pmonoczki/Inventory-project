package com.codecool;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertStoreParameters;
import java.util.ArrayList;
import java.util.List;

abstract class Store implements StoreCapable {

    private final String FILE_NAME = "products.xml";

    private final String PRODUCT_TAG_NAME = "product";

    protected Product createProduct(String type, String name, int price, int size) {
        if (type.equals("CD")) {
            return new CDProduct(name, price, size);
        } else {
            return new BookProduct(name, price, size);
        }
    }

    protected abstract void storeProduct(Product product);

    private void saveToXml(Product product) {


    }

    /**
     * Stores a product. Saves it to XML and allows
     * to override the process.
     *
     * @param product
     */
    public void store(Product product) {
        saveToXml(product);
        storeProduct(product);
    }

    protected List<Product> loadProducts() {
        List<Product> l = new ArrayList<Product>();
        try {onenore
            InputStream is = new FileInputStream("");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(is);

            Element root = d.getDocumentElement();

            for (int i = 0; i < root.getElementsByTagName(PRODUCT_TAG_NAME).getLength(); i++){
                Node n = root.getElementsByTagName(PRODUCT_TAG_NAME).item(i);
                if (n.getNodeType() == n.ELEMENT_NODE){
                    Element e = (Element)n;

                    Product o = null;


                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(SAXException se){
            se.printStackTrace();
        }
        catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }
        return l;
    }
}
