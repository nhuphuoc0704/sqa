package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InternetAccountDAO;
import model.Customer;
import model.InternetBankAccount;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		InternetBankAccount i= new InternetBankAccount(username, password);
		if((new InternetAccountDAO()).checkLogin(i)) {
			Customer c= i.getCustomer();
			request.getSession().setAttribute("password", password);
			request.getSession().setAttribute("customer", c);
			response.sendRedirect("home.jsp");
		}
		else {
			request.getSession().setAttribute("error login", "Tên người dùng hoặc mật khẩu không chính xác");
			response.sendRedirect("login.jsp");
		}
			
		
	}

}
