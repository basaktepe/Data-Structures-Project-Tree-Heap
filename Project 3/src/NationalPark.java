import java.util.ArrayList;
import java.util.Arrays;

public class NationalPark {
    private String park_name; //park ismi
    private String city_name; //il isimleri
    private int acreage; //yüzölçümü
    private String date; //ilan tarihi
    private ArrayList<String> paragraphs; //cümleler

    public NationalPark(String park_name_, String city_name_, int acreage_, String date_)
    {
        park_name = park_name_;
        city_name = city_name_;
        acreage = acreage_;
        date = date_;
    }

    public String getPark_name() {
        return park_name;
    }

    public void setPark_name(String park_name) {
        this.park_name = park_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(ArrayList<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String ParagraphsToString(){
        StringBuilder ourString = new StringBuilder();
        for (int i = 0; i < paragraphs.size(); i++)
        {
            ourString.append(paragraphs.get(i));
            ourString.append(" ");
        }
        return ourString.toString();
    }

    public String toString() {
        return " Park ismi : " + park_name + " Şehir ismi : '" + city_name + " Yüzölçümü : " + acreage + " Tarih : "
                + date +   " Bilgiler : {" + ParagraphsToString() + '}';

    }
} // End of the class
