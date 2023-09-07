package bit701.day0906;

import java.util.Iterator;

public class Ex14_ArrayStringSort {

	public static void main(String[] args) {

		String[] names = {"한가인","강호동","강감찬","Candy","손흥민",};

		//selection sort - 문자열 비교
		for(int i=0;i<names.length-1;i++) 
		{
			for(int j=i;j<names.length;j++) 
			{
				//a.compareTo(b) : a가 b보다 클 경우 무조건 양수값이 나온다
				if(names[i].compareTo(names[j])>0)	//오름차순, 부등호를 바꾸면 내림차순
				{
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
			}
		}
		for (String s:names) {
			System.out.println(s);
		}

	}

}
