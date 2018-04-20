package lmax_Quote;

import com.lmax.api.FailureResponse;
import com.lmax.api.Session;
import com.lmax.api.account.LoginCallback;

public class CustomLoginCallback implements LoginCallback{
	@Override
	public void onLoginSuccess(Session session) {
		System.out.println(session.getAccountDetails().toString());
		
		session.start();
	}
	
	@Override
	public void onLoginFailure(FailureResponse failureResponse) {
		if(failureResponse.getMessage().equals("BAD_CREDENTIALS")) {
			System.out.println("Bad Credentials");
			
		}else {
			System.out.print("Unexpected error occurred");
		}
	}
	
	
	

}