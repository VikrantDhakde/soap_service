package com.viva.service;

import org.springframework.stereotype.Component;

import com.viva.bean.Expression;
import com.viva.exception.NotAProperExpression;
import com.viva.exception.NotDefinedOperator;

@Component
public class ExprDetailService {

	public Expression processExpression(Double num1,Double num2,String operator) {
		Expression processedExpression=new Expression();
		processedExpression.setNum1(num1);
		processedExpression.setNum2(num2);
		processedExpression.setOperator(operator);
		switch (operator) {
		case "+":
			processedExpression.setResult(num1+num2);
			System.out.println(processedExpression.getResult());
			processedExpression.setDescription("Addition done");
			break;
		case "-":
			processedExpression.setResult(num1-num2);
			processedExpression.setDescription("Subtraction done");
			break;
		case "/":
			processedExpression.setResult(num1/num2);
			processedExpression.setDescription("Devide done");
			break;
		case "*":
			processedExpression.setResult(num1*num2);
			processedExpression.setDescription("Multiplication done");
			break;
		default:
			throw new NotDefinedOperator("Operator is not Defined");		
		}
			
		return processedExpression;
	}




}
