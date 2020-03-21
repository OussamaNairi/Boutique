package tn.essat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.essat.model.Categorie;
import tn.essat.model.Produit;


public class GestionImp implements IGestionDao{
	private Connection cnx;

	public GestionImp() {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/boutique2020?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produit> getAllProduits() {
	List<Produit> liste=new ArrayList<Produit>();
	try {
		PreparedStatement pre=cnx.prepareStatement("select * from produit");
		ResultSet rs=pre.executeQuery();
		while(rs.next()) {
			Produit prod=new Produit();
			prod.setId(rs.getInt("id"));
			prod.setDescription(rs.getString("description"));
			prod.setPrix(rs.getFloat("prix"));
			prod.setQuantite(rs.getInt("quantite"));
			prod.setCat(this.getCategorieById(rs.getInt("cat_id")));
			liste.add(prod);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return liste;
	}

	@Override
	public List<Produit> getAllProduitsByCatId(int id) {
		List<Produit> liste=new ArrayList<Produit>();
		try {
			PreparedStatement pre=cnx.prepareStatement("select * from produit where cat_id=?");
			pre.setInt(1,id);
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
				Produit prod=new Produit();
				prod.setId(rs.getInt("id"));
				prod.setDescription(rs.getString("description"));
				prod.setPrix(rs.getFloat("prix"));
				prod.setQuantite(rs.getInt("quantite"));
				prod.setCat(this.getCategorieById(rs.getInt("cat_id")));
				liste.add(prod);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> liste=new ArrayList<Categorie>();
		try {
			PreparedStatement pre=cnx.prepareStatement("select * from categorie");
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
				Categorie cat=new Categorie();
				cat.setId(rs.getInt("id"));
				cat.setDescription(rs.getString("description"));
				liste.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public Produit getAllProduitById(int id) {
		Produit prod=null;
		try {
			PreparedStatement pre=cnx.prepareStatement("select * from produit where id=?");
			pre.setInt(1,id);
			ResultSet rs=pre.executeQuery();
			if(rs.next()) {
				prod=new Produit();
				prod.setId(rs.getInt("id"));
				prod.setDescription(rs.getString("description"));
				prod.setPrix(rs.getFloat("prix"));
				prod.setQuantite(rs.getInt("quantite"));
				prod.setCat(this.getCategorieById(rs.getInt("cat_id")));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public Categorie getCategorieById(int id) {
		Categorie cat=null;
		try {
			PreparedStatement pre=cnx.prepareStatement("select * from categorie where id=?");
			pre.setInt(1,id);
			ResultSet rs=pre.executeQuery();
			if(rs.next()) {
				cat=new Categorie();
				cat.setId(rs.getInt("id"));
				cat.setDescription(rs.getString("description"));
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}
	
	

}
