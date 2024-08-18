package org.april.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="release_date")
    private Date releaseDate;

    @Column(name = "season_count")
    private int seasonCount;

    @Column(name = "finished")
    private boolean finished;

    public Series() {
    }

    public Series(int id, String title, Date releaseDate, int seasonCount, boolean finished) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.seasonCount = seasonCount;
        this.finished = finished;
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

    public int getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
