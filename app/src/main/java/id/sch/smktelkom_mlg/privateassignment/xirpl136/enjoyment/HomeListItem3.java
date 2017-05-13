package id.sch.smktelkom_mlg.privateassignment.xirpl136.enjoyment;

import java.io.Serializable;

/**
 * Created by Yuzron on 13/05/2017.
 */

public class HomeListItem3 implements Serializable {
    private String nama;
    private String desc;
    private String modified;
    private String image;


    public HomeListItem3(String image) {
        this.image = image;
        this.nama = nama;
        this.desc = desc;
        this.modified = modified;

    }

    public String getNama() {
        return nama;
    }

    public String getDesc() {
        return desc;
    }

    public String getModified() {
        return modified;
    }

    public String getImage() {
        return image;
    }
}
