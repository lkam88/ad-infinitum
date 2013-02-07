import java.io.File;

import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.Segment;
import com.echonest.api.v4.Track;
import com.echonest.api.v4.TrackAnalysis;

/**
 * A completely useless class just to test out the Echo Nest API.
 * 
 * @author Lucas
 *
 */
public class HelloWorld {
	
	public static String API_KEY;
	public static String TEST_FILE_PATH;
	
	public static void main(String[] args) {
		API_KEY = args[0];
		TEST_FILE_PATH = args[1];
		
		
		try {
			new HelloWorld().doStuff();
		}
		catch (Exception e) {e.printStackTrace();}
	}
	
	public void doStuff() throws Exception {
		EchoNestAPI api = new EchoNestAPI(API_KEY);
		File songToBeUploaded = new File (TEST_FILE_PATH);
		TrackAnalysis uploadedSongAnalysis = api.uploadTrack(songToBeUploaded).getAnalysis();
		// What is the difference between all these things?
		System.out.println("--------------Sections----------------");
		System.out.println(uploadedSongAnalysis.getSections().size());
		System.out.println(uploadedSongAnalysis.getSections().get(0));
		// I think segments are the things we want.
		System.out.println("--------------Segements----------------");
		System.out.println(uploadedSongAnalysis.getSegments().size());
		System.out.println(uploadedSongAnalysis.getSegments().get(0));
		
		System.out.println("--------------Beats--------------------");
		System.out.println(uploadedSongAnalysis.getBeats().size());
		System.out.println(uploadedSongAnalysis.getBeats().get(0));
		
		System.out.println("--------------Bars---------------------");
		System.out.println(uploadedSongAnalysis.getBars().size());
		System.out.println(uploadedSongAnalysis.getBars().get(0));
		
		System.out.println("--------------Tatums-------------------");
		System.out.println(uploadedSongAnalysis.getTatums().size());
		System.out.println(uploadedSongAnalysis.getTatums().get(0));
		/*for (Segment segment: uploadedSongAnalysis.getSegments()) {
			System.out.println(segment);
		}*/
			
		
	}

}
