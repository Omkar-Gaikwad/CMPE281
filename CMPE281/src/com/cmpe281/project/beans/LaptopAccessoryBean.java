package com.cmpe281.project.beans;

public class LaptopAccessoryBean extends ProductBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int accessoryId;
	int laptopId;
	int cover;
	int penDrive;
	int hardDrive;
	int printer;

	public int getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(int accessoryId) {
		this.accessoryId = accessoryId;
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public int getCover() {
		return cover;
	}

	public void setCover(int cover) {
		this.cover = cover;
	}

	public int getPenDrive() {
		return penDrive;
	}

	public void setPenDrive(int penDrive) {
		this.penDrive = penDrive;
	}

	public int getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(int hardDrive) {
		this.hardDrive = hardDrive;
	}

	public int getPrinter() {
		return printer;
	}

	public void setPrinter(int printer) {
		this.printer = printer;
	}

}
