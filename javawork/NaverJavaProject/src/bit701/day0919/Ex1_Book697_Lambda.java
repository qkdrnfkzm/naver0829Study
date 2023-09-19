package bit701.day0919;

@FunctionalInterface // 인터페이스가 함수형으로 구현 가능한지 검증(추상 메소드가 하나인지 여러개인지..)
interface Calculable {
	// 추상 메소드
	public void calculate(int x, int y);
}

public class Ex1_Book697_Lambda {

	public static void action(Calculable calculable) {
		int x = 10;
		int y = 4;
		// 데이터 처리
		calculable.calculate(x, y);
	}

	public static void main(String[] args) {
		action((x, y) -> {
			int result = x + y;
			System.out.println("add result=" + result);
		});
		action((x, y) -> {
			int result = x - y;
			System.out.println("sub result=" + result);
		});
	}
}
