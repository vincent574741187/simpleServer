
/**
 * @author vincent
 *
 */
package myHttpServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 3714109900727825620L;
	private Map<String, IService> serviceMap = new HashMap<>();
	
	public MyHttpServlet(){
		super();
		IService menuService = new MenuService();
		IService orderService = new OrderService();
		serviceMap.put(menuService.getServiceName(), menuService);
		serviceMap.put(orderService.getServiceName(), orderService);
	}
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceName = request.getParameter("serviceName");
		String returnMessage = null;
		if(serviceName.equals("orderService")){
			String mealType = request.getParameter("mealType");
			String mealDate = request.getParameter("mealDate");
			String mealNums = request.getParameter("mealNums");
			returnMessage = serviceMap.get(serviceName).doRequest();
		}else{
			returnMessage = "GET It is ok!";
		}
		response.setContentType("text/plain; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(returnMessage);
		
    }

	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String blog = request.getParameter("blog");
        
        System.out.println(username);
        System.out.println(blog);
        
        response.setContentType("text/plain; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("POST It is ok!");
    }

}
