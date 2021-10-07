package com.guet.optical.rqm.second202110to20211007;

/**
 * ʹ�û��������ջʵ�ּ�����
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
public class Caculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����˼·����ɱ��ʽ�ļ���
		String expression = "70+2*6-4";
		// ��������ջ����ջ�ͷ���ջ
		ArrayStackC numStack = new ArrayStackC(10);// ��ջ
		ArrayStackC operStack = new ArrayStackC(10);// ����ջ
		// ������Ҫ����ر���
		int index = 0;// ����ɨ��
		int num1 = 0;
		int num2 = 0;
		int res = 0;
		int oper = 0;// ������
		char ch = ' ';// ��ÿ��ɨ��õ���char���浽ch
		String keepNum = "";// ����ƴ�Ӷ�λ��
		// ��ʼwhileѭ����ɨ��expression
		while (true) {
			// ���εõ�expression��ÿһ���ַ�
			ch = expression.substring(index, index + 1).charAt(0);
			// �ж�ch��ʲô��Ȼ������Ӧ�Ĵ���
			if (operStack.isOper(ch)) {// ����������
				// �жϵ�ǰ����ջ�Ƿ�Ϊ��
				if (!operStack.isEmpty()) {
					// �����Ϊ�գ�
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {// ��ǰ�����������ȼ�С�ڵ���ջ���Ĳ�����
						// ����ջ��pop��������
						num1 = numStack.pop();
						num2 = numStack.pop();
						// �ӷ���ջ��pop��һ��������
						oper = operStack.pop();
						// ��������
						res = numStack.cal(num1, num2, oper);
						// ��������Ľ�����õ���ջ��
						numStack.push(res);
						// ������ջ�󣬰ѵ�ǰ�Ĳ������������ջ
						operStack.push(ch);
					} else {// ��ǰ�Ĳ��������ȼ����ڲ�������ջջ���Ĳ����������ȼ���
							// ��ֱ�������ջ
						operStack.push(ch);
					}
				} else {// ���Ϊ�գ�ֱ����ջ
					operStack.push(ch);
				}
			} else {// ��������֣���ֱ������ջ
					// ע�⣬ɨ�赽��3����ʵ���ַ����������֣����ַ�3�İ�˹�˱���������3�����48
					// numStack.push(ch-48);

				// ��ԡ�ֻ�ܽ��е�λ�����㡱�����������
				/**
				 * ����˼· 1���������λ��ʱ�����ܷ���ʱһ������������ջ����Ϊ�����Ƕ�λ��
				 * 2���ڴ�����ʱ����Ҫ��expression�ı��ʽ��index���ٿ�һλ����������ͽ���ɨ�裬����Ƿ��Ų���ջ 3����Ҫ����һ������ �ַ���������ƴ�ӡ�
				 */
				// �����λ��
				keepNum += ch;

				if (index == expression.length() - 1) {// ���ch��expression�����һλ����ֱ����ջ
					numStack.push(Integer.parseInt(keepNum));
				} else {

					// �ж���һ���ַ��ǲ������֣���������֣������ɨ�裬����������������ջ
					// ע���ǿ�index����һλ��������index�����index++
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {// ע�����߼�©����������Ϊ���һλ����index+2��index+1�ͻ��������
						// ����һλ�������������ջ
						numStack.push(Integer.parseInt(keepNum));
						// ��Ҫ���������keepNum����������ֱ�Ӿ�ƴ���ϣ���������
						keepNum = "";
					}
				}
			}

			// ��index+1�����ж��Ƿ�ɨ�赽���ʽexpression�����
			index++;
			if (index >= expression.length()) {// ˵��ɨ�����
				break;
			}
		}
		// ɨ����ϣ��ͽ�����ջ������ջ������pop
		while (true) {
			// �������ջΪ�գ�����㵽���Ľ������ջ��ֻ����һ�����
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		// �����ջ��������pop�����ǽ��
		System.out.printf("���ʽ%s=%d", expression, numStack.pop());
	}

}

/**
 * ����һ���࣬��ʾջ ��Ҫ��չ����
 * 
 * @author Rao'Q'ing'M'ei
 *
 */
class ArrayStackC {
	private int maxSize;// ջ�Ĵ�С
	private int[] stack;// ���飬����ģ�⣬���ݷ��ڸ�������
	private int top = -1;// ��ʾջ������ʼ��Ϊ-1����ʾû������

	/**
	 * ������
	 * 
	 * @param maxSize
	 */
	public ArrayStackC(int maxSize) {
		super();
		this.maxSize = maxSize;
		stack = new int[this.maxSize];// ��������ʼ���������������
	}

	/**
	 * ���ص�ǰջ����ֵ��������������pop
	 * 
	 * @return
	 */
	public int peek() {
		return stack[top];
	}

	/**
	 * �ж��Ƿ�ջ��
	 * 
	 * @return
	 */
	public boolean isFull() {
		return top == maxSize - 1;
	}

	/**
	 * �ж�ջ��
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * ��ջ����
	 * 
	 * @param value
	 */
	public void push(int value) {
		// �ж�ջ��
		if (isFull()) {
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = value;
	}

	/**
	 * ��ջ����
	 * 
	 * @return
	 */
	public int pop() {
		// ���ж�ջ�Ƿ��
		if (isEmpty()) {
			// �׳��쳣
			throw new RuntimeException("ջ�գ������ݿɳ�ջ");// ��ʹ��return�����𣿡����ʹ��returnֹͣ�÷��������У���û�з���ֵ���ᱨ��
		}
		int value = stack[top];
		top--;
		return value;
	}

	/**
	 * ����ջ����ʾջ
	 */
	public void list() {
		// �ж��Ƿ�ջ��
		if (isEmpty()) {
			System.out.println("ջ�գ�������~");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

	// ����Ϊ���ʵ�ּ���������ӵķ���
	/**
	 * ��������������ȼ������ȼ��ǳ���Աȷ�������ȼ�ʹ�����ֱ�ʾ �裺����Խ�����ȼ�Խ��
	 * 
	 * @param oper
	 * @return
	 */
	public int priority(int oper) {// oper��ʾ�������Ĳ����� char��int���Ի���
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;// �ٶ�Ŀǰ�ı��ʽ��ֻ�мӼ��˳�
		}
	}

	/**
	 * �ж��ǲ���Ӧ�������
	 * 
	 * @param val
	 * @return
	 */
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	/**
	 * ����ķ���
	 * 
	 * @param num1
	 * @param num2
	 * @param oper
	 * @return
	 */
	public int cal(int num1, int num2, int oper) {// oper��ʾ������
		int res = 0;// ���ڴ�ż���Ľ��
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;// ע��˳��
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;// ע��˳��
			break;
		default:
			break;
		}
		return res;
	}
}