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
import com.kh.somoim.search.controller.SearchController;
import com.kh.somoim.util.event.HoemPanelKeyEventUtil;
import com.kh.somoim.view.main.CenterPanel;
import com.kh.somoim.view.main.MainPanel;
import com.kh.somoim.view.mainFrame.MainFrame;

public class FavoriteSearchClubList extends JPanel {

	JLabel [] FavoriteSearchClubList = null;

	public FavoriteSearchClubList(MainFrame mainFrame, CenterPanel centerpanel, MainPanel mainpanel, String favorite) {
		SearchController searchController = new SearchController();
		ArrayList<ClubVO> searchClubList = searchController.getFavoriteSearchClubList(favorite);

		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());

		JPanel favoriteSearchClubPanel = new JPanel();
		favoriteSearchClubPanel.setLayout(null);
		favoriteSearchClubPanel.setPreferredSize(new Dimension(500, 100 * searchClubList.size()));

		int x = -1;
		int y = 0;
		FavoriteSearchClubList = new JLabel[searchClubList.size()];

		for(int i = 0; i<searchClubList.size(); i++) {
			FavoriteSearchClubList[i] = new JLabel();
			FavoriteSearchClubList[i].setBounds(x, y, 500, 100);
			FavoriteSearchClubList[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
			//�Ҹ��� Ÿ��Ʋ �̹��� 
			Image originTitleImage = new ImageIcon(searchClubList.get(i).getTitleImagePath()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			Image resizeTitleImage = originTitleImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

			JLabel titleImageLabel = new JLabel(new ImageIcon(resizeTitleImage));
			titleImageLabel.setBounds(15,5,90,90);

			//ī�װ��� �̹��� 
			JLabel categoryImageLabel = new JLabel(new ImageIcon(resizeTitleImage));
			categoryImageLabel.setBounds(120,10,20,20);

			//�Ҹ��� �̸� 
			JLabel clubNameLabel = new JLabel();
			clubNameLabel.setText(searchClubList.get(i).getName());
			clubNameLabel.setBounds(120,35,250,30);
			clubNameLabel.setFont(clubNameLabel.getFont().deriveFont(18.0f));

			//�Ҹ��� ���� ���� 
			JLabel clubMeetingDayLabel = new JLabel();
			clubMeetingDayLabel.setBounds(120,70,150,20);

			Date meetingDay = searchClubList.get(i).getMeetingDay();
			Calendar nowDay = Calendar.getInstance();

			//���� 00:00:00 ���� �����ϱ� ���� Year Month Date ���� 
			int year = nowDay.get(Calendar.YEAR);
			int month = nowDay.get(Calendar.MONTH);
			int date = nowDay.get(Calendar.DATE);
			Date nowDate = new Date(new GregorianCalendar(year, month, date).getTimeInMillis());

			// ���� ��¥�� �̷��� ��� �� �߰�  
			if(meetingDay.getTime() >= nowDate.getTime()) {
				String meetingString = "���� ���� : ";
				long diffDate = meetingDay.getTime() - nowDate.getTime();
				int day = (int) (diffDate / 1000 / 60 / 60 / 24);

				/* ����, ����, �𷹸� ������ ��¥�� ��¥�� ǥ��  */
				switch (day) {
				case 0:
					meetingString += "����";
					break;
				case 1:
					meetingString += "����";
					break;
				case 2:
					meetingString += "��";
					break;
				default:
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String meetingday = sdf.format(meetingDay.getTime());
					meetingString += meetingday;
					break;
				}
				clubMeetingDayLabel.setText(meetingString);
				FavoriteSearchClubList[i].add(clubMeetingDayLabel);
			}

			//�Ҹ��� �ο� ��
			JLabel clubMemberCountLabel = new JLabel();
			clubMemberCountLabel.setText(searchClubList.get(i).getMembersNumber().size() + "��");
			clubMemberCountLabel.setBounds(420,25,50,50);
			clubMemberCountLabel.setFont(clubMemberCountLabel.getFont().deriveFont(15.0f));

			FavoriteSearchClubList[i].add(titleImageLabel);
			FavoriteSearchClubList[i].add(categoryImageLabel);
			FavoriteSearchClubList[i].add(clubNameLabel);
			FavoriteSearchClubList[i].add(clubMemberCountLabel);

			favoriteSearchClubPanel.add(FavoriteSearchClubList[i]);

			//���� ��ǥ ��ġ����
			y += 100;
		}

		favoriteSearchClubPanel.setBackground(Color.WHITE);
		JScrollPane clubDetailListScroll = new JScrollPane(favoriteSearchClubPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		clubDetailListScroll.getVerticalScrollBar().setUnitIncrement(16);
		clubDetailListScroll.setPreferredSize(new Dimension(500,100));
		this.add(clubDetailListScroll);

		//�� �̺�Ʈ 
		for(int i=0; i<FavoriteSearchClubList.length; i++) {
			FavoriteSearchClubList[i].addMouseListener(new HoemPanelKeyEventUtil(mainFrame, mainpanel, FavoriteSearchClubList, i, searchClubList.get(i)));
		}
	}
}