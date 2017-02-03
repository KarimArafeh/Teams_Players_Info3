package com.example.y2793623b.teams_players_info;

import java.io.Serializable;

/**
 * Created by y2793623b on 24/01/17.
 */

public class Equipo implements Serializable{

    private String name;
    private String code;
    private String shortName;
    private String squadMarketValue;
    private String crestUrl;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }


    @Override
    public String toString() {
        return "Equipo{" +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", shortName='" + shortName + '\'' +
                ", squadMarketValue=" + squadMarketValue +
                ", crestUrl=" + crestUrl +
                '}';
    }
}

