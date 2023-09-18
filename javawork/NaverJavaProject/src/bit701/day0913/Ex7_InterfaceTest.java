package bit701.day0913;

import java.util.Scanner;

interface Board{
	public void process();
}

//총 4개의 sub 클래스 구현
class Insert implements Board{
	@Override
	public void process() {
		System.out.println("새 글을 작성하였습니다");
	}
}
class Delete implements Board{
	@Override
	public void process() {
		System.out.println("글을 삭제 하였습니다");
	}
}
class Update implements Board{
	@Override
	public void process() {
		System.out.println("글을 수정하였습니다");
	}
}
class List implements Board{
	@Override
	public void process() {
		System.out.println("글 목록을 출력합니다");
	}
}


public class Ex7_InterfaceTest {

	public static void process(Board b) {
		b.process();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		Board b = null;

		Exit:
			while(true) {
				System.out.println("1. 글쓰기\t2.글삭제\t3.글수정\t4.글목록\t5.종료\n선택>");
				num=Integer.parseInt(sc.nextLine());

				switch (num) {
				case 1: {
					b=new Insert();
					break;
				}
				case 2: {
					b=new Delete();
					break;
				}
				case 3: {
					b=new Update();
					break;
				}
				case 4: {
					b=new List();
					break;
				}
				default:
					System.out.println("게시판 관리 종료");
					break Exit;
				}
				process(b);
				System.out.println();
			}
	}
}
