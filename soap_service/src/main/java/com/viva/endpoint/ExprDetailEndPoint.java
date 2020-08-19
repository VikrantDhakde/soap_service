package com.viva.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.myexpr.expr.ExpresionResult;
import com.myexpr.expr.GetExprResultRequest;
import com.myexpr.expr.GetExprResultResponse;
import com.viva.bean.Expression;
import com.viva.exception.NotAProperExpression;
import com.viva.service.ExprDetailService;

@Endpoint
public class ExprDetailEndPoint {
	
	@Autowired
	private ExprDetailService service;
	
	@PayloadRoot(namespace = "http://myexpr.com/expr",localPart = "GetExprResultRequest")
	@ResponsePayload
	public GetExprResultResponse processGetExprResultRequest(@RequestPayload GetExprResultRequest request) {
		if(request.getNum1()==0 || request.getNum2()==0)
			throw new NotAProperExpression("Please Enter valid Expression");
		Expression expr=service.processExpression(request.getNum1(),request.getNum2(), request.getOperator());
		return mapExpressionDetail(expr);
		
	}

	private GetExprResultResponse mapExpressionDetail(Expression expression) {
		GetExprResultResponse response = new GetExprResultResponse();
		response.setExpresionResult(mapExpressionResult(expression));
		return response;
	}
	
	
	private ExpresionResult mapExpressionResult(Expression expr) {
		ExpresionResult exprResult=new ExpresionResult();
		exprResult.setNum1(expr.getNum1());
		exprResult.setNum2(expr.getNum2());
		exprResult.setOperator(expr.getOperator());
		exprResult.setResult(expr.getResult());
		exprResult.setDescription(expr.getDescription());
		return exprResult;
	}

}
