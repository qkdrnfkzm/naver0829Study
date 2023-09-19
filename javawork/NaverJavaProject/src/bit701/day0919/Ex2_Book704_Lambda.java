package bit701.day0919;

@FunctionalInterface
interface CalcInter {
	double calc(double x, double y);

}

class Perseon {
	public void action(CalcInter cal) {
		double result = cal.calc(10, 4);
		System.out.println("결과=" + result);
	}
}

public class Ex2_Book704_Lambda {
	public static void main(String[] args) {
		Perseon p = new Perseon();

		// 실행문이 2개인 경우
		p.action((x, y) -> {
			double result = x + y;
			return result;
		});

		// 위 호출문과 같은 로직 처리
		// 리턴 코드가 한줄일 경우 return 생략 가능
		p.action((x, y) -> (x + y));
	}
}
