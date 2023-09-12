package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader {

	static final String FILENAME="D:\\naver0829/memo1.txt";

	public static void main(String[] args) throws IOException {

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);		//줄단위로 읽는 멤버 메소드가 없음 / 그래서 2차 생성을 함
			br = new BufferedReader(fr);

			//br.readLine() : 한줄씩 읽는다. 그런데 더 이상 읽을 수 없으면 null값을 반환
			//대부분 2줄 이상이고 몇출이 저장되어 있는지 알 수 없으므로 while문으로 처리한다

			while (true) {
				//파일의 내용을 한줄씩 읽는다
				String line = br.readLine();
				//더 이상 읽을 내용이 없을 경우 while문을 종료한다
				if(line==null) break;
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			//해당 파일이 없을 경우 예외가 발생하며 catch 영역이 실행된다
			System.out.println("해당 파일을 찾을 수 없음"+e.getMessage());
		}

		//열려있는 자원들을 닫는다(열려진 역순으로 닫는다)
		br.close();
		fr.close();
	}

}
