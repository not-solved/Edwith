package kr.or.connect.jdbcExam;

import kr.or.connect.jdbcExam.dto.Card;
import kr.or.connect.jdbcExam.dao.CardDao;
import java.util.*;

public class Project_NameCard {
	
	public static void print() {
		System.out.println("===========================");
		System.out.println("1. 명함 입력");
		System.out.println("2. 명함 검색");
		System.out.println("3. 종료");
		System.out.println("===========================");
	}

	public static void main(String[] args) {
		int menu_select;
		Card card = null;
		List<Card> card_list = null;
		Scanner sc = new Scanner(System.in);
		CardDao dao = new CardDao();
		String name, phone_num, corp_name;
		do {
			print();
			System.out.print("메뉴를 입력하세요 : ");
			menu_select = sc.nextInt();
			switch(menu_select) {
			case 1:
				System.out.print("이름을 입력하세요 : ");
				name = sc.next();
				System.out.print("전화번호를 입력하세요 : ");
				phone_num = sc.next();
				System.out.print("회사 이름을 입력하세요 : ");
				corp_name = sc.next();
				card = new Card(name, phone_num, corp_name);
				dao.Insert(card);
				break;
			case 2:
				System.out.print("검색할 이름을 입력하세요. (like검색) : ");
				name = sc.next();
				card_list = dao.Select(name);
				for(Card temporal_card : card_list)
					System.out.println(temporal_card.toString());
				break;
			case 3:
				System.out.println("프로그램을 종료합니다. :-)");
				break;
			default :
				System.out.println("잘못된 입력입니다.");
			}
			
		} while(menu_select != 3);
		sc.close();
	}
}
