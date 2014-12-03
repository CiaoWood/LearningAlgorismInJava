import java.util.*;

public class Calculator {
	//private String inputStr;
	private Stack<String> ops = new Stack<String>();
	private Stack<Double> val = new Stack<Double>();
	
	public Double inputStart(){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String item = input.next();
			if(item == "(");
			else if(item == "+" || item == "-" || item == "*" || item == "/") ops.push(item);
			else if(item == ")"){
				String ops1 = ops.pop();
				Double val1 = val.pop();
				if(ops1 == "+") val.push(val.pop() + val1);
				else if(ops1 == "-") val.push(val.pop() - val1);
				else if(ops1 == "*") val.push(val.pop() * val1);
				else if(ops1 == "/") val.push(val.pop() / val1);
			}
		}
		return val.pop();
	}
}
