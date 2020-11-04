package breakthecode.com.pl.springnauka.testresponse;

public class Response {
	
	private boolean successful;
	private String msg;
	
	public Response() {
		
	}
	
	public Response(boolean succesful, String msg) {
		this.successful = succesful;
		this.msg = msg;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
