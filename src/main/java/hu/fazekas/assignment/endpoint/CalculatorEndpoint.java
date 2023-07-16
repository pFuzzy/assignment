package hu.fazekas.assignment.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.baeldung.springsoap.gen.AddNumbersRequest;
import com.baeldung.springsoap.gen.AddNumbersResponse;
import com.baeldung.springsoap.gen.DivideNumbersRequest;
import com.baeldung.springsoap.gen.DivideNumbersResponse;
import com.baeldung.springsoap.gen.MultiplyNumbersRequest;
import com.baeldung.springsoap.gen.MultiplyNumbersResponse;
import com.baeldung.springsoap.gen.SubtractNumbersRequest;
import com.baeldung.springsoap.gen.SubtractNumbersResponse;

import hu.fazekas.assignment.service.CalculatorService;

@Endpoint
public class CalculatorEndpoint {

	
	@Autowired
	CalculatorService calculatorService;
	
	@PayloadRoot(namespace = "http://www.baeldung.com/springsoap/gen", localPart = "addNumbersRequest")
	@ResponsePayload
	public AddNumbersResponse addNumbers(@RequestPayload AddNumbersRequest request) {
		AddNumbersResponse response = new AddNumbersResponse();
		response.setResult(calculatorService.add(request.getA(), request.getB()));
		
		return response;
	}
	
	@PayloadRoot(namespace = "http://www.baeldung.com/springsoap/gen", localPart = "subtractNumbersRequest")
	@ResponsePayload
	public SubtractNumbersResponse subtractNumbers(@RequestPayload SubtractNumbersRequest request) {
		SubtractNumbersResponse response = new SubtractNumbersResponse();
		response.setResult(calculatorService.subtract(request.getA(), request.getB()));
		
		return response;
	}
	
	@PayloadRoot(namespace = "http://www.baeldung.com/springsoap/gen", localPart = "multiplyNumbersRequest")
	@ResponsePayload
	public MultiplyNumbersResponse multiplyNumbers(@RequestPayload MultiplyNumbersRequest request) {
		MultiplyNumbersResponse response = new MultiplyNumbersResponse();
		response.setResult(calculatorService.multiply(request.getA(), request.getB()));
		
		return response;
	}
	
	@PayloadRoot(namespace = "http://www.baeldung.com/springsoap/gen", localPart = "divideNumbersRequest")
	@ResponsePayload
	public DivideNumbersResponse divideNumbers(@RequestPayload DivideNumbersRequest request) {
		DivideNumbersResponse response = new DivideNumbersResponse();
		response.setResult(calculatorService.divide(request.getA(), request.getB()));
		
		return response;
	}
}
