//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//		//Create a new RedditClient and log us in!
//		LoginAttempt client = new LoginAttempt("hutsboR", "MyPassword!");
//		client.login();
//		
//		//Let's scrape our messages, information behind a login.
//		//https://www.reddit.com/message/messages/ is the URL where messages are located.
//		String page = client.get("https://www.reddit.com/message/messages/");
//		
//		//"div.md" selects all divs with the class name "md", that's where message
//		//bodies are stored. You'll find "<div class="md">" before each message.
//		Elements messages = Jsoup.parse(page).select("div.md");
//		
//		//For each message in messages, let's print out message and a new line.
//		for(Element message : messages){
//			System.out.println(message.text() + "\n");
//		}
//	}
//
//}