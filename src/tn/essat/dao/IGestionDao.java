package tn.essat.dao;

import java.util.List;

import tn.essat.model.Categorie;
import tn.essat.model.Produit;

public interface IGestionDao {
	public List<Produit> getAllProduits();
	public List<Produit> getAllProduitsByCatId(int id);
	public List<Categorie> getAllCategories();
	public Produit getAllProduitById(int id);
	public Categorie getCategorieById(int id);

}
