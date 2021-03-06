package com.kh.somoim.util.event;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.kh.somoim.view.club.clubHome.clubBoard.ClubFree;
import com.kh.somoim.view.club.clubMain.ClubMainPanel;
import com.kh.somoim.view.home.CreateClubPanel;
import com.kh.somoim.view.main.CenterPanel;
import com.kh.somoim.view.main.MainPanel;
import com.kh.somoim.view.mainFrame.MainFrame;
import com.kh.somoim.view.search.SearchPanel;

public class ChangPanelUtil {

	private MainFrame mainFrame;
	private JPanel oldPanel;

	


	public ChangPanelUtil(MainFrame mainFrame, JPanel oldPanel) {
		super();
		this.mainFrame = mainFrame;
		this.oldPanel = oldPanel;
	}

	
	public static void CHANGE_PANEL(MainFrame mainFrame, JPanel oldPanel, JPanel newPanel) {
		mainFrame.remove(oldPanel);
		mainFrame.add(newPanel);
		mainFrame.repaint();
		mainFrame.setVisible(true);
	}

	public static void CHANGE_PANEL(JPanel clubmainPanel, JPanel oldPanel, JPanel newPanel, String Layout) {
		clubmainPanel.remove(oldPanel);
		clubmainPanel.add(newPanel, Layout);
		clubmainPanel.revalidate();
		clubmainPanel.repaint();
	}
	
	public static void CHANGE_PANEL(JPanel clubmainPanel, JPanel oldPanel, JPanel newPanel) {
		clubmainPanel.remove(oldPanel);
		clubmainPanel.add(newPanel);
		clubmainPanel.revalidate();
		clubmainPanel.repaint();
	}
	
	public static void CHANGE_PANEL2(JPanel clubmainPanel, JPanel oldPanel, JPanel newPanel, String Layout) {
		clubmainPanel.remove(oldPanel);
		clubmainPanel.add(newPanel, Layout);
		clubmainPanel.revalidate();
		clubmainPanel.repaint();
	}


	public static void CHANGE_PANEL2(JPanel thisPanel, JScrollPane oldScroll, JPanel newPanel) {
		// TODO Auto-generated method stub
		thisPanel.remove(oldScroll);
		thisPanel.add(newPanel);
		thisPanel.repaint();
		thisPanel.revalidate();
	}

}





