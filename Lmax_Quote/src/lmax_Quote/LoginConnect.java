package lmax_Quote;

import java.io.IOException;

import java.io.InputStream;
import java.util.Properties;

import com.lmax.api.LmaxApi;
import com.lmax.api.account.LoginRequest;


public class LoginConnect {
	Properties properties = new Properties();

	public static void main(String[] args) {
		new LoginConnect();
	}
	
	public LoginConnect() {
		InputStream input = LoginConnect.class.getClassLoader().getResourceAsStream("application.properties");
		
		try {
			properties.load(input);
			String username = properties.get("login").toString();
			String password = properties.get("password").toString();
			String urlDemo  = properties.get("urlDemo").toString();
			
			LmaxApi lmaxApi = new LmaxApi(urlDemo);
			
			lmaxApi.login(new LoginRequest(username, password, LoginRequest.ProductType.CFD_DEMO), new CustomLoginCallback(){ 
			
			});
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Cannot loaded config file");
		}
		
		
	}

}
