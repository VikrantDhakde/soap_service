package com.viva.bean;

public class Expression {
	
	private double num1;
	private double num2;
	private String operator;
	private double result;
	private String description;
	
	public Expression() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expression(double num1, double num2, String operator) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;

	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Expression [num1=" + num1 + ", num2=" + num2 + ", operator=" + operator + ", result=" + result
				+ ", description=" + description + "]";
	}
	
	
	
}
