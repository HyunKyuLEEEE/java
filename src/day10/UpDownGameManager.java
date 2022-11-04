package day10;

import java.util.Scanner;

public class UpDownGameManager {

	public static void main(String[] args) {
		/* UpDown 게임을 구현하세요.
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * */
		int menu;
		Record [] records = new Record[5];
		// 메뉴 출력
		do {
		printMenu(
				"-------------",
				"메뉴",
				"1. 플레이",
				"2. 기록확인",
				"3. 종료",
				"-------------",
				"메뉴 선택 : "
				);
		// 메뉴 선택
		menu = selectMenu();
		// 선택한 메뉴에 따른 기능 실행
			// 플레이
				// 랜덤수 생성
				// 반복
					// 사용자 입력
					// Up Down 판별
				// 기존 기록보다 좋으면 기록을 추가
			// 기록확인
				// 기록된 순위를 출력
			// 종료
		runMenu(menu, records);
		// 반복문을 통해 메뉴 출력
		}while(menu != 3);
	}
	
	public static void runMenu(int menu, Record[] records) {
		switch(menu) {
		case 1:
			int min = 1,max =100;
			int r = random(min, max);
			System.out.println(min + " ~ " + max + "사이의 랜덤한 수를 맞추세요.");
			
			int num = min-1;
			Scanner sc = new Scanner(System.in);
			int tryCount = 0;
			do {
				// 1. 숫자를 입력허세요. : 안내문구 출력
				System.out.print("숫자를 입력하세요. : ");
				// 2. 정수를 입력 받음
				num = sc.nextInt();
				// 3. 입력받은 정수가 r과 같으면 정답입니다.라고 출력하고
				if(r == num) {
					System.out.println("정답입니다.");
				}else if(r < num) {
					//입력받은 정수가 r보다 크면 DOWN이라고 출력하고
					System.out.println("Down");
				}else{
					//아니면 UP이라고 출력한다
					System.out.println("Up");
				}
				tryCount++;
			}while(r != num);
			
			int maxRecordCount = getMaxRecordCount(records);
			int maxRecordRank = getMaxRecordRank(records);
			if(maxRecordCount > tryCount || maxRecordRank < 5){
				addRecord(records, tryCount);
			}
			break;
		case 2:
			printRecords(records);
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	private static void printRecords(Record[] records) {
		for(int i = 0; i < records.length ; i++) {
			System.out.print(i + 1 + "위 ");
			if(records[i] != null) {
				records[i].print();
			}else {
				System.out.println();
			}
		}
	}
	
	private static void addRecord(Record[] records, int tryCount) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력(예 : LHK) : ");
		String name = sc.next();
		Record r = new Record(tryCount, name);
		int index = 0;
		for(Record record : records) {
			if(record != null && record.getCount() < tryCount) {
				index++;
			}
		}
		for(int i = records.length - 1; i > index; i--) {
			records[i] = records[i - 1];
		}
		records[index] = r;
	}
	
	private static int getMaxRecordRank(Record[] records) {
		int rank = 0;
		for(Record record : records ) {
			if(record != null) {
				rank++;
			}
		}
		return rank;
	}
	
	private static int getMaxRecordCount(Record[] records) {
		int count = 9999999;
		for(Record record : records) {
			if(record != null) {
				count = record.getCount();
			}
		}
		
		return count;
	}
	
	public static int random(int min, int max) {
		if(min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return (int)(Math.random()*(max - min + 1) + min);
	}
	
	/**
	 * 메뉴를 콘솔에서 입력받아 돌려주는 메소드
	 * @return 입력받은 메소드
	 */
	private static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	/**
	 * 메뉴를 출력하는 메소드로, 마지막 메뉴는 엔터를 안친다.
	 * @param strs 콘솔에 출력할 메뉴들
	 */
	private static void printMenu(String ... strs) {
		for(int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + (i != strs.length - 1 ?"\n" : ""));
		}
	}
	
}