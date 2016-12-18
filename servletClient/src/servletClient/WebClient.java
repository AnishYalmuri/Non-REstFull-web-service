package servletClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import webservices.HelloPortBindingStub;
import webservices.HelloServiceLocator;

/**
 * Servlet implementation class WebClient
 */
@WebServlet("/WebClient")
public class WebClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
		webservices.HelloPortBindingStub port=null;
    	HelloServiceLocator hsc= new HelloServiceLocator();
    	try {
			port = (HelloPortBindingStub) hsc.getHelloPort();
			//System.out.println(port.sayHello("Akash"));
			//Scanner sc=new Scanner(System.in);
		
			String paraString=request.getParameter("first_name")+"%"+request.getParameter("last_name")+"%"
					+request.getParameter("boat_type")+"%"+request.getParameter("boat_length")+"%"+request.getParameter("build_year")+"%"+request.getParameter("motor_type")+"%"
							+request.getParameter("fee_paid")+"%"+request.getParameter("moored_slip")+"%";
			System.out.println("paraString"+paraString);
			String opString="<table><tr><th>Firstname</th><th>Lastname</th> <th>Boat Type</th><th>Boat Length</th><th>Build Year</th>"
					+ "<th>slip fee paid</th><th>Motor Type</th><th>Moored Slip</th></tr>";
			opString+=getTableRows(port.findSailorInfo(paraString));
			opString+="</table>";
			System.out.println(opString);
			out.println(opString);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	      
	}
	public String getTableRows(String serverOP){
		String opString="";
		String[] rows=serverOP.split("&");
		for(int i=0;i<rows.length;i++){
			opString+="<tr>";
			String[] tmp=rows[i].split("-");
			for(int j=0;j<tmp.length;j++){
				opString+="<td>";
				opString+=tmp[j];
				opString+="</td>";
				
			}
			opString+="</tr>";
		}
		return opString;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
