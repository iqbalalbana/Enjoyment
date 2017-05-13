package id.sch.smktelkom_mlg.privateassignment.xirpl136.enjoyment;

import java.io.Serializable;

/**
 * Created by Yuzron on 12/05/2017.
 */

public class HomeListDetail implements Serializable {
    private String poster;
    private String overview;
    private String terbit;
    private String judul;
    private String backdrop;


    public HomeListDetail(String judul, String terbit, String overview, String backdrop) {
        this.poster = poster;
        this.overview = overview;
        this.terbit = terbit;
        this.judul = judul;
        this.backdrop = backdrop;

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


