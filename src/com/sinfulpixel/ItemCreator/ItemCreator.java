package com.sinfulpixel.ItemCreator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ItemCreator {

	private JFrame frmRpcoreItemCreator;
	public static JTextField txtName;
	public static JTextField txtDesc;
	public static JTextField txtMat1Name;
	public static JTextField txtMat1Amnt;
	public static JTextField txtMat2Name;
	public static JTextField txtMat3Amnt;
	public static JTextField txtMat3Name;
	public static JTextField txtMat2Amnt;
	public static JTextField txtMat4Amnt;
	public static JTextField txtMat4Name;
	public static JTextField txtMat5Name;
	public static JTextField txtMat5Amnt;
	public static JTextField txtLow;
	public static JTextField txtHigh;
	public static JComboBox<?> cbItem;
	public static JComboBox<?> cbMat1;
	public static JComboBox<?> cbMat2;
	public static JComboBox<?> cbMat3;
	public static JComboBox<?> cbMat4;
	public static JComboBox<?> cbMat5;
	public static JComboBox<?> cbToolReq;
	public static JComboBox<?> cbStation;
	public static JList<?> listCreated;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Strings.popMaterials();
					Strings.createFile();
					Strings.popItems();
					ItemCreator window = new ItemCreator();
					window.frmRpcoreItemCreator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ItemCreator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frmRpcoreItemCreator = new JFrame();
		frmRpcoreItemCreator.setTitle("RP-Core Item Creator v1.0");
		frmRpcoreItemCreator.setBounds(100, 100, 761, 626);
		frmRpcoreItemCreator.addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent event){
				if(JOptionPane.showConfirmDialog(frmRpcoreItemCreator,
					"Would You Like to Save First?",
					"Save?",JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
					try{Strings.saveFile();}catch(Exception e){}
					System.exit(0);
				}else{
					System.exit(0);
				}
			}
		});
		frmRpcoreItemCreator.getContentPane().setLayout(null);
		listCreated = new JList<Object>(Strings.model);
		listCreated.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Strings.clearForm();
				try{Strings.popForm(listCreated.getSelectedValue().toString());}catch(Exception e){}
			}
		});
		listCreated.setBorder(new LineBorder(new Color(0, 0, 0)));
		listCreated.setBounds(482, 38, 254, 522);
		frmRpcoreItemCreator.getContentPane().add(listCreated);
		
		JLabel lblCreatedItems = new JLabel("Created Items:");
		lblCreatedItems.setBounds(482, 13, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(lblCreatedItems);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(10, 38, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblItemName);
		
		txtName = new JTextField();
		txtName.setBounds(147, 35, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblItemDescription = new JLabel("Item Description:");
		lblItemDescription.setBounds(10, 65, 114, 14);
		frmRpcoreItemCreator.getContentPane().add(lblItemDescription);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(147, 62, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtDesc);
		
		JLabel lblItemMaterial = new JLabel("Item Texture:");
		lblItemMaterial.setBounds(10, 90, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblItemMaterial);
		
		cbItem = new JComboBox<Object>(Strings.materials.toArray());
		cbItem.setBounds(147, 87, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbItem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 115, 462, 2);
		frmRpcoreItemCreator.getContentPane().add(separator);
		
		JLabel lblRequiredMaterialsTo = new JLabel("Required Materials to Craft Items:");
		lblRequiredMaterialsTo.setBounds(72, 120, 216, 14);
		frmRpcoreItemCreator.getContentPane().add(lblRequiredMaterialsTo);
		
		JLabel lblMaterial = new JLabel("Material 1: ");
		lblMaterial.setBounds(10, 147, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial);
		
		cbMat1 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat1.setBounds(147, 144, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat1);
		
		JLabel lblMaterial_1 = new JLabel("Material 2:");
		lblMaterial_1.setBounds(10, 200, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial_1);
		
		cbMat2 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat2.setBounds(147, 197, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat2);
		
		JLabel lblMaterial_2 = new JLabel("Material 3: ");
		lblMaterial_2.setBounds(10, 253, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial_2);
		
		cbMat3 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat3.setBounds(147, 250, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat3);
		
		JLabel lblMaterial_3 = new JLabel("Material 4:");
		lblMaterial_3.setBounds(10, 309, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial_3);
		
		cbMat4 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat4.setBounds(147, 306, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat4);
		
		JLabel lblMaterial_4 = new JLabel("Material 5:");
		lblMaterial_4.setBounds(10, 365, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial_4);
		
		cbMat5 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat5.setBounds(147, 362, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 416, 472, 5);
		frmRpcoreItemCreator.getContentPane().add(separator_1);
		
		JLabel lblCustomItemName = new JLabel("Custom Item Name:");
		lblCustomItemName.setBounds(10, 172, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(lblCustomItemName);
		
		txtMat1Name = new JTextField();
		txtMat1Name.setBounds(147, 169, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat1Name);
		txtMat1Name.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(351, 150, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(lblAmount);
		
		txtMat1Amnt = new JTextField();
		txtMat1Amnt.setBounds(408, 147, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat1Amnt);
		txtMat1Amnt.setColumns(10);
		
		JLabel label = new JLabel("Custom Item Name:");
		label.setBounds(10, 225, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(label);
		
		txtMat2Name = new JTextField();
		txtMat2Name.setColumns(10);
		txtMat2Name.setBounds(147, 222, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat2Name);
		
		JLabel label_1 = new JLabel("Amount:");
		label_1.setBounds(351, 256, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(label_1);
		
		txtMat3Amnt = new JTextField();
		txtMat3Amnt.setColumns(10);
		txtMat3Amnt.setBounds(408, 253, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat3Amnt);
		
		JLabel label_2 = new JLabel("Custom Item Name:");
		label_2.setBounds(10, 281, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(label_2);
		
		txtMat3Name = new JTextField();
		txtMat3Name.setColumns(10);
		txtMat3Name.setBounds(147, 278, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat3Name);
		
		JLabel label_3 = new JLabel("Amount:");
		label_3.setBounds(351, 203, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(label_3);
		
		txtMat2Amnt = new JTextField();
		txtMat2Amnt.setColumns(10);
		txtMat2Amnt.setBounds(408, 200, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat2Amnt);
		
		JLabel label_4 = new JLabel("Amount:");
		label_4.setBounds(351, 312, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(label_4);
		
		txtMat4Amnt = new JTextField();
		txtMat4Amnt.setColumns(10);
		txtMat4Amnt.setBounds(408, 309, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat4Amnt);
		
		JLabel label_5 = new JLabel("Custom Item Name:");
		label_5.setBounds(10, 337, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(label_5);
		
		txtMat4Name = new JTextField();
		txtMat4Name.setColumns(10);
		txtMat4Name.setBounds(147, 334, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat4Name);
		
		JLabel label_6 = new JLabel("Custom Item Name:");
		label_6.setBounds(10, 391, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(label_6);
		
		txtMat5Name = new JTextField();
		txtMat5Name.setColumns(10);
		txtMat5Name.setBounds(147, 388, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat5Name);
		
		JLabel label_7 = new JLabel("Amount:");
		label_7.setBounds(351, 368, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(label_7);
		
		txtMat5Amnt = new JTextField();
		txtMat5Amnt.setColumns(10);
		txtMat5Amnt.setBounds(408, 365, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat5Amnt);
		
		JLabel lblItemInformation = new JLabel("Item Information:");
		lblItemInformation.setBounds(72, 13, 234, 14);
		frmRpcoreItemCreator.getContentPane().add(lblItemInformation);
		
		JLabel lblRequiredWorkstation = new JLabel("Other Information:");
		lblRequiredWorkstation.setBounds(72, 424, 180, 14);
		frmRpcoreItemCreator.getContentPane().add(lblRequiredWorkstation);
		
		JLabel lblWorkstation = new JLabel("Workstation:");
		lblWorkstation.setBounds(10, 446, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblWorkstation);
		
		cbStation = new JComboBox<Object>(Strings.stations);
		cbStation.setBounds(147, 443, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbStation);
		
		JLabel lblSpecialChance = new JLabel("Special Chance (Low/High):");
		lblSpecialChance.setBounds(10, 502, 154, 14);
		frmRpcoreItemCreator.getContentPane().add(lblSpecialChance);
		
		txtLow = new JTextField();
		txtLow.setBounds(254, 496, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtLow);
		txtLow.setColumns(10);
		
		JLabel label_8 = new JLabel("/");
		label_8.setBounds(295, 499, 14, 14);
		frmRpcoreItemCreator.getContentPane().add(label_8);
		
		txtHigh = new JTextField();
		txtHigh.setColumns(10);
		txtHigh.setBounds(299, 496, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtHigh);
		
		JButton btnCreateItem = new JButton("Create Item");
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{Strings.saveFile();Strings.popItems();Strings.clearForm();}catch(Exception e){e.printStackTrace();}
			}
		});
		btnCreateItem.setBounds(147, 527, 114, 23);
		frmRpcoreItemCreator.getContentPane().add(btnCreateItem);
		
		JLabel lblToolRequired = new JLabel("Tool Required:");
		lblToolRequired.setBounds(10, 471, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblToolRequired);
		
		cbToolReq = new JComboBox<Object>(Strings.tools);
		cbToolReq.setBounds(147, 468, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbToolReq);
		
		JMenuBar menuBar = new JMenuBar();
		frmRpcoreItemCreator.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Save First?","Warning",dialogButton);
				if(dialogResult==0){
					try{Strings.saveFile();}catch(Exception ex){}
					System.exit(0);
				}else{
				 System.exit(0);
				}
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmInformation = new JMenuItem("Information");
		mntmInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,Strings.information,"About QuestGUI",JOptionPane.NO_OPTION);
			}
		});
		mnAbout.add(mntmInformation);
	}
}
