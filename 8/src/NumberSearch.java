import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NumberSearch")

public class NumberSearch extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number  =req.getParameter("number");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			Statement stmt = (Statement)conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Telephone_Directory where pn ="+number+";");
			if(rs.isBeforeFirst()) {
				resp.getWriter().append("Name\tNumber\tAddress\tCompany\tPincode\n");
				while(rs.next()) {
					resp.getWriter().append("\n"+rs.getInt(1)).append("\t"+rs.getString(2)).append("\t"+rs.getString(3)).append("\t"+rs.getString(4)).append("\t"+rs.getInt(5));
					
				}
			}
			else {
				resp.getWriter().append("No entry in the phonebook for the given value");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
