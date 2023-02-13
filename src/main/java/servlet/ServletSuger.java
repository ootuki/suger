package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SugerLevelEval;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/ServletSuger")
public class ServletSuger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		
		
		out.write("<html>");
	    out.write("<head>");
	    out.write("<meta charset=\"UTF-8\">");
	    out.write("<title>サンプル</title>");
	    
	    out.write("</head>");
	    out.write("<body>");
		out.write("Suger Level Evaluator v0.1.0 <br>");
		
		
		//テキストボックスの入力を受け取っている
		String input = request.getParameter("nyuuryoku");		
		
		String resultStr = "resultStr";
		
		SugerLevelEval sugerLevelEval = new SugerLevelEval();
		resultStr = sugerLevelEval.getSugerLevel(input);
		
		out.write("Your Suger Level is symbolized by :");
		out.write("<font color=\"");
		out.write(resultStr);
		out.write("\"> this color </font>");
		
		
		
		out.write("</body>");
		out.write("</html>");
		
		out.close();
	}

}