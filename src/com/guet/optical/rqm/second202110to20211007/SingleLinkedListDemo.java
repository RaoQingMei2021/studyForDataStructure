package com.guet.optical.rqm.second202110to20211007;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /**
        * ���Դ���
        */
		//�����ڵ�  
		HeroNode heroNode1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode heroNode2 = new HeroNode(2,"¬����","������");
		HeroNode heroNode3 = new HeroNode(3,"����","�Ƕ���");
		HeroNode heroNode4 = new HeroNode(4,"�ֳ�","����ͷ");
		
		//����
		//��������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		//����

		singleLinkedList.add1(heroNode2);
		singleLinkedList.add1(heroNode1);
		singleLinkedList.add1(heroNode3);
		singleLinkedList.add1(heroNode4);
		//��ʾ
		singleLinkedList.list();
		System.out.println("*************����Ϊ��Ӻ�˳���������ӷ����Ĳ���***************");
		//����
		//��������
		SingleLinkedList singleLinkedList1 = new SingleLinkedList();
		singleLinkedList1.add2(heroNode2);
		singleLinkedList1.add2(heroNode1);
		singleLinkedList1.add2(heroNode3);
		singleLinkedList1.add2(heroNode4);
		
		
		/**
		 * �����޸�����Ĵ���
		 */
		System.out.println("*******�����޸Ĵ���**********");
		HeroNode newHeroNode=new HeroNode(2,"С¬","������~~~");
		singleLinkedList1.update(newHeroNode);
		//��ʾ
		singleLinkedList1.list();
		
		
		/**
		 * ����ɾ���ڵ㷽���Ĵ���
		 */
//		singleLinkedList1.del(1);//����ɾ����һ����һ������������ڵ�һ���Լ����һ����
//		singleLinkedList1.del(2); 
//		System.out.println("**********ɾ������б�**********");
//		singleLinkedList1.list();
		
		/**
		 * ���Ե��������Ч�ڵ����
		 */
		System.out.println("��Ч�Ľڵ����Ϊ��"+getLength(singleLinkedList1.getHead()));
		/**
		 * ���Ի�ȡ������k���ڵ�Ĵ���
		 */
		System.out.println("**************���Ի�ȡ������k���ڵ�Ĵ���************");
		HeroNode res=findLastIndexNode(singleLinkedList.getHead(),2);
		System.out.println("res="+res);
		
		/**
		 * ��������ķ�ת�Ĵ���
		 */
		System.out.println("*********��������ת�Ĵ���********"); 
		System.out.println("*********��ת֮ǰ������********"); 
//		SingleLinkedList reverseList=reverseLinkedList(singleLinkedList1);
//		reverseList.list();
		singleLinkedList1.list();
		System.out.println("*********��ת֮�������********"); 
		reverseList(singleLinkedList1.getHead());
		singleLinkedList1.list();
		
		
		/**
		 * ��������ջʵ������������ӡ
		 */
		System.out.println("*********���Ե�����������ӡ��δ�ı�������Ľṹ��************");
		reversePrint(singleLinkedList1.getHead());
	}
	/**
	 * ��ʽ2��������**ջ**������ݽṹ���������ڵ�ѹ�뵽ջ�У�Ȼ������ջ���Ƚ�������ص�ʵ�������ӡ��Ч��
	 * ʵ������������ӡ
	 */
	public static void reversePrint(HeroNode head) {
		if(head.next==null){//Ϊ������
			System.out.println("Ϊ�������޷���ӡ~");
			return;
		}
		//����һ��ջ���������ڵ�ѹ��ջ��
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur=head.next;
		//����������нڵ�ѹ��ջ��
		while(cur!=null) {
			stack.push(cur);
			cur=cur.next;//cur����
		}
		//��ջ�еĽڵ��ӡ
		while(stack.size()>0){
			System.out.println(stack.pop());
		}
	}
	
	
	/**
	 * ����ķ������
	 */
