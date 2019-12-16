import java.io.IOException;

//Fixel����쐬����
//pom���T���v���̎g��
//import web�T�[�u���b�g���g�����iver2.5�̂��߁j�@���̂悤�ɂ���΂n�j
//src/test�������i���\�b�h�G���[�o�邽�߁j
//appengine-web.xml��ǉ��iWEB-INF�Ɂj
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class HelloAppEngine extends HttpServlet{
	//static Logger logger = Logger.getLogger("SenyaBot");

	private	 static final String consumerKey = "21SibawalJYWH03UerrFMSxD2";
	private     static final String consumerSecret = "uWCVCW7UTEknAZupgH1I3GOmeQdg7U9OcPkrPn5lQTMsVy9cWZ";
    private     static final String accessToken = "1196225729391820800-OIqJW5oCISU1mQytCWdAdXfRIW3Pvh";
	private     static final String accessTokenSecret = "ZlY2zDfr2O4cM1l1GuJOqsvs5eoFyt4wg9UAePxJuJkHy";



	private static final String tweet = "���̃u���O���ʔ���ww��";

	private static final String getTweet(){
		String tweets[] = {

				"ああ"
		};
		int randint = (int)(Math.random()*tweets.length);
		return tweets[randint];
	}





	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//http://twitter4j.org/ja/configuration.html
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessTokenSecret)
			.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret);
		String message = getTweet();
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		try {
			//Twitter�ɏ����o��
			twitter.updateStatus(message);
		} catch (TwitterException e) {
			//logger.log(Level.SEVERE, "Twitter error", e);
		}
	}

			public static void main(String[] args){

				Twitter twitter = new TwitterFactory().getInstance();
				twitter.setOAuthConsumer(consumerKey, consumerSecret);
				twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));
				try{
					twitter.updateStatus(tweet);
					System.out.println("�c�C�[�g�����悗");
				} catch(TwitterException e){
					System.err.println("�c�C�[�g���s"+e.getMessage());
				}

			try{
				twitter.updateStatus(getTweet());
				System.out.println("�c�C�[�g�����悗");
			} catch(TwitterException d){
					System.err.println("�c�C�[�g���s"+d.getMessage());

			}
			}
	}