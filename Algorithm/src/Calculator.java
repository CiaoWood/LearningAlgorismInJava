import java.util.*;

public class Calculator {
	//private String inputStr;
	private Stack<String> ops = new Stack<String>();
	private Stack<Double> val = new Stack<Double>();
	
	public Double inputStart(){
		System.out.println("Please input:");
		Scanner input = new Scanner(System.in);
		if(input.hasNext()){
			String inputs = input.next();
			for(int i = 0; i < inputs.length(); i++){
				String item = Character.toString(inputs.charAt(i));
				if(item.equals("("));
				else if(item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) ops.push(item);
				else if(item.equals(")")){
					PopCalPush();
				}else{
					Double doubleVal = 0.0;
					try{
						doubleVal = Double.parseDouble(item);
					}catch(Exception ex){
						System.out.println("input must be double value");
						input.close();
						return inputStart();
					}
					val.push(doubleVal);
				}
			}
			
		}
		input.close();
		
		while(val.size() > 1){
			PopCalPush();
		}
		
		return val.pop();
	}
	
	public void PopCalPush(){
		String ops1 = ops.pop();
		Double val1 = val.pop();
		if(ops1.equals("+")) val.push(val.pop() + val1);
		else if(ops1.equals("-")) val.push(val.pop() - val1);
		else if(ops1.equals("*")) val.push(val.pop() * val1);
		else if(ops1.equals("/")) val.push(val.pop() / val1);
	}
}
