package es.deusto.ingenieria.sd.sms.client.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import es.deusto.ingenieria.sd.sms.client.controller.SMSController;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;

public class SMSWindow extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	
	// Variables declaration - do not modify
	private javax.swing.JTextField acronym = new javax.swing.JTextField();
	private javax.swing.JButton buttonCloseP = new javax.swing.JButton();
	private javax.swing.JButton buttonSend = new javax.swing.JButton();
	private javax.swing.JButton buttonReport = new javax.swing.JButton();
	private javax.swing.JButton buttonLimit = new javax.swing.JButton();
	private javax.swing.JButton buttonForbidden = new javax.swing.JButton();
	private javax.swing.JButton buttonNewP = new javax.swing.JButton();
	private javax.swing.JButton buttonOptions = new javax.swing.JButton();
	private javax.swing.JTextField description = new javax.swing.JTextField();
	private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	private javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
	private javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
	private javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
	private javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
	private javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
	private javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
	private javax.swing.JTextField limit = new javax.swing.JTextField();
	private javax.swing.JList<String> tvProgsList1 = new javax.swing.JList<String>();
	private javax.swing.JList<String> tvProgsList2 = new javax.swing.JList<String>();
	private javax.swing.JTextField options = new javax.swing.JTextField();
	private javax.swing.JTextField forbiddenWords = new javax.swing.JTextField();
	private javax.swing.JPanel panelButton = new javax.swing.JPanel();
	private javax.swing.JPanel panelButtonsP1 = new javax.swing.JPanel();
	private javax.swing.JPanel panelPrograms = new javax.swing.JPanel();
	private javax.swing.JPanel panelControlP = new javax.swing.JPanel();
	private javax.swing.JPanel panelControlM = new javax.swing.JPanel();
	private javax.swing.JPanel panelListTvP1 = new javax.swing.JPanel();
	private javax.swing.JPanel panelListTvP2 = new javax.swing.JPanel();
	private javax.swing.JPanel panelMessages = new javax.swing.JPanel();
	private javax.swing.JPanel panelRForbidden = new javax.swing.JPanel();
	private javax.swing.JPanel panelRMaximum = new javax.swing.JPanel();
	private javax.swing.JPanel panelROptions = new javax.swing.JPanel();
	private javax.swing.JPanel panelPhone = new javax.swing.JPanel();
	private javax.swing.JPanel panelText = new javax.swing.JPanel();
	private javax.swing.JPanel panelbClose = new javax.swing.JPanel();
	private javax.swing.JScrollPane scrollTVProgs1 = new javax.swing.JScrollPane();
	private javax.swing.JScrollPane scrollTVProgs2 = new javax.swing.JScrollPane();
	private javax.swing.JScrollPane scrollText = new javax.swing.JScrollPane();
	private javax.swing.JTabbedPane tabsTable = new javax.swing.JTabbedPane();
	private javax.swing.JTextField phone = new javax.swing.JTextField();
	private javax.swing.JTextArea text = new javax.swing.JTextArea();
	private javax.swing.DefaultListModel<String> tvProgsList = new DefaultListModel<String>();
	// End of variables declaration

	// Data from the server
	private List<TVProgramDTO> tvProgDTO = new ArrayList<TVProgramDTO>();
	private SMSController controller;

	public SMSWindow(SMSController controller) {
		this.controller = controller;
		initComponents();	
		setSize(725, 425);
		initialListLoad(controller.getTVPrograms());
		this.setSize(800, 600);
		this.setVisible(true);
		this.centreWindow();
	}

	private void initComponents() {
		getContentPane().setLayout(new java.awt.GridLayout(2, 1));		
		setTitle("SMS Window");
		setName("SMS Window");
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm(evt);
			}
		});

		tvProgsList1.setModel(tvProgsList);
		tvProgsList2.setModel(tvProgsList);
		
		panelPrograms.setLayout(new java.awt.GridLayout(1, 2));
		panelPrograms.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "TV Program Section"));
		
		panelListTvP1.setLayout(new java.awt.BorderLayout());
		panelListTvP1.setBorder(new javax.swing.border.TitledBorder("TV Program List"));
		scrollTVProgs1.setPreferredSize(new java.awt.Dimension(100, 110));
		
		tvProgsList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		scrollTVProgs1.setViewportView(tvProgsList1);
		panelListTvP1.add(scrollTVProgs1, java.awt.BorderLayout.CENTER);

		buttonReport.setText("Report");
		buttonReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonReportActionPerformed(evt);
			}
		});

		panelbClose.add(buttonReport);
		buttonCloseP.setText("Close");
		buttonCloseP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonClosePActionPerformed(evt);
			}
		});
		panelbClose.add(buttonCloseP);
		panelListTvP1.add(panelbClose, java.awt.BorderLayout.SOUTH);
		panelPrograms.add(panelListTvP1);
		panelControlP.setLayout(new java.awt.BorderLayout());
		panelControlP.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.TitledBorder(""), "TV Program Settings"));
		jLabel3.setText("Message Limit:");
		panelRMaximum.add(jLabel3);

		limit.setColumns(5);
		panelRMaximum.add(limit);

		buttonLimit.setText("Add");
		buttonLimit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonLimitActionPerformed(evt);
			}
		});

		panelRMaximum.add(buttonLimit);
		tabsTable.addTab("Maximum #", panelRMaximum);
		jLabel2.setText("Options: ");
		panelROptions.add(jLabel2);
		options.setColumns(15);
		panelROptions.add(options);
		buttonOptions.setText("Add");
		buttonOptions.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonOptionsActionPerformed(evt);
			}
		});

		panelROptions.add(buttonOptions);
		tabsTable.addTab("Valid Options", panelROptions);
		jLabel1.setText("Words: ");
		panelRForbidden.add(jLabel1);
		forbiddenWords.setColumns(15);
		panelRForbidden.add(forbiddenWords);
		buttonForbidden.setText("Add");
		buttonForbidden.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonForbiddenActionPerformed(evt);
			}
		});

		panelRForbidden.add(buttonForbidden);
		tabsTable.addTab("Forbidden Words", panelRForbidden);
		panelControlP.add(tabsTable, java.awt.BorderLayout.CENTER);
		jLabel5.setText("Acron:");
		panelButtonsP1.add(jLabel5);
		acronym.setColumns(3);
		panelButtonsP1.add(acronym);
		jLabel4.setText("Desc:");
		panelButtonsP1.add(jLabel4);
		description.setColumns(10);
		panelButtonsP1.add(description);
		buttonNewP.setText("New");
		buttonNewP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonNewPActionPerformed(evt);
			}
		});

		panelButtonsP1.add(buttonNewP);
		panelControlP.add(panelButtonsP1, java.awt.BorderLayout.SOUTH);
		panelPrograms.add(panelControlP);
		getContentPane().add(panelPrograms);
		panelMessages.setLayout(new java.awt.GridLayout(1, 2));
		panelMessages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Message Section"));
		panelListTvP2.setLayout(new java.awt.BorderLayout());
		panelListTvP2.setBorder(new javax.swing.border.TitledBorder("Available TV Programs"));
		scrollTVProgs2.setPreferredSize(new java.awt.Dimension(100, 110));
		tvProgsList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tvProgsList2.setFocusable(false);
		tvProgsList2.setEnabled(false);
		scrollTVProgs2.setViewportView(tvProgsList2);
		panelListTvP2.add(scrollTVProgs2, java.awt.BorderLayout.CENTER);
		panelMessages.add(panelListTvP2);
		
		panelControlM.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.TitledBorder(""), "Message Sending"));
		//panelPhone.setPreferredSize(new java.awt.Dimension(320, 30));
		jLabel9.setText("Phone #: ");
		//jLabel9.setPreferredSize(new java.awt.Dimension(75, 16));
		panelPhone.add(jLabel9);
		phone.setColumns(20);
		panelPhone.add(phone);
		panelControlM.add(panelPhone, java.awt.BorderLayout.NORTH);
		panelText.setPreferredSize(new java.awt.Dimension(320, 60));
		jLabel6.setText("Text: ");
		//jLabel6.setPreferredSize(new java.awt.Dimension(75, 16));
		panelText.add(jLabel6);
		text.setColumns(20);
		text.setLineWrap(true);
		text.setRows(3);
		scrollText.setViewportView(text);
		panelText.add(scrollText);
		panelControlM.add(panelText, java.awt.BorderLayout.CENTER);
		panelButton.setPreferredSize(new java.awt.Dimension(320, 36));
		buttonSend.setText("Send");
		buttonSend.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSendActionPerformed(evt);
			}
		});

		panelButton.add(buttonSend);
		panelControlM.add(panelButton, java.awt.BorderLayout.SOUTH);
		panelMessages.add(panelControlM);
		getContentPane().add(panelMessages);
		pack();
	}
	
	public void centreWindow() {
		Dimension dim = getToolkit().getScreenSize();
		Rectangle abounds = getBounds();
		setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
	}	

	private void buttonNewPActionPerformed(java.awt.event.ActionEvent evt) {
		String ac = acronym.getText().trim().toUpperCase();
		String des = description.getText().trim().toUpperCase();
		//Calling the Controller
		if (!ac.isEmpty() && !des.isEmpty()) {
			controller.newTVProgram(ac, des);
			TVProgramDTO tvp = new TVProgramDTO(ac, des);
			this.updateLists(tvp);
			this.cleanProgramDetails();
		}
	}

	private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {
		// Calling the Controller		
		if (!phone.getText().trim().isEmpty() && !text.getText().trim().isEmpty()) {
			controller.sendMessage(phone.getText().trim().toUpperCase(), text.getText().trim().toUpperCase());
			this.cleanMessageDetails();
		}
	}

	private void buttonReportActionPerformed(java.awt.event.ActionEvent evt) {

		// ADD YOUR CODE HERE
	
	}

	private void buttonForbiddenActionPerformed(java.awt.event.ActionEvent evt) {

		// ADD YOUR CODE HERE
	
	}

	private void buttonOptionsActionPerformed(java.awt.event.ActionEvent evt) {

		// ADD YOUR CODE HERE
		
	}

	private void buttonLimitActionPerformed(java.awt.event.ActionEvent evt) {

		// ADD YOUR CODE HERE
		
	}

	private void buttonClosePActionPerformed(java.awt.event.ActionEvent evt) {
		// Calling the controller		
		if (tvProgsList1.getSelectedIndex() >= 0) {
			TVProgramDTO tvProgram = (TVProgramDTO) tvProgDTO.get(tvProgsList1.getSelectedIndex());
			controller.closeTVProgram(tvProgram.getAcronym());
			this.removeFromList(tvProgram);
		}
	}

	private void exitForm(java.awt.event.WindowEvent evt) {
		controller.exit();
	}

	// METHODS FOR DATA DISPLAY IN THE GUI WINDOW

	private void updateLists(TVProgramDTO tvp) {
		tvProgDTO.add(tvp);
		tvProgsList.clear();
		
		for (TVProgramDTO program : tvProgDTO) {
			tvProgsList.addElement(program.getAcronym() + " - " + program.getDescription());
		}
		
		if (!tvProgsList.isEmpty()) {
			tvProgsList1.setSelectedIndex(0);
		}
	}

	private void removeFromList(TVProgramDTO tvp) {
		tvProgDTO.remove(tvp);
		tvProgsList.clear();
		
		for (int i = 0; i < tvProgDTO.size(); i++) {
			TVProgramDTO p = (TVProgramDTO) tvProgDTO.get(i);
			tvProgsList.addElement(p.getAcronym() + " - " + p.getDescription());
		}
		
		if (!tvProgsList.isEmpty()) {
			tvProgsList1.setSelectedIndex(0);
		}
	}

	private void initialListLoad(List<TVProgramDTO> pro) {
		tvProgDTO = pro;
		tvProgsList.clear();
		
		for (int i = 0; i < tvProgDTO.size(); i++) {
			TVProgramDTO p = (TVProgramDTO) tvProgDTO.get(i);
			tvProgsList.addElement(p.getAcronym() + " - " + p.getDescription());
		}
		
		if (!tvProgsList.isEmpty()) {
			tvProgsList1.setSelectedIndex(0);
		}
	}

	private void cleanProgramDetails() {
		limit.setText("");
		options.setText("");
		forbiddenWords.setText("");
		description.setText("");
		acronym.setText("");
	}

	private void cleanMessageDetails() {
		phone.setText("");
		text.setText("");
	}
}