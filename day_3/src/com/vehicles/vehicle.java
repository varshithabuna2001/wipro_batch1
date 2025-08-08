package com.vehicles;

public class vehicle {
	int tyres;
	String fueltype;
	String colour;
	
	
	public vehicle(int tyres, String fueltype, String colour) {
		super();
		this.tyres = tyres;
		this.fueltype = fueltype;
		this.colour = colour;
	}
	
	public vehicle() {
		super();
	}

	public int getTyres() {
		return tyres;
	}
	public void setTyres(int tyres) {
		this.tyres = tyres;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "vehicle [tyres=" + tyres + ", fueltype=" + fueltype + ", colour=" + colour + "]";
	}
	
	

}
