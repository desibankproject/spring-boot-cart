package com.shopping.cart.controller.model;

public class FactorialVO {
	private int num;
	private int result;
	
	public FactorialVO() {
	}
	
	public FactorialVO(int num, int result) {
		this.num = num;
		this.result = result;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "FactorialVO [num=" + num + ", result=" + result + "]";
	}

}
