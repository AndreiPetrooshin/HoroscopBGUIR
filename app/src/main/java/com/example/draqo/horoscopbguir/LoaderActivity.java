package com.example.draqo.horoscopbguir;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by draqo on 31.05.2017.
 */

public class LoaderActivity extends AsyncTask<Void, Void, Void> {




    private ArrayList<String> arrayList = new ArrayList<>();
    private String textToday;


    @Override
    protected Void doInBackground(Void... params) {
        String line;
        String xmlFile = "";
        try {
            URL url = new URL("http://img.ignio.com/r/export/utf/xml/daily/com.xml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
            while (true) {
                line = reader.readLine();
                if (line == null)
                    break;

                xmlFile += line;
            }
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            StringReader stringReader = new StringReader(xmlFile);
            is.setCharacterStream(stringReader);

            Document doc = db.parse(is);
            loadInfo(doc);


        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(arrayList.size() < 12)return;
        MainActivity.oven.setText("ОВНЫ: " + arrayList.get(0));
        MainActivity.telec.setText("ТЕЛЬЦЫ: " +arrayList.get(1));
        MainActivity.blizneci.setText("БЛИЗНЕЦЫ: " +arrayList.get(2));
        MainActivity.rak.setText("РАКИ: " +arrayList.get(3));
        MainActivity.lev.setText("ЛЬВЫ: " +arrayList.get(4));
        MainActivity.deva.setText("ДЕВЫ: " +arrayList.get(5));
        MainActivity.vesi.setText("ВЕСЫ: " +arrayList.get(6));
        MainActivity.scorpion.setText("СКОРПИОНЫ: " +arrayList.get(7));
        MainActivity.strelec.setText("СТРЕЛЬЦЫ: " +arrayList.get(8));
        MainActivity.kozerog.setText("КОЗЕРОГИ: " +arrayList.get(9));
        MainActivity.vodolei.setText("ВОДОЛЕИИ: " +arrayList.get(10));
        MainActivity.ribi.setText("РЫБЫ: " +arrayList.get(11));
        MainActivity.textToday.setText("Гороскоп на: " + textToday);
    }

    private void loadInfo(Document document){
        NodeList nodes = document.getElementsByTagName("today");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            arrayList.add(element.getTextContent());
        }
        NodeList nodeList = document.getElementsByTagName("date");
        Element element = (Element) nodeList.item(0);
        textToday = element.getAttribute("today");
    }

}
