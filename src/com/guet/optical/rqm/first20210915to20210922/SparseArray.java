package com.guet.optical.rqm.first20210915to20210922;

public class SparseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//����ԭʼ�Ķ�ά����  11*11
		//0����ʾû�����ӣ�1��ʾ����2��ʾ����
		int chessArr1[][]=new int[11][11];
		chessArr1[1][2]=1;
		chessArr1[2][3]=2;
		chessArr1[3][3]=6;
		//���ԭʼ�Ķ�ά����
		System.out.println("**********************ԭʼ�Ķ�ά����**************************");
		for(int[] row:chessArr1) {
			for(int data:row){
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		/**
		 * ��ԭʼ�Ķ�ά����任Ϊϡ������
		 */
		//1������ԭʼ�Ķ�ά���飬�õ���0���ݵĸ���
		int sum=0;
//		for(int i=0;i<11;i++) {
//			for(int j=0;j<11;j++) {
//				if(chessArr1[i][j]!=0) {
//					sum+=1;
//				}
//			}			
//		}
		for(int [] row:chessArr1) {
			for(int k:row ) {
				if(k!=0) { 
					sum+=1;
				}
			}
		}
		System.out.println(sum);
		System.out.println("*****************����ϡ������********************");
		int sparseArr[][]=new int[sum+1][3];
		//��ϡ�����鸳ֵ�������ǵ�һ��
		sparseArr[0][0]=11;
		sparseArr[0][1]=11;
		sparseArr[0][2]=sum;
		
		//������ά���飬����0��ֵ��ŵ�������
		int m=1;//���ڼ�¼�ڼ�����������
		for(int i=0;i<11;i++) {
			for(int j=0;j<11;j++) {
				if(chessArr1[i][j]!=0) {
					sparseArr[m][0]=i;
					sparseArr[m][1]=j;
					sparseArr[m][2]=chessArr1[i][j];
					m++;
				}
			}
		}
		//���ϡ���������ʽ
		/*
		 * for(int[] row:sparseArr) { for(int data:row){ System.out.printf("%d\t",data);
		 * } System.out.println(); }   //���������Ҫ����forѭ��
		 */
		 for(int i=0;i<sparseArr.length;i++){
			 System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]); 
		 }
		 
		 
		 /**
		  * ��ϡ������ָ�Ϊԭʼ����
		  */
		 int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
		 for(int i=1;i<sparseArr.length;i++) { 
				 chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		 }
		 System.out.println("***************�����ϡ������ָ�������ԭʼ����****************");
		 for(int [] row:chessArr2) {
			 for(int data:row) {
				 System.out.printf("%d\t",data);
			 }
			 System.out.println();
		 }
	}
/**
 * �κ�˼������ϡ�����鱣�浽�����У�����map.data���ָ���ԭ��������ʱ��ȡmap.data���лָ�
 */
}
