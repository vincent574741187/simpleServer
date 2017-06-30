package myHttpServlet;

public class MenuService implements IService {
	
	private final String serviceName = "menuService";

	
	public String getTodayManuInfo(){
		
		return null;
	}
	@Override
	public String getServiceName(){
		return this.serviceName;
	}

	@Override
	public String doRequest() {
		return getTodayManuInfo();
	}
	
}
