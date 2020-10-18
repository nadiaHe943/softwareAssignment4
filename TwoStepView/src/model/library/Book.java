package model.library;

import java.util.Iterator;
import java.util.Vector;

import model.DomainEntity;

public class Book implements DomainEntity{
	String title;
	String author;
	Vector<Pattern> patterns;
	
	public Book() {
		this.patterns = new Vector<Pattern>();
	}
	
	public Book(String title, String author, Vector<Pattern> patterns) {
		this.title = title;
		this.author = author;
		this.patterns = patterns;
	}
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	public void addPattern(Pattern p) {
		patterns.add(p);
	}

	@Override
	public String toXML() {
		String xmlString = "<book>";
		xmlString += "<title>" + getTitle() + "</title>";		
		xmlString += "<author>" + getAuthor() + "</author>";		
		
		xmlString += "<patternList>";
		Iterator<Pattern> i = patterns.iterator();
		while(i.hasNext()) {
			xmlString+= i.next().toXML();
		}
		xmlString += "</patternList>";
		
		xmlString += "</book>";
		
		return xmlString;
	}
	
	//factory method used by the example
	public static Book createDefaultBook() {
		Vector<Pattern> patterns = new Vector<Pattern>();
		
		patterns.add(new Pattern("Page Controller","description"));
		patterns.add(new Pattern("Front Controller","description"));
		
		return new Book("Patterns of EAA", "M. Flower", patterns);
	}

}
