package com.intuit.martech.MarketPlace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vkhanna
 *
 */
public class Seller {

	private int id;
	private String name;
	private List<Project> projects;
	
	/**
	 * 
	 */
	public Seller() {
		this.id = 0;
		this.name = "";
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Seller(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
		if (this.projects == null) {
			this.projects = new ArrayList<Project>();
		}
		this.projects.add(project);
	}

}
