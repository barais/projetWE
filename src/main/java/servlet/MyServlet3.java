package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ensai.projetWE.EntityManagerHelper;
import fr.ensai.projetWE.business.User;
import fr.ensai.projetWE.dao.UserDao;

@WebServlet(name = "mytest2", urlPatterns = { "/UserInfo" })
public class MyServlet3 extends HttpServlet {

	UserDao dao;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		dao = new UserDao();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	int i = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter p = new PrintWriter(resp.getOutputStream());
		List<User> users = dao.getAll();
		/*
		 * p.print("["); for (User u :users ) { p.print("{"); p.print(" : " );
		 * p.print("{");
		 * 
		 * }
		 */

		p.print("]");
		p.flush();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		User u = new User();
		u.setNom(request.getParameter("name"));
		u.setPrenom(request.getParameter("firstname"));
		
		dao.save(u);
		EntityManagerHelper.closeEntityManager();
		
		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Age: " + request.getParameter("age") + "\n" + "</UL>\n" + "</BODY></HTML>");
		out.flush();
		
	}
}
