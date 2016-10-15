package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Rubrica;

public class RubricaDao {

	public boolean inserisciRubrica(String nome){
		boolean res = false;

		PreparedStatement pst = null;

		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "Insert into Rubrica(nome) values (?)";
		pst = con.prepareStatement(sql);

			pst.setString(1, nome);

			int res2 = pst.executeUpdate();
			
			if (res2 >0) {
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
	
	public Rubrica trovaRubrica(int id) {

		Rubrica r = null;
		
		ResultSet rs = null;

		PreparedStatement pst = null;

		try {

			Connection con = DataSource.getInstance().getConnection();
			String sql = "Select * from Rubrica where id_rubrica=?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, id);

			pst.executeQuery();

			rs = pst.executeQuery();

			if (rs.next()) {

				String nome = rs.getString("Nome");
				int id_rubrica = rs.getInt("Id_Rubrica");

				r = new Rubrica(id_rubrica,nome);

			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		

		return r;

	}

	
	public boolean aggiornaRubrica(String nome, int id_rubrica) {

		boolean res = false;
	
		PreparedStatement pst = null;

		try {
			
			Connection con = DataSource.getInstance().getConnection();

			String sql = "Update Rubrica "
					+ "set nome=?"
					+ "where id_rubrica=?";

			pst = con.prepareStatement(sql);

			pst.setString(1, nome);
			pst.setInt(2, id_rubrica);

			int res2 = pst.executeUpdate();
			if (res2 >0) {
				res = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		

		return res;
	}

	public boolean cancellaRubrica(int id_rubrica) {

		boolean res = false;
		
		PreparedStatement pst = null;

		try {
			Connection con = DataSource.getInstance().getConnection();

			String sql = "Delete from Rubrica where id_rubrica=?";
			
			pst = con.prepareStatement(sql);

			pst.setInt(1, id_rubrica);

			int res2 = pst.executeUpdate();
			if (res2 >0) {
				res = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
