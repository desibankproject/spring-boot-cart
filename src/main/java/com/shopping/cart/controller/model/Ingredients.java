package com.shopping.cart.controller.model;

public class Ingredients {
	private String name;
	private String percentage;
	
	public Ingredients(){
	}
	
	public Ingredients(String name, String percentage) {
		this.name = name;
		this.percentage = percentage;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage
	 *            the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ingredients [name=" + name + ", percentage=" + percentage + "]";
	}

}
