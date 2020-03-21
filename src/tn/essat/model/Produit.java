package tn.essat.model;

public class Produit {
	private int id;
	private String description;
	private int quantite;
	private float prix;
	private Categorie cat;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(int id, String description, int quantite, float prix, Categorie cat) {
		super();
		this.id = id;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
		this.cat = cat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	

}
