package edu.isistan.garbagerecycler.dto;

import java.io.Serializable;

public class Recycling implements Serializable{
	
	private static final long serialVersionUID = 3605549122072628877L;
	
	private float tons;
	
	private int bottles;
	
	private int tetrabriks;
	
	private int glass;
	
	private int paperboard;
	
	private int cans;
	
	public Recycling() {
		
	}

	
	public Recycling(float tons, int bottles, int tetrabriks, int glass, int paperboard, int cans) {
		super();
		this.tons = tons;
		this.bottles = bottles;
		this.tetrabriks = tetrabriks;
		this.glass = glass;
		this.paperboard = paperboard;
		this.cans = cans;
	}

	public float getTons() {
		return tons;
	}

	public void setTons(float tons) {
		this.tons = tons;
	}

	public int getBottles() {
		return bottles;
	}

	public void setBottles(int bottles) {
		this.bottles = bottles;
	}

	public int getTetrabriks() {
		return tetrabriks;
	}

	public void setTetrabriks(int tetrabriks) {
		this.tetrabriks = tetrabriks;
	}

	public int getGlass() {
		return glass;
	}

	public void setGlass(int glass) {
		this.glass = glass;
	}

	public int getPaperboard() {
		return paperboard;
	}

	public void setPaperboard(int paperboard) {
		this.paperboard = paperboard;
	}

	public int getCans() {
		return cans;
	}

	public void setCans(int cans) {
		this.cans = cans;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
