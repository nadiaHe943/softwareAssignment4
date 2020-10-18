package model.library;

import model.DomainEntity;

public class Pattern implements DomainEntity {

	String name;
	String description;
	
	public Pattern() {
		
	}
	
	public Pattern(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toXML() {
		String xmlString = "<pattern>";
		xmlString += "<name>" + getName() + "</name>";
	    xmlString += "<description>" + getName() + "</description>";
		xmlString += "</pattern>";
		
		return xmlString;		
	}

}
