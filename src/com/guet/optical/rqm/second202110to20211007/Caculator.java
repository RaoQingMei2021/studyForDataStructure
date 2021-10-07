package com.guet.optical.rqm.second202110to20211007;

/**
 * 使用基于数组的栈实现计算器
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
public class Caculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 根据思路，完成表达式的计算
		String expression = "70+2*6-4";
		// 创建两个栈：数栈和符号栈
		ArrayStackC numStack = new ArrayStackC(10);// 数栈
		ArrayStackC operStack = new ArrayStackC(10);// 符号栈
		// 定义需要的相关变量
		int index = 0;// 用于扫描
		int num1 = 0;
		int num2 = 0;
		int res = 0;
		int oper = 0;// 操作符
		char ch = ' ';// 将每次扫描得到的char保存到ch
		String keepNum = "";// 用于拼接多位数
		// 开始while循环的扫描expression
		while (true) {
			// 依次得到expression的每一个字符
			ch = expression.substring(index, index + 1).charAt(0);
			// 判断ch是什么，然后做相应的处理
			if (operStack.isOper(ch)) {// 如果是运算符
				// 判断当前符号栈是否为空
				if (!operStack.isEmpty()) {
					// 如果不为空，
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {// 当前操作符的优先级小于等于栈顶的操作符
						// 从数栈中pop出两个数
						num1 = numStack.pop();
						num2 = numStack.pop();
						// 从符号栈中pop出一个操作符
						oper = operStack.pop();
						// 进行运算
						res = numStack.cal(num1, num2, oper);
						// 把运算完的结果放置到数栈中
						numStack.push(res);
						// 入完数栈后，把当前的操作符入操作符栈
						operStack.push(ch);
					} else {// 当前的操作符优先级大于操作符号栈栈顶的操作符号优先级，
							// 就直接入符号栈
						operStack.push(ch);
					}
				} else {// 如果为空，直接入栈
					operStack.push(ch);
				}
			} else {// 如果是数字，则直接入数栈
					// 注意，扫描到的3等其实是字符而不是数字，而字符3的阿斯克编码与数字3的相差48
					// numStack.push(ch-48);

				// 针对“只能进行单位数计算”的问题的完善
				/**
				 * 分析思路 1、当处理多位数时，不能发现时一个数就立即入栈，因为可能是多位数
				 * 2、在处理数时，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈 3、需要定义一个变量 字符串，用于拼接。
				 */
				// 处理多位数
				keepNum += ch;

				if (index == expression.length() - 1) {// 如果ch是expression的最后一位，就直接入栈
					numStack.push(Integer.parseInt(keepNum));
				} else {

					// 判断下一个字符是不是数字，如果是数字，则继续扫描，如果是运算符，则入栈
					// 注意是看index的下一位，不是让index向后移index++
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {// 注意有逻辑漏洞，若检查的为最后一位，则index+2、index+1就会产生错误
						// 若后一位是运算符，则入栈
						numStack.push(Integer.parseInt(keepNum));
						// 重要！！！清空keepNum，否则后面的直接就拼接上，产生错误
						keepNum = "";
					}
				}
			}

			// 让index+1，并判断是否扫描到表达式expression的最后
			index++;
			if (index >= expression.length()) {// 说明扫描结束
				break;
			}
		}
		// 扫描完毕，就将数字栈、符号栈的数据pop
		while (true) {
			// 如果符号栈为空，则计算到最后的结果，数栈中只能有一个结果
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		// 最后将数栈的最后的数pop出就是结果
		System.out.printf("表达式%s=%d", expression, numStack.pop());
	}

}

/**
 * 定义一个类，表示栈 需要扩展功能
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
class ArrayStackC {
	private int maxSize;// 栈的大小
	private int[] stack;// 数组，数组模拟，数据放在该数组中
	private int top = -1;// 表示栈顶，初始化为-1，表示没有数据

	/**
	 * 构造器
	 * 
	 * @param maxSize
	 */
	public ArrayStackC(int maxSize) {
		super();
		this.maxSize = maxSize;
		stack = new int[this.maxSize];// 数组必须初始化才能往里放数据
	}

	/**
	 * 返回当前栈顶的值，但不是真正的pop
	 * 
	 * @return
	 */
	public int peek() {
		return stack[top];
	}

	/**
	 * 判断是否栈满
	 * 
	 * @return
	 */
	public boolean isFull() {
		return top == maxSize - 1;
	}

	/**
	 * 判断栈空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * 入栈操作
	 * 
	 * @param value
	 */
	public void push(int value) {
		// 判断栈满
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}

	/**
	 * 出栈操作
	 * 
	 * @return
	 */
	public int pop() {
		// 先判断栈是否空
		if (isEmpty()) {
			// 抛出异常
			throw new RuntimeException("栈空，无数据可出栈");// 与使用return的区别？【如果使用return停止该方法的运行，就没有返回值，会报错】
		}
		int value = stack[top];
		top--;
		return value;
	}

	/**
	 * 遍历栈，显示栈
	 */
	public void list() {
		// 判断是否栈空
		if (isEmpty()) {
			System.out.println("栈空，无数据~");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

	// 以下为针对实现计算器新添加的方法
	/**
	 * 返回运算符的优先级，优先级是程序员确定；优先级使用数字表示 设：数字越大，优先级越高
	 * 
	 * @param oper
	 * @return
	 */
	public int priority(int oper) {// oper表示传进来的操作符 char与int可以混用
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;// 假定目前的表达式中只有加减乘除
		}
	}

	/**
	 * 判断是不是应该运算符
	 * 
	 * @param val
	 * @return
	 */
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	/**
	 * 计算的方法
	 * 
	 * @param num1
	 * @param num2
	 * @param oper
	 * @return
	 */
	public int cal(int num1, int num2, int oper) {// oper表示操作符
		int res = 0;// 用于存放计算的结果
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;// 注意顺序
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;// 注意顺序
			break;
		default:
			break;
		}
		return res;
	}
}