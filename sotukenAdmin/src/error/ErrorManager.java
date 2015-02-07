package error;

import java.io.IOException;

import javax.servlet.http.HttpServlet;

import tools.LoadProperty;

public class ErrorManager extends HttpServlet{

	private String err;
	private String errMsg;
	private LoadProperty lp;

	public ErrorManager(){
		super();
		try {
			lp = new LoadProperty("/res/msg.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getErr() {
		return err;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void error(String err){

		switch (err) {
		case "syosai":

			this.errMsg = lp.getProperty("syosai.errMsg");
			break;

		case "insertKakunin":

			this.errMsg = lp.getProperty("	insertKakunin.errMsg");
			break;

		default:
			break;
		}


	}
}
