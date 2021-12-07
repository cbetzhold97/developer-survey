package com.rangers.developersurvey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class Play {

	public static class RSExtractor implements ResultSetExtractor<List<Play>> {

		@Override
		public List<Play> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Play> ret = new ArrayList<>();
			while (rs.next()) {
				Play play = new Play();
				play.setId(rs.getInt("id"));
				play.setDate(rs.getDate("date"));
				play.setTemp(rs.getString("temp"));
				play.setCondition(rs.getString("condition"));
				play.setWind(rs.getString("wind"));
				play.setBatter_name(rs.getString("batter_name"));
				play.setBatter(rs.getInt("batter"));
				play.setStand(rs.getString("stand").charAt(0));
				play.setPitcher_name(rs.getString("pitcher_name"));
				play.setPitcher(rs.getInt("pitcher"));
				play.setPthrows(rs.getString("pthrows").charAt(0));
				play.setEvents(rs.getString("events"));
				play.setDescription(rs.getString("description"));
				play.setDes(rs.getString("des"));
				play.setHome_team(rs.getString("home_team"));
				play.setAway_team(rs.getString("away_team"));
				play.setGamepk(rs.getInt("gamepk"));
				play.setInning(rs.getInt("inning"));
				play.setTopbot(rs.getString("topbot"));
				play.setAbnum(rs.getInt("abnum"));
				play.setVenue(rs.getString("venue"));
				play.setAway_score(rs.getInt("away_score"));
				play.setHome_score(rs.getInt("home_score"));
				ret.add(play);
			}
			return ret;
		}
	}

	private Integer id;
	private Date date;
	private String temp;
	private String condition;
	private String wind;
	private String batter_name;
	private Integer batter;
	private Character stand;
	private String pitcher_name;
	private Integer pitcher;
	private Character pthrows;
	private String events;
	private String description;
	private String des;
	private String home_team;
	private String away_team;
	private Integer gamepk;
	private Integer inning;
	private String topbot;
	private Integer abnum;
	private String venue;
	private Integer home_score;
	private Integer away_score;

	public Integer getHome_score() {
		return home_score;
	}

	public void setHome_score(Integer home_score) {
		this.home_score = home_score;
	}

	public Integer getAway_score() {
		return away_score;
	}

	public void setAway_score(Integer away_score) {
		this.away_score = away_score;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getBatter_name() {
		return batter_name;
	}

	public void setBatter_name(String batter_name) {
		this.batter_name = batter_name;
	}

	public Integer getBatter() {
		return batter;
	}

	public void setBatter(Integer batter) {
		this.batter = batter;
	}

	public Character getStand() {
		return stand;
	}

	public void setStand(Character stand) {
		this.stand = stand;
	}

	public String getPitcher_name() {
		return pitcher_name;
	}

	public void setPitcher_name(String pitcher_name) {
		this.pitcher_name = pitcher_name;
	}

	public Integer getPitcher() {
		return pitcher;
	}

	public void setPitcher(Integer pitcher) {
		this.pitcher = pitcher;
	}

	public Character getPthrows() {
		return pthrows;
	}

	public void setPthrows(Character pthrows) {
		this.pthrows = pthrows;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getHome_team() {
		return home_team;
	}

	public void setHome_team(String home_team) {
		this.home_team = home_team;
	}

	public String getAway_team() {
		return away_team;
	}

	public void setAway_team(String away_team) {
		this.away_team = away_team;
	}

	public Integer getGamepk() {
		return gamepk;
	}

	public void setGamepk(Integer gamepk) {
		this.gamepk = gamepk;
	}

	public Integer getInning() {
		return inning;
	}

	public void setInning(Integer inning) {
		this.inning = inning;
	}

	public String getTopbot() {
		return topbot;
	}

	public void setTopbot(String topbot) {
		this.topbot = topbot;
	}

	public Integer getAbnum() {
		return abnum;
	}

	public void setAbnum(Integer abnum) {
		this.abnum = abnum;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

}