/**	//�Լ�д�ģ�����������
	public static SingleLinkedList reverseLinkedList(SingleLinkedList list) {
		SingleLinkedList reverseList=new SingleLinkedList();
		HeroNode reverseHead=reverseList.getHead();
		HeroNode head=list.getHead();
		HeroNode temp=head.next;
		while(!(temp==null)) {//δ������ԭ��������
			//temp=temp.next;
			temp.next=reverseHead.next;
			reverseHead.next=temp;
			temp=temp.next;
		}
		return reverseList;
	}
*/	
	//��Ƶ������
	public static  void reverseList(HeroNode head) {
		//�����ǰ����Ϊ�գ�����ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���
		if(head.next==null||head.next.next==null) {
			return;
		}
		//���帨����ָ��/��������������ԭ��������
		HeroNode cur=head.next;
		HeroNode next=null;//ָ��ǰ�ڵ�cur����һ���ڵ�
		HeroNode reverseHead=new HeroNode(0,"","");
		//����ԭ�����б�ÿ����һ���ڵ㣬�ͽ���ȡ�����������µ�����reverseHead����ǰ��
		while(cur!=null) {//cur����Ϊ�� 
			next=cur.next;//����ʱ���浱ǰ�ڵ����һ���ڵ㣬��Ϊ������Ҫʹ��
			cur.next=reverseHead.next;//��cur����һ���ڵ�ָ���µ��������ǰ��
			reverseHead.next=cur;//��cur���ӵ��µ�������
			cur=next;//��cur����
		}
		//��head.nextָ��reverseHead.next��ʵ�ֵ�����ķ�ת
		head.next=reverseHead.next;
	}
	
	/**
	 * ���ҵ������еĵ�����k���ڵ�
	 * ˼·
	 * 1����дһ����������head�ڵ㣬��ʾ����һ��index��
	 * 2��index��ʾ���ǵ�����index���ڵ�
	 * 3���Ȱ������ͷ��β�������õ������ܵĳ���getlength
	 * 4���õ�size�󣬴�����ĵڸ���ʼ����size-index��
	 * 5������ҵ��˾ͷ��ظýڵ㣬���򷵻�null
	 */
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		//�жϣ��������Ϊ�գ�����null
		if(head.next==null) {
			return null;//û���ҵ�
		}
		//��һ�α����õ�����ĳ��ȣ��ڵ������
		int size=getLength(head);
		//�ڶ��α���  size-index λ�ã��������ǵ����ĵ�k���ڵ�
		//����һ��index��У��
		if(index<=0||index>size) {
			System.out.println("������Ч����");
			return null;
		}
		//����һ����������,forѭ����λ��������index
		HeroNode cur=head.next;
		for(int i=0;i<size-index;i++) {
			cur=cur.next;
		}
		return cur;
	}
	
     
	/**
	 * ��������ȡ�������е���Ч�ڵ�ĸ���(����Ǵ�=��ͷ�ڵ����������ͳ��ͷ�ڵ�)
	 */
	/**
	 * 
	 * @param head  �����ͷ�ڵ�
	 * @return   ���ص���������Ч�ڵ�ĸ���
	 */
	public static int getLength(HeroNode head) {
		if(head.next==null) {//������
			return 0;
		}
		int length=0;
		//����һ������������û��ͳ��ͷ�ڵ�
		HeroNode cur=head.next;
		while(cur!=null) {
			length++;
			cur=cur.next;
		}
		return length;
	}
}
//����һ��singleLinkedList  ����Ӣ��
class SingleLinkedList{
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻�ܶ������ڱ�����ʱ��Ŀ��ǡ�������ž��������
	private HeroNode head=new HeroNode(0,"","");
	
	 
	//����ͷ�ڵ�
	public HeroNode getHead() {
		return head;
	}

	/**
	 * ��ӽڵ㵽�����б�
	 * �������Ǳ��˳��ʱ��
	 * 1���ҵ���ǰ�б�����ڵ�
	 * 2�����������ڵ��nextָ���µĽڵ�
	 * 
	 * �÷���Ϊ���Ǳ��˳�򡾴���ʵ�ֵĿ����ǣ�����˳���ţ���˳����ʾ�������������ı�ţ�����ʵ��Ӧ����Ϣ��
	 */
	public void add1(HeroNode heroNode) {
		//��Ϊhead�ڵ㲻�ܶ��������Ҫ�����ڵ㣬����������temp
		HeroNode temp=head;
		//���������ҵ����ڵ�
		while(true){
			if(temp.next==null) {
				//�ҵ���������
				break;	
			}
            //���û���ҵ���next��������
			temp=temp.next;			
		}
		//���˳�whileѭ��ʱ��temp��ָ����������
		temp.next=heroNode;
	}
	
