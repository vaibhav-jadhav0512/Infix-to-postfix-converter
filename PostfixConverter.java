import java.util.Stack; 
class infixToPostfix 
{
	
	private static int precedence=0;
	
	static String infixToPostfix(String str)
	{
		String result =new String("");

		Stack<Character> stack= new Stack<>();

		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);

			if(operatorCheck(c)==0)
				result += c;

			else if (c == '(') 
                		stack.push(c); 

			else if(c==')')
			{
				while(!stack.isEmpty() && stack.peek() != '(')
				result += stack.pop();

				stack.pop();
			}
			else
			{
				while(!stack.isEmpty() && operatorPrecedence(c) <= operatorPrecedence(stack.peek()))
				{
					result +=stack.pop();				

				}	
					stack.push(c);
			}

			
		}
		
		while (!stack.isEmpty()){ 
            		if(stack.peek() == '(') 
                	return "Invalid Expression"; 
            		result += stack.pop(); 
         } 
        	 System.out.println(result);

		return "0";

			
	
	}
	

	public static int operatorCheck(char c)
	{
		if(c=='+'||c=='-'||c=='*'||c=='/'||c=='%'||c=='^')
		{
			return 1;
		}
		else 
			return 0;
	}

	public static int operatorPrecedence(char c)
	{
		if(c=='^')
		precedence=4;
		else if(c=='/'||c=='*'||c=='%')
		precedence=3;
		else if(c=='+'||c=='-')
		precedence=2;
		else
		precedence=1;

		return precedence;
	}

}



public class PostfixConverter
{
	public static void main(String args[])
	{
    		String str = "k+l-m*n+(o^p)*w/u/v*t+q"; 
		infixToPostfix i1=new infixToPostfix();
         	i1.infixToPostfix(str);
		
 	}
}