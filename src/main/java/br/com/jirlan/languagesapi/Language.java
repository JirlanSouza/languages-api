package br.com.jirlan.languagesapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class Language {
    @Id
    private String id;
    private final String title;
    private final String image;
    private final int rank;

    public Language(String title, String image, int rank) {
        this.title = title;
        this.image = image;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRank() {
        return rank;
    }
}
