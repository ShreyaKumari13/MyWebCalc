package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] jokes = {
	        "Why do Java developers wear glasses? Because they don't C#!",
	        "Why do programmers prefer dark mode? Because light attracts bugs!",
	        "I told my computer I needed a break, and now it won't stop sending me Kit Kat bars.",
	        "Why don't programmers like nature? It has too many bugs.",
	        "How many programmers does it take to change a light bulb? None, it's a hardware problem.",
	    };

    public MyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str1 = request.getParameter("num1");
		String str2 = request.getParameter("num2");
		String str3 = request.getParameter("bt1");
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int ans;
		if(str3.equals("1")) ans = num1+num2;
		else if(str3.equals("2")) ans = num1-num2;
		else if(str3.equals("3")) ans = num1*num2;
		else ans=num1/num2;
		int randomIndex = (int) (Math.random()*jokes.length);
		String randomJoke = jokes[randomIndex];
//		response.getWriter().append("Ans = "+ans);
//		response.sendRedirect("NewFile.jsp?ans = "+ans+"&joke="+randomJoke);
		response.sendRedirect("NewFile.jsp?ans=" + ans + "&joke=" + URLEncoder.encode(randomJoke, "UTF-8"));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
