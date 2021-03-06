package com.kh.somoim.view.search;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.kh.somoim.home.model.vo.ClubVO;
import com.kh.somoim.login.model.vo.MemberVO;
import com.kh.somoim.search.controller.SearchController;
import com.kh.somoim.util.event.HoemPanelKeyEventUtil;
import com.kh.somoim.view.main.CenterPanel;
import com.kh.somoim.view.main.MainPanel;
import com.kh.somoim.view.mainFrame.MainFrame;

public class FavoriteSearchClubList extends JPanel {

	JLabel [] clubDetailLabel  = null;

	public FavoriteSearchClubList(MainFrame mainFrame, CenterPanel centerpanel, SearchPanel searchPanle, MainPanel mainpanel, String favorite, MemberVO memberVO) {
		SearchController searchController = new SearchController();
		ArrayList<ClubVO> searchClubList = searchController.getFavoriteSearchClubList(favorite);
		this.setLayout(null);
		this.setLocation(22, 80); //위치
		this.setSize(450,580); //크기
		this.setBackground(Color.BLUE);

		this.setLayout(new BorderLayout());

		JPanel favoriteSearchClubPanel = new JPanel();
		favoriteSearchClubPanel.setLayout(null);
		favoriteSearchClubPanel.setPreferredSize(new Dimension(500, 100 * searchClubList.size()));

		int x = -1;
		int y = 0;
		clubDetailLabel = new JLabel[searchClubList.size()];

		for(int i=0; i<searchClubList.size(); i++) {
			clubDetailLabel[i] = new JLabel();
			clubDetailLabel[i].setBounds(x, y, 500, 100);
			clubDetailLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

			// 소모임 타이틀 이미지 
			Image originTitleImage = new ImageIcon(searchClubList.get(i).getTitleImagePath()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			Image resizeTitleImage = originTitleImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

			JLabel titleImageLabel = new JLabel(new ImageIcon(resizeTitleImage));
			titleImageLabel.setBounds(15,5,90,90);

			// 카테고리 이미지 
			String Category = searchClubList.get(i).getCategory();
			String dir = "";
			
			switch (Category) {
			case "게임/오락":
				dir = "images/game.png"; break;
			case "결혼/육아": dir = "images/parenting.png"; break;
			case "공예/만들기": dir = "images/crafts.png"; break;
			case "댄스/무용": dir = "images/dance.png"; break;
			case "반려동물": dir = "images/pet.png"; break;
			case "봉사활동": dir = "images/volunteer.png"; break;
			case "사교/인맥": dir = "images/society.png"; break;
			case "아웃도어/여행": dir = "images/travel.png"; break;
			case "요리": dir = "images/cooking.png"; break;
			case "운동/스포츠": dir = "images/exercise.PNG"; break;
			case "음악/악기": dir = "images/music.png"; break;
			case "차/오토바이": dir = "images/carmotorcycle.png"; break;
			}
			
			Image originCategoryImage = new ImageIcon(dir).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			Image resizeCategoryImage = originCategoryImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			JLabel categoryImageLabel = new JLabel(new ImageIcon(resizeCategoryImage));
			categoryImageLabel.setBounds(120,10,20,20);

			// 소모임 이름 
			JLabel clubNameLabel = new JLabel();
			clubNameLabel.setText(searchClubList.get(i).getName());
			clubNameLabel.setBounds(120,35,250,30);
			clubNameLabel.setFont(clubNameLabel.getFont().deriveFont(18.0f));

			//	 소모임 정모 정보 
			JLabel clubMeetingDayLabel = new JLabel();
			clubMeetingDayLabel.setBounds(120,70,150,20);

			Date meetingDay = searchClubList.get(i).getMeetingDay();
			Calendar nowDay = Calendar.getInstance();

			//	 오늘 00:00:00 으로 세팅하기 위해 Year Month Date 설정 
			int year = nowDay.get(Calendar.YEAR);
			int month = nowDay.get(Calendar.MONTH);
			int date = nowDay.get(Calendar.DATE);
			Date nowDate = new Date(new GregorianCalendar(year, month, date).getTimeInMillis());

			// 미팅 날짜가 미래일 경우 라벨 추가 로직 
			if(meetingDay.getTime() >= nowDate.getTime()) {
				String meetingString = "다음 정모 : ";
				long diffDate = meetingDay.getTime() - nowDate.getTime();
				int day = (int) (diffDate / 1000 / 60 / 60 / 24);

				//	 오늘, 내일, 모레를 제외한 날짜는 날짜로 표시  
				switch (day) {
				case 0:
					meetingString += "오늘";
					break;
				case 1:
					meetingString += "내일";
					break;
				case 2:
					meetingString += "모레";
					break;
				default:
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String meetingday = sdf.format(meetingDay.getTime());
					meetingString += meetingday;
					break;
				}
				clubMeetingDayLabel.setText(meetingString);
				clubDetailLabel[i].add(clubMeetingDayLabel);
			}

			// 소모임 인원 수 
			JLabel clubMemberCountLabel = new JLabel();
			clubMemberCountLabel.setText(searchClubList.get(i).getMembersNumber().size() + "명");
			clubMemberCountLabel.setBounds(390,25,50,50);
			clubMemberCountLabel.setFont(clubMemberCountLabel.getFont().deriveFont(15.0f));

			clubDetailLabel[i].add(titleImageLabel);
			clubDetailLabel[i].add(categoryImageLabel);
			clubDetailLabel[i].add(clubNameLabel);
			clubDetailLabel[i].add(clubMemberCountLabel);

			favoriteSearchClubPanel.add(clubDetailLabel[i]);

			// 세로 좌표 위치지정 
			y += 100;
		}

		favoriteSearchClubPanel.setBackground(Color.WHITE);
		JScrollPane clubDetailListScroll = new JScrollPane(favoriteSearchClubPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		clubDetailListScroll.getVerticalScrollBar().setUnitIncrement(16);
		clubDetailListScroll.setPreferredSize(new Dimension(500,100));
		this.add(clubDetailListScroll);
		//라벨 이벤트 
		for(int i=0; i<clubDetailLabel .length; i++) {
			clubDetailLabel [i].addMouseListener(new HoemPanelKeyEventUtil(mainFrame, mainpanel, clubDetailLabel, i, searchClubList.get(i), memberVO));
		}
	}
}
