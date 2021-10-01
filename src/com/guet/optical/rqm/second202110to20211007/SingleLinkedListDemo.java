package com.guet.optical.rqm.second202110to20211007;

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
		//��ʾ
		singleLinkedList1.list();
	}

}
//����һ��singleLinkedList  ����Ӣ��
class SingleLinkedList{
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻�ܶ������ڱ�����ʱ��Ŀ��ǡ�������ž��������
	private HeroNode head=new HeroNode(0,"","");
	
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