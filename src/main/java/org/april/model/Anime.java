package org.april.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="anime")
public class Anime implements Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="release_date")
    private Date releaseDate;

    @Column(name = "finished")
    private boolean finished;

    public Anime() {
    }

    public Anime(int id, String title, Date releaseDate, boolean finished) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Anime " +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", finished=" + finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
