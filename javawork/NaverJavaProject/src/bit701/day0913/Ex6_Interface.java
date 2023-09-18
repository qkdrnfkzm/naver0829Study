package bit701.day0913;

interface InterJobA{
	public void insertDb();
	public void deleteDb();
}

//interface끼리의 상속은 extends
interface InterJobB extends InterJobA{
	public void selectJob();
	public void updateJob();
}

class JobOne implements InterJobA{

	@Override
	public void insertDb() {
		System.out.println("학생 추가 DB 작업을 수행");
	}

	@Override
	public void deleteDb() {
		System.out.println("학생 제거 DB 작업을 수행");
	}
	
}

class JobTwo implements InterJobB{
	@Override
	public void insertDb() {
		System.out.println("학생 정보 추가");
	}

	@Override
	public void deleteDb() {
		System.out.println("학생 정보 삭제");
	}

	@Override
	public void selectJob() {
		System.out.println("학생 정보 조회");
	}

	@Override
	public void updateJob() {
		System.out.println("학생 정보 수정");
	}
}


public class Ex6_Interface {
	public static void main(String[] args) {
		InterJobA ja = new JobOne();
		ja.insertDb();
		ja.deleteDb();
		System.out.println("------------");
		
		InterJobB jb = new JobTwo();
		jb.insertDb();
		jb.deleteDb();
		jb.selectJob();
		jb.updateJob();
		
	}
}
