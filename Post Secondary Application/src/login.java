import java.util.HashMap;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class login {

    final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
    final String LOGIN_FORM_URL = "https://github.com/login";
    final String LOGIN_ACTION_URL = "https://github.com/session";
    final String USERNAME = "username";
    final String PASSWORD = "password";

    public void performLogin() throws Exception {
        Connection.Response loginForm = Jsoup.connect(LOGIN_FORM_URL)
                .method(Connection.Method.GET)
                .userAgent(USER_AGENT)
                .execute();

        Document loginDoc = loginForm.parse();
        HashMap<String, String> cookies = new HashMap<>(loginForm.cookies());

        String authToken = loginDoc.select("input[name=authenticity_token]").attr("value");

        HashMap<String, String> formData = new HashMap<>();
        formData.put("commit", "Sign in");
        formData.put("utf8", "\u2713");
        formData.put("login", USERNAME);
        formData.put("password", PASSWORD);
        formData.put("authenticity_token", authToken);

        Connection.Response homePage = Jsoup.connect(LOGIN_ACTION_URL)
                .cookies(cookies)
                .data(formData)
                .method(Connection.Method.POST)
                .userAgent(USER_AGENT)
                .execute();

        System.out.println(homePage.parse().html());
    }

    public static void main(String[] args) throws Exception {
        login login = new login();
        login.performLogin();
    }
}
