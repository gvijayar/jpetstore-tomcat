package org.springframework.samples.jpetstore.initializer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataLoader {

	public void setUpParksData() {
		Connection con = null;
		PreparedStatement extension = null;
		PreparedStatement statement = null;

		try {
			con = ConnectionManager.getConnection();

			try {
				BufferedInputStream bf = new BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream("jpetstore-postgres-schema.sql"));
				BufferedReader r = new BufferedReader(new InputStreamReader(bf));

				String line = null;
				while ((line = r.readLine()) != null) {
					try {
						PreparedStatement insertstatement = con.prepareStatement(line);
						insertstatement.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				r.close();
				bf.close();

				bf = new BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream("jpetstore-postgres-dataload.sql"));
				r = new BufferedReader(new InputStreamReader(bf));

				line = null;
				while ((line = r.readLine()) != null) {
					try {
						PreparedStatement insertstatement = con.prepareStatement(line);
						insertstatement.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				r.close();
				bf.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeStatement(extension);
			ConnectionManager.closeStatement(statement);
			ConnectionManager.closeConnection(con);
		}
	}
}
