package model;

import java.sql.*;

public class Event {

	public ReturnEvent getEvent(int round) {
		int eventAmount = 0;
		int eventPrice = 0;
		int eventDurability = 0;
		String eventName = "";
		String eventDescription = "";

		Connection c = null;
		Statement stmt = null;
		try {

			// connect to db
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:bier_db.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();

			// sql query
			ResultSet rs = stmt.executeQuery("SELECT * FROM event WHERE minRound < " + round + " AND maxRound > " + round + ";");
			ResultSetMetaData metaData = rs.getMetaData();
			int rowcount = metaData.getColumnCount();
			int random = (int) Math.floor(Math.random() * rowcount);
			while (rs.next()) {
				if (random <= 0) {
					eventAmount = rs.getInt("amountFactor") * round
							+ rs.getInt("amountOffset");
					eventPrice = rs.getInt("pricePerBeer") * eventAmount;
					eventDurability = rs.getInt("durability");
					eventName = rs.getString("name");
					eventDescription = rs.getString("description");
				} else {
					random--;
				}
			}
			rs.close();

			// close connection
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return new ReturnEvent(eventName, eventDescription, eventPrice, eventAmount, eventDurability);
	}
}
