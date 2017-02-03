package com.example.y2793623b.teams_players_info;

import java.io.Serializable;

/**
 * Created by y2793623b on 10/01/17.
 */

public class Competition implements Serializable{

    private int id;
    private String caption;
    private String league;
    private String year;
    private int numberOfTeams;
    private int numberOfGames;
    private String lastUpdated;
    private String teamsLink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTeamsLink() {return teamsLink;}

    public void setTeamsLink(String teamsLink) {this.teamsLink = teamsLink;}

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", league='" + league + '\'' +
                ", year='" + year + '\'' +
                ", numberOfTeams=" + numberOfTeams +
                ", numberOfGames=" + numberOfGames +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", teamsLink='" + teamsLink + '\'' +
                '}';
    }

}
