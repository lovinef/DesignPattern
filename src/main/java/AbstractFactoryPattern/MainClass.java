package AbstractFactoryPattern;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class MainClass {
    public static void main(String[] args) throws IOException {
        // iterator 인터페이스로 접근
        LinkedList linkedList = new LinkedList();
        Iterator iterator = linkedList.iterator();

        ArrayList arrayList = new ArrayList<String>();
        Iterator iterator1 = arrayList.iterator();


        String address = "";

        // ConcreteFactory
        URL home = new URL(address);

        // AbstractProduct 이기도 하고, AbstractFactory 이기도 하다
        // URL을 통해 생산된 AbstractProduct.
        // InputStream을 만들어내는 AbstractFactory.
        URLConnection c = home.openConnection();

        InputStream in = c.getInputStream();
    }
}
