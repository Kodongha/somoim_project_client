package com.kh.somoim.view.signup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignUpFinishTopPanel extends JPanel {
	
	public SignUpFinishTopPanel() {
		
		this.setLayout(null);
		this.setBackground(Color.orange);
		this.setPreferredSize(new Dimension(500, 60)); //상단 패널조절
		
		JLabel createLabel = new JLabel(" < 회원 가입 완료");
		createLabel.setForeground(Color.WHITE); //라벨 글씨색변경
		createLabel.setFont(createLabel  //라벨 글씨 크기 조절
				.getFont().deriveFont(15.0f));
		createLabel.setLocation(10, 6);
		
		createLabel.setSize(100, 20);
		this.add(createLabel);
		
		
	}
	
	

}
