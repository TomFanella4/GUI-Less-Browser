/* Author:
 * Tom Fanella
 * 
 * Description:
 * Allows User to access their grades using a GUI-Less browser
 * 
 * Purpose:
 * Implement into application to access grades using predetermined navigation commands
 * 
 * Credit to gargoylesoftware for supplying me with the tools to build this application
 */

import java.util.Scanner;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class GetGrades {
	
	public static void main (String[] args) throws Exception {
		// Sets up JavaScript enabled browser and loads web page
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
	    final HtmlPage page = webClient.getPage("https://gradebook.browardschools.com/PIV/");
	    
	    // Instantiates a new Scanner
		Scanner in = new Scanner(System.in);
		
		// Gets user ID
		System.out.println("What is your ID?");
		String id = in.nextLine();
		
		// Gets user Password
		System.out.println("What is your Password?");
		String pass = in.nextLine();
	    
		//Gets Student ID element
	    final HtmlTextInput textField = page.getElementByName("uxStudentId");
	    textField.setValueAttribute(id);
	    
	    // Gets Password element
	    final HtmlPasswordInput passField = page.getElementByName("uxPassword");
	    passField.setValueAttribute(pass);
	    
	    // Sets school to Cypress Bay
	    final HtmlSelect selectSchool = page.getElementByName("uxSchools");
	    selectSchool.setSelectedAttribute("8f5c2ce1-8759-4cc4-bcf9-e8520270d2fa", true);
	    
	    // Presses Login button
	    final HtmlSubmitInput button = page.getElementByName("uxLogon");
	    HtmlPage page2 =  button.click();
	    
	    // Prints Useful data
	    System.out.println(page2.asText());
	    
	    // Closes Browser
	    webClient.closeAllWindows();
	}
}
