package tn.essat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.essat.dao.GestionImp;
import tn.essat.dao.IGestionDao;
import tn.essat.model.Categorie;
import tn.essat.model.Produit;

/**
 * Servlet implementation class Principale
 */
public class Principale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IGestionDao dao=new GestionImp();
		List<Produit> liste1=dao.getAllProduits();
		List<Categorie> liste2=dao.getAllCategories();
		if(request.getParameter("id") !=null) {
			int id=Integer.parseInt(request.getParameter("id"));
			liste1=dao.getAllProduitsByCatId(id);
		}
		request.setAttribute("prods", liste1);
		request.setAttribute("cats", liste2);
		request.getRequestDispatcher("accueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
