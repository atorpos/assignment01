package org.assignment01.assignment01;
import com.google.gson.annotations.SerializedName;
public class WeatherEntry {
    @SerializedName("date")
    public String date;

    @SerializedName("section")
    public String section;

    @SerializedName("value")
    public int value;

    public WeatherEntry(String date, String section, int value) {
        this.date = date;
        this.section = section;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public String getSection() {
        return section;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "WeatherEntry{" +
                "date='" + date + '\'' +
                ", section='" + section + '\'' +
                ", value=" + value +
                '}';
    }

}
