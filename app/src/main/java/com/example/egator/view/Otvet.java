package com.example.egator.view;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "textzadania",
        "otvet",
        "nomer",
        "text",
        "uslovie"
})
public class Otvet implements Parcelable {

    @JsonProperty("textzadania")
    private String textzadania;
    @JsonProperty("otvet")
    private String otvet;
    @JsonProperty("nomer")
    private String nomer;
    @JsonProperty("text")
    private String text;
    @JsonProperty("uslovie")
    private String uslovie;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    protected Otvet(Parcel in) {
        textzadania = in.readString();
        otvet = in.readString();
        nomer = in.readString();
        text = in.readString();
        uslovie = in.readString();
    }

    public static final Creator<Otvet> CREATOR = new Creator<Otvet>() {
        @Override
        public Otvet createFromParcel(Parcel in) {
            return new Otvet(in);
        }

        @Override
        public Otvet[] newArray(int size) {
            return new Otvet[size];
        }
    };

    @JsonProperty("textzadania")
    public String getTextzadania() {
        return textzadania;
    }

    @JsonProperty("textzadania")
    public void setTextzadania(String textzadania) {
        this.textzadania = textzadania;
    }

    @JsonProperty("otvet")
    public String getOtvet() {
        return otvet;
    }

    @JsonProperty("otvet")
    public void setOtvet(String otvet) {
        this.otvet = otvet;
    }

    @JsonProperty("nomer")
    public String getNomer() {
        return nomer;
    }

    @JsonProperty("nomer")
    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("uslovie")
    public String getUslovie() {
        return uslovie;
    }

    @JsonProperty("uslovie")
    public void setUslovie(String uslovie) {
        this.uslovie = uslovie;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {


        dest.writeString(textzadania);
        dest.writeString(otvet);
        dest.writeString(nomer);
        dest.writeString(text);
        dest.writeString(uslovie);
    }
}
