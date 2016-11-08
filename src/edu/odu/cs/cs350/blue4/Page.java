package edu.odu.cs.cs350.blue4;


import java.util.ArrayList;

/**
 * 
 * This class is used as an input
 * @author mredeniu
 *
 */

public class Page {
	private String pageLink;
	private int intrapage;
	private int extPage;
	private int intrasite;
	private int extSite;
	private int intResource;
	private int extResource;
	private int broken;
	private ArrayList<String> references;
	private ArrayList<String> referencedBy;
	
	/**
	 * Page Constructor is used to initialize the private members
	 * @param name
	 */
	
	public Page(String name)
	{
		pageLink = name;
		intrapage = 0;
		extPage = 0;
		intrasite = 0;
		extSite = 0;
		intResource = 0;
		extResource = 0;
		broken = 0;
		
		references = new ArrayList<String>();
		referencedBy = new ArrayList<String>();
	}
	
	/**
	 * To get the page link
	 * @return the pageLink
	 */
	
	public String getPageLink() {
		return pageLink;
	}
	
	/**
	 * To set the page link
	 * @param pageLink 
	 */
	
	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}
	
	/**
	 * To get the intrapage
	 * @return the intrapage
	 */
	
	public int getIntrapage() {
		return intrapage;
	}
	
	/**
	 * Set the intrapage
	 * @param intrapage 
	 */
	
	public void setIntrapage(int intrapage) {
		this.intrapage = intrapage;
	}
	
	/**
	 * To get the external Page
	 * @return the extPage
	 */
	
	public int getExtPage() {
		//to do something
		return extPage;
	}
	
	/**
	 * To set the external page
	 * @param extPage 
	 */
	
	public void setExtPage(int extPage) {
		this.extPage = extPage;
	}
	
	/**
	 * To get the intrasite
	 * @return the intrasite
	 */
	
	public int getIntrasite() {
		return intrasite;
	}
	
	/**
	 * Set the intrasite
	 * @param intrasite 
	 */
	
	public void setIntrasite(int intrasite) {
		this.intrasite = intrasite;
	}
	
	/**
	 * To get the external site
	 * @return the extSite
	 */
	
	public int getExtSite() {
		return extSite;
	}
	
	/**
	 * Set the external site
	 * @param extSite the extSite to set
	 */
	
	public void setExtSite(int extSite) {
		this.extSite = extSite;
	}
	
	/**
	 * To get the internal resource
	 * @return the intResource
	 */
	public int getIntResource() {
		return intResource;
	}
	
	/**
	 * Set the internal resource
	 * @param intResource 
	 */
	
	public void setIntResource(int intResource) {
		this.intResource = intResource;
	}
	
	/**
	 * To get the external resource
	 * @return the extResource
	 */
	
	public int getExtResource() {
		return extResource;
	}
	
	/**
	 * Set the external resource
	 * @param extResource 
	 */
	
	public void setExtResource(int extResource) {
		this.extResource = extResource;
	}
	
	/**
	 * To get the broken links
	 * @return the broken
	 */
	
	public int getBroken() {
		return broken;
	}
	
	/**
	 * Set the broken links
	 * @param broken 
	 */
	
	public void setBroken(int broken) {
		this.broken = broken;
	}
	
	/**
	 * To get the reference of pages by an array
	 * @return the references
	 */
	
	public ArrayList<String> getReferences() {
		return references;
	}
	
	/**
	 * Set the reference of pages by an array
	 * @param references
	 */
	public void setReferences(ArrayList<String> references) {
		this.references = references;
	}
	
	/**
	 * To get the referred pages links by an array
	 * @return the referencedBy
	 */
	
	public ArrayList<String> getReferencedBy() {
		return referencedBy;
	}
	
	/**
	 * Set the referred pages links by an array
	 * @param referencedBy 
	 */
	
	public void setReferencedBy(ArrayList<String> referencedBy) {
		this.referencedBy = referencedBy;
	}
	
	/**
	 * To get the added reference pages
	 * @param other
	 */
	
	public void addToReferences(String other)
	{
		references.add(other);		
	}
	
	/**
	 * Set the added reference pages
	 * @param other
	 */
	
	public void addToReferencedBy(String other)
	{
		referencedBy.add(other);
	}
}
