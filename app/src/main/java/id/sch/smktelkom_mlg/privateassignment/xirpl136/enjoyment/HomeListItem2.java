package id.sch.smktelkom_mlg.privateassignment.xirpl136.enjoyment;

import java.io.Serializable;

/**
 * Created by Yuzron on 13/05/2017.
 */

public class HomeListItem2 implements Serializable {
    private String poster;
    private String overview;
    private String terbit;
    private String judul;
    private String backdrop;


    public HomeListItem2(String backdrop) {
        this.backdrop = backdrop;
        this.judul = judul;
        this.poster = poster;
        this.overview = overview;
        this.terbit = terbit;


    }


    public String getPoster() {
        return poster;
    }

    public String getOverview() {
        return overview;
    }

    public String getTerbit() {
        return terbit;
    }

    public String getJudul() {
        return judul;
    }

    public String getBackdrop() {
        return backdrop;
    }

}
