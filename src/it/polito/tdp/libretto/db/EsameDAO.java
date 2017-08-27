package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.libretto.model.Esame;

public class EsameDAO {
	private final static String JDBC_URL = "jdbc:mysql://localhost/libretto?user=root&password=salva_root";

	public Esame find(String codice) {

		String query = "SELECT codice, titolo, docente, voto, data_superamento " + 
					   "FROM esame " + 
					   "WHERE codice = ? ";

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Esame e = null;
		try {
			c = DriverManager.getConnection(JDBC_URL);
			ps = c.prepareStatement(query);
			ps.setString(1, codice);
			rs = ps.executeQuery();

			if (rs.next()) {
				e = new Esame(rs.getString("codice"), rs.getString("titolo"), rs.getString("docente"));
				// e.setVoto(rs.getInt("voto"));
				// e.setDataSuperamento((rs.getDate("data_superamento")));
			}

			return e;

		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			return null;
		} finally {
			closeResources(c, ps, rs);
		}

	}

	public boolean createEsame(Esame e) {
		String query = "INSERT INTO esame (codice, titolo, docente) VALUES (?,?,?) ";

		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = DriverManager.getConnection(JDBC_URL);
			ps = c.prepareStatement(query);
			ps.setString(1, e.getCodice());
			ps.setString(2, e.getTitolo());
			ps.setString(3, e.getDocente());

			int result = ps.executeUpdate();

			return (result == 1);

		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			return false;
		} finally {
			closeResources(c, ps, null);
		}

	}

	private void closeResources(Connection c, PreparedStatement ps, ResultSet rs) {
		// TODO Auto-generated method stub
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