	/**
	 * ��ӵĵڶ��ַ�������˳����ӣ�����Ѿ�����ĳһ��ţ�����ʾ��Ӧ����Ϣ
	 * 
	 * 1�������ҵ�����ӵĽڵ��λ�á�ͨ��������������ָ��ĸ������ƣ��ҵ����ص㣬ͨ�������ҵ���
	 * 2���µĽڵ�.next=temp.next
	 * 3����temp.next=�µĽڵ�
	 */
	public void add2(HeroNode heroNode) {
		//��Ϊͷ�ڵ㲻�ܶ�������ͨ��������ָ�루�������ҵ���ӵ�λ��
		//��Ϊ�ǵ�������Ϊ�ҵ���temp��λ�����λ�õ�ǰһ���ڵ㣬�����벻��
	   HeroNode temp=head;
	   boolean flag=false;//��־��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
	   while(true) {
		   if(temp.next==null) {//˵��temp�Ѿ�����������
			   break;
		   }
		   if(temp.next.no>heroNode.no) {//λ���ҵ��ˣ�λ�þ���temp�������temp�ȽϵĻ�������temp��ű�Ҫ�����С������ʱ�޷�����temp����һ���ڵ�ı�ű�Ҫ����Ĵ�
			   break;
		   }else if(temp.next.no==heroNode.no) {//˵��ϣ����ӵ�heroNode�ı���Ѿ�����
			   flag=true;//˵����Ŵ���
			   break;
		   }
		   temp=temp.next;//���ƣ�������ǰ����
	   }
	   //�ж�flag��ֵ��=
	   if(flag) {//������ӣ�˵����Ŵ���
		   System.out.printf("׼�������Ӣ�۵ı��%d�Ѿ����ڣ��������\n",heroNode.no);
	   }else {
		   //���뵽�����У�temp����
		   heroNode.next=temp.next;
		   temp.next=heroNode;
	   }
	}
	/**
	 * ���ݱ���޸Ľڵ����Ϣ�����涨��Ų����޸�
	 * ���ݽڵ�ı���޸ģ��ڵ���ΪnewHeroNode  ���Ϊno
	 */
	public void update(HeroNode newHeroNode) {
		//�ж��Ƿ�Ϊ��
		if(head.next==null) {
			System.out.println("����Ϊ�գ���");
		}
		//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
		//����һ����������
		HeroNode temp=head.next;
		boolean flag=false;//��ʾ�Ƿ��ҵ��ڵ�
		while(true) {
			if(temp==null) {
				break;//�����������Ѿ�����������
			}
			if(temp.no==newHeroNode.no) {
				//�ҵ�
				flag=true;
				break;
			}
			temp=temp.next;
		}
		//����flag�ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if(flag) {
			temp.name=newHeroNode.name;
			temp.nickname=newHeroNode.nickname;
		}else {//û���ҵ���Ҫ�޸ĵĽڵ�
			System.out.printf("û���ҵ����%d�Ľڵ�\n",newHeroNode.no);
		}
	}
	
	/**
	 * ɾ���ڵ㣬���ݱ��
	 * ˼·
	 * 1��head�ڵ㲻�ܶ��������Ҫ�����ڵ��ҵ���ɾ���ڵ��ǰһ���ڵ�
	 * 2��˵���ڱȽ�ʱ����temp.next.no����Ҫɾ���Ľڵ��no�Ƚ�
	 */
	public void del(int no) {
		/**
		 * �Լ�д�ġ��߼�©������û����û�ҵ����������д�Ĵ��벻����κ���ʾ��
		 */
//		//���ݱ��ɾ�����������
//		//�鿴�����Ƿ�Ϊ��
//		if(head.next==null) {
//			System.out.println("����Ϊ�գ���");
//		}
//		HeroNode temp =head;
//		//��������
//		while(true) {
//			if(temp.next==null) {
//				break;
//			}
//			if(temp.next.no==no) {
//				temp.next=temp.next.next;
//				break;
//			}
//			temp=temp.next;
//		}
		/**
		 * ��Ƶ������
		 */
		HeroNode temp=head;
		boolean flag=false;//��־�Ƿ��ҵ���ɾ���Ľڵ�
		while(true) {
			if(temp.next==null) {//�Ѿ�����������
				break;
			}
			if(temp.next.no==no) {
				//�ҵ��ĵĴ�ɾ���Ľڵ��ǰһ���ڵ�
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {//�ҵ�
			//����ɾ��
			temp.next=temp.next.next;
		}else {
			System.out.printf("Ҫɾ���Ľڵ�%d������\n",no);
		}
	}
	
	/**
	 * ��ʾ����
	 */
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next==null) {
			System.out.println("����Ϊ�գ���");
			return;
		}
		//��Ϊͷ�ڵ㲻�ܶ��������Ҫ����������������
		HeroNode temp=head.next;
		while(true) {
			//�ж��Ƿ�����������
			if(temp==null) {
				break;
			}
			//����ڵ���Ϣ
			System.out.println(temp);
			//��next����
			temp=temp.next;
		}
	}
}

/**
*����HeroNode��ÿ��HeroNode�������һ���ڵ�
*/
class HeroNode{
	public int no;
	public String name;
	public String nickname;//��ʾ�ǳ�
	public HeroNode next;//ָ����һ���ڵ�
	//������
	public HeroNode(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname; 
	}
   //Ϊ����ʾ���㣬��дtoString����
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "HeroNode no="+no+",name="+name+",nickName="+nickname;
	}
	
} 