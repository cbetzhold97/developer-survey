package com.rangers.developersurvey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.rangers.developersurvey.Play.RSExtractor;

@Component("JDBC")
public class JDBC {

	private static final Logger lgr = LoggerFactory.getLogger(Util.class);

	private final String url = "jdbc:postgresql://localhost:5432/rangers_ws10";
	private final String user = "postgres1";
	private final String password = "default";

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public List<Play> getPlays(String date) {
		lgr.info("Getting plays from " + date);
		String SQL = "SELECT * FROM plays Where date = TO_DATE(?,'YYYY-MM-DD') Order By abnum";
		List<Play> plays = new ArrayList<Play>();
		RSExtractor extractor = new RSExtractor();
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			pstmt.setString(1, date);
			ResultSet rs = pstmt.executeQuery();
			plays = extractor.extractData(rs);
		} catch (SQLException ex) {
			lgr.error(ex.getMessage());
		}
		return plays;
	}

	public List<String> getDate() {
		lgr.info("Getting dates");
		String SQL = "SELECT distinct date From plays order by date asc";
		List<String> dates = new ArrayList<String>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {

			while (rs.next()) {
				String date = rs.getString("date");
				dates.add(date);
			}
		} catch (SQLException ex) {
			lgr.error(ex.getMessage());
		}

		return dates;

	}

}
