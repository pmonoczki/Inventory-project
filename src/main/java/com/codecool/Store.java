package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

abstract class Store implements StoreCapable {

    private final String FILE_NAME = "src/products.xml";

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
        try {

            InputStream is = new FileInputStream(FILE_NAME);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(is);

            Element root = d.getDocumentElement();

            Element e = d.createElement("product");
            e.setAttribute("name", product.getName());
            e.setAttribute("price", String.valueOf(product.getPrice()));
            if (product instanceof CDProduct){
                e.setAttribute("type", "cd");
                e.setAttribute("size",
                        String.valueOf(
                                ((CDProduct)product).getNumOfTracks()
                ));
            }
            else{
                e.setAttribute("type", "book");
                e.setAttribute("size",
                        String.valueOf(
                                ((BookProduct)product).getNumOfPages()
                        ));

            }

            root.appendChild(e);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(new File(FILE_NAME));
            Source input = new DOMSource(d);



            transformer.transform(input, output);




        } catch (Exception e) {
            e.printStackTrace();

        }
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
        try {
            InputStream is = new FileInputStream(FILE_NAME);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(is);

            Element root = d.getDocumentElement();

            for (int i = 0; i < root.getElementsByTagName(PRODUCT_TAG_NAME).getLength(); i++){
                Node n = root.getElementsByTagName(PRODUCT_TAG_NAME).item(i);
                if (n.getNodeType() == n.ELEMENT_NODE){
                    Element e = (Element)n;

                    Product p =
                            createProduct(e.getAttribute("type"),
                                    e.getAttribute("name"),
                                   Integer.parseInt( e.getAttribute("price")),
                                    Integer.parseInt( e.getAttribute("size")));
                    l.add(p);


                }

            }
            is.close();

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
