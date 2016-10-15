package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.Map;
import java.util.TreeMap;

import model.Voce;

public class VoceDao {

	public boolean inserisciVoce(String nome, String cognome, String telefono,
			int id_rubrica)  {
		boolean res = false;

		PreparedStatement pst = null;

		try {
			Connection con = DataSource.getInstance().getConnection();

			String sql = "Insert into Voce(nome,cognome,telefono,id_rubrica) values (?,?,?,?)";

			pst = con.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, telefono);
			pst.setInt(4, id_rubrica);

			int res2 = pst.executeUpdate();
			if (res2 > 0) {
				res = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return res;
	}

	public Map<Integer, Voce> trovaVoce(int id_rubrica) {
		Voce v = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		Map<Integer, Voce> lista = new TreeMap<Integer, Voce>();
		try {
			String sql = "SELECT * FROM VOCE WHERE ID_RUBRICA=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id_rubrica);
			rs = st.executeQuery();
			while (rs.next()) {
				if (rs.next()) {
					int id_V = rs.getInt(1);
					String nome = rs.getString(2);
					String cognome = rs.getString(3);
					String telefono = rs.getString(4);
					int id_R = rs.getInt(5);
					v = new Voce(id_V, nome, cognome, telefono, id_R);
					lista.put(v.getId_Voce(), v);
				}
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return lista;
	}

	public Voce trovaVoce(int id_voce, int id_rubrica) {
		Voce v = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM VOCE WHERE ID_VOCE =? AND ID_RUBRICA=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id_voce);
			st.setInt(2, id_rubrica);
			rs = st.executeQuery();

			if (rs.next()) {
				int id_V = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String telefono = rs.getString(4);
				int id_R = rs.getInt(5);
				v = new Voce(id_voce, nome, cognome, telefono, id_rubrica);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return v;
	}

	public Voce trovaVoce(String nome, String cognome, int id_r) {
		Voce v = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM VOCE WHERE NOME =? AND COGNOME =? AND ID_RUBRICA=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setInt(3, id_r);
			rs = st.executeQuery();

			if (rs.next()) {
				int id_v = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				String phone = rs.getString(4);
				int id_R = rs.getInt(5);
				v = new Voce(id_v, name, surname, phone, id_R);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return v;
	}

	public boolean aggiornaVoce(String nome, String cognome, String telefono,
			int id_voce) {

		boolean res = false;

		PreparedStatement pst = null;

		try {
			String sql = "Update into Voce (Nome,Cognome,Telefono) set nome=?,cognome=?,telefono=? where id_voce=?";

			Connection con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, telefono);
			pst.setInt(4, id_voce);

			int res2 = pst.executeUpdate();
			if (res2 > 0) {
				res = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return res;
	}

	// /

	public boolean cancellaVoce(int id_voce) {

		boolean res = false;

		PreparedStatement pst = null;

		try {

			String sql = "Delete from Voce where id_voce=?";
			Connection con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);

			pst.setInt(1, id_voce);

			int res2 = pst.executeUpdate();
			if (res2 > 0) {
				res = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return res;
	}

}
