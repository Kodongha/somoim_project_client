package com.kh.somoim.view.signup;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.kh.somoim.signup.model.vo.SignupRequestVO;
import com.kh.somoim.util.event.ChangPanelUtil;
import com.kh.somoim.view.mainFrame.MainFrame;

public class SubscriptionInformationPanel extends JPanel {
	private JPanel thisPanel;
	SignupRequestVO signupRequestVO;

	public SubscriptionInformationPanel(MainFrame mainFrame, SignupRequestVO signupRequestVO) {
		this.thisPanel = this;
		this.signupRequestVO = signupRequestVO;

		this.setLayout(null);
		this.setBackground(Color.WHITE);
		JPanel result2 = new JPanel();
		result2.setBounds(10, 20, 460, 680);

		JPanel result = new JPanel();
		result.setLayout(new GridLayout(8, 2));
		result.setBounds(50, 100, 350, 400);
		result.setBackground(Color.WHITE);

		JLabel email = new JLabel();
		email.setLocation(10, 50);
		email.setSize(200, 100);

		result.add(new JLabel("                이메일: "));

		JTextField text = new JTextField(15);
		text.setLocation(20, 70);
		text.setSize(100, 100);

		result.add(text);

		JLabel password = new JLabel();
		password.setLocation(10, 80);
		password.setSize(100, 100);
		result.add(new JLabel("                비밀번호:"));

		JPasswordField text2 = new JPasswordField(15);
		text.setLocation(20, 900);
		text.setSize(100, 100);

		result.add(text2);

		JLabel passwordcheck = new JLabel();
		passwordcheck.setLocation(10, 80);
		passwordcheck.setSize(100, 100);
		result.add(new JLabel("                비밀번호 확인:"));

		JPasswordField text3 = new JPasswordField(15);
		text3.setLocation(20, 900);
		text3.setSize(100, 100);

		result.add(text3);

		JLabel name = new JLabel();
		name.setLocation(10, 80);
		name.setSize(100, 100);
		result.add(new JLabel("                이름:"));
		JTextField text4 = new JTextField(15);
		text4.setLocation(20, 900);
		text4.setSize(100, 100);
		text4.setText(signupRequestVO.getName());
		text4.setEditable(false);
		
		result.add(text4);

		JLabel birth = new JLabel();
		birth.setLocation(10, 80);
		birth.setSize(100, 100);
		result.add(new JLabel("                생년월일:"));
		

		
		SpinnerNumberModel numberModel1 = new SpinnerNumberModel(1990, 1930, 2019, 1); // 시작할 값, 최소값, 최대값, 증가값
		JSpinner spinner1 = new JSpinner(numberModel1);
	
		String year = signupRequestVO.getBirth().substring(0, 4);
		spinner1.setValue(Integer.parseInt(year));
		spinner1.setEnabled(false);
		
	
		
		
		
		

		SpinnerNumberModel numberModel2 = new SpinnerNumberModel(1, 1, 12, 1); // 시작할 값, 최소값, 최대값, 증가값
		JSpinner spinner2 = new JSpinner(numberModel2);
		
		String month = signupRequestVO.getBirth().substring(4, 6);
		spinner2.setValue(Integer.parseInt(month));
		spinner2.setEnabled(false);
		//System.out.println("month:::"+month);

		SpinnerNumberModel numberModel3 = new SpinnerNumberModel(1, 1, 31, 1); // 시작할 값, 최소값, 최대값, 증가값
		JSpinner spinner3 = new JSpinner(numberModel3);
		
		String day = signupRequestVO.getBirth().substring(6, 8);
		spinner3.setValue(Integer.parseInt(day));
		spinner3.setEnabled(false);

		JPanel groupPanel2 = new JPanel();
		groupPanel2.add(spinner1);
		groupPanel2.add(spinner2);
		groupPanel2.add(spinner3);
		groupPanel2.setBackground(Color.WHITE);
		result.add(groupPanel2);
		
	
		System.out.println();
		
		JLabel gender = new JLabel("                성별");
		gender.setLocation(10, 80);
		gender.setSize(100, 100);

		result.add(gender);

		JRadioButton man = new JRadioButton("남");
		man.setBackground(Color.WHITE);
		JRadioButton woman = new JRadioButton("여");
		woman.setBackground(Color.WHITE);
		ButtonGroup group = new ButtonGroup();
		group.add(man);
		group.add(woman);
		man.setSelected(true);
		
		JPanel groupPanel = new JPanel();
		groupPanel.add(man);
		groupPanel.add(woman);
		groupPanel.setBackground(Color.WHITE);

		result.add(groupPanel);

		JLabel phonenumber = new JLabel();
		passwordcheck.setLocation(10, 80);
		passwordcheck.setSize(100, 100);
		result.add(new JLabel("                핸드폰 번호:"));

		JTextField text5 = new JTextField(15);
		text5.setLocation(20, 900);
		text5.setSize(100, 100);
		
		text5.setText(signupRequestVO.getPhoneNumber());
		text5.setEditable(false);

		result.add(text5);

		JLabel city = new JLabel();
		birth.setLocation(10, 80);
		birth.setSize(100, 100);
		result.add(new JLabel("                지역:"));

		String[] cities = { "서울", "대전", "대구", "부산", "경기", "강원", "인천", "제주" };

		JComboBox animalList = new JComboBox<>(cities);

		animalList.setBackground(Color.white);
		result.add(animalList);

		JButton next = new JButton("다음");
		next.setBounds(137, 600, 230, 50);
		next.setBackground(Color.ORANGE);
		this.add(next);

		JPanel result3 = new JPanel();
		result3.setBounds(50, 550, 350, 50);
		result3.setBackground(Color.WHITE);

		this.add(result);
		this.add(result3);

		SubscriptionInformationTopPanel subscriptionInformationTopPanel = new SubscriptionInformationTopPanel();
		subscriptionInformationTopPanel.setBounds(0, 0, 500, 35);
		this.add(subscriptionInformationTopPanel);

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signupRequestVO.setId(text.getText());
				signupRequestVO.setEmail(text.getText()); // 이메일
				signupRequestVO.setPassword(String.valueOf(text2.getPassword()));// 비밀번호

				String br = String.valueOf(spinner1.getValue()) // 년
						+ String.format("%02d", Integer.parseInt(spinner2.getValue().toString())) // 월
						+ String.format("%02d", Integer.parseInt(spinner3.getValue().toString())); // 일
				signupRequestVO.setBirth(br);

				String str = String.valueOf(text5.getText()); // 폰
				String phone = str.substring(0, 3) +   str.substring(3, 8) +  str.substring(8, 13); // 폰
				signupRequestVO.setPhoneNumber(phone);
				
				signupRequestVO.setAddress(String.valueOf(animalList.getSelectedItem()));
				signupRequestVO.setName(text4.getText());
				if(man.isSelected()) {
					signupRequestVO.setGender("남");
				} else {
					signupRequestVO.setGender("여");
				}
				
				// signupRequestVO.setAddress(animalList.getItemCount());

				// signupRequestVO.setGender(String.valueOf( gender.) ;
				// signupRequestVO.setPasswordCheck(String.valueOf(text3.getPa`
				/// SimpleDateFormat birth = new SimpleDateFormat("yyyyymmdd");
				// System.out.println(birth.format(date));
				// signupRequestVO.setPhoneNumber(text5.getText);

				// signupRequestVO.setBirth(Integer.parseInt(spinner1.getValue()));
				System.out.println(signupRequestVO.toString());

				ChangPanelUtil.CHANGE_PANEL(mainFrame, thisPanel, new CheckFavorites(mainFrame, signupRequestVO ));

			}
		});

	}
}
