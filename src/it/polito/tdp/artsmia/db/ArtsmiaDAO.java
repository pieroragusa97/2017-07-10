package it.polito.tdp.artsmia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.artsmia.model.ArtObject;
import it.polito.tdp.artsmia.model.Coppia;

public class ArtsmiaDAO {

	public List<ArtObject> listObjects() {
		
		String sql = "SELECT * from objects";
		List<ArtObject> result = new ArrayList<ArtObject>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				ArtObject artObj = new ArtObject(res.getInt("object_id"), res.getString("classification"), res.getString("continent"), 
						res.getString("country"), res.getInt("curator_approved"), res.getString("dated"), res.getString("department"), 
						res.getString("medium"), res.getString("nationality"), res.getString("object_name"), res.getInt("restricted"), 
						res.getString("rights_type"), res.getString("role"), res.getString("room"), res.getString("style"), res.getString("title"));
				
				result.add(artObj);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
public List<Coppia> listCoppie(Map<Integer,ArtObject> mappa) {
		
		String sql = "SELECT e1.object_id AS o1,e2.object_id AS o2,COUNT(e1.exhibition_id) AS c " + 
				"FROM exhibition_objects e1,exhibition_objects e2 " + 
				"WHERE e1.exhibition_id=e2.exhibition_id AND e1.object_id>e2.object_id " + 
				"GROUP BY o1,o2";
		List<Coppia> result = new ArrayList<Coppia>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Coppia c=new Coppia(mappa.get(res.getInt("o1")),mappa.get(res.getInt("o2")),res.getInt("c"));
				result.add(c);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
