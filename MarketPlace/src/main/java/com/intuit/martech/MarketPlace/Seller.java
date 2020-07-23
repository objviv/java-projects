package com.intuit.martech.MarketPlace;

import java.util.List;

/**
 * @author vkhanna
 *
 */
public class Seller {

	private String id;
	private String name;
	private List<Project> projects;
	
	/**
	 * 
	 */
	public Seller() {
		this.id = "";
		this.name = "";
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Seller(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	/**
	 * 
	 * @param project
	 */
	public void addProject(Project project) {
		if (this.projects != null) {
			this.projects.add(project);
		}
	}

}
