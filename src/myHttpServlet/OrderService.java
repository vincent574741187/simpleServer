package myHttpServlet;

public class OrderService implements IService{

	private final String serviceName = "orderService";
	
	public String orderMeal(){
		
		return "success";
	}
	@Override
	public String getServiceName(){
		return this.serviceName;
	}

	@Override
	public String doRequest() {
		return orderMeal();
	}
	
}
