import java.io.IOException;
import java.net.MalformedURLException;

import org.htmlunit.FailingHttpStatusCodeException;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlForm;
import org.htmlunit.html.HtmlInput;
import org.htmlunit.html.HtmlPage;
import org.htmlunit.BrowserVersion;


public class LoginAttempt {
	public static void main(String[] args) {
	    WebClient webClient = new WebClient();
	    try {
	        HtmlPage page = (HtmlPage) webClient
	                .getPage("https://ma-andover.myfollett.com/aspen/logon.do");
	        HtmlForm form = page.getFormByName("logonForm");
	        form.getInputByName("username").setValueAttribute("myUsername"); 
	        HtmlInput passWordInput = form.getInputByName("password");
	        passWordInput.removeAttribute("disabled");
	        passWordInput.setValueAttribute("myPassword"); 

	        page = form.getInputByValue("Log On").click(); // works fine

	        System.out.println(page.asXml());
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        webClient.close();
	    }
	}
}