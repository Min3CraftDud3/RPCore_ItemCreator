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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	public static JComboBox<?> cbItem;
	public static JComboBox<?> cbMat1;
	public static JComboBox<?> cbMat2;
	public static JComboBox<?> cbMat3;
	public static JComboBox<?> cbMat4;
	public static JComboBox<?> cbMat5;
	public static JComboBox<?> cbToolReq;
	public static JComboBox<?> cbStation;
	public static JComboBox<?> cbSp50;
	public static JComboBox<?> cbSp25;
	public static JComboBox<?> cbSp12;
	public static JList<?> listCreated;
	public static JTextField txtSkillLevel;
	public static JComboBox<?> cbSkill;
	public static JComboBox<?> cbCat;
	public static JComboBox<?> cbRarity;
	public static JComboBox<?> cbTier;
	public static JTextField txtDmgMin;
	public static JTextField txtDmgMax;
	public static JTextField txtProtMin;
	public static JTextField txtProtMax;
	public static JTextField txtVSell;
	public static JTextField txtVBuy;
	public static JTextField txtSkUse2Lvl;
	public static JTextField txtSkUse1Lvl;
	public static JComboBox<?> cbSkUse1;
	public static JComboBox<?> cbSkUse2;

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
		frmRpcoreItemCreator.setResizable(false);
		frmRpcoreItemCreator.setTitle("RP-Core Item Creator v1.1");
		frmRpcoreItemCreator.setBounds(100, 100, 761, 722);
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
		listCreated.setBounds(482, 38, 254, 348);
		
		//JScrollPane list = new JScrollPane(listCreated);
		//list.setBounds(482, 38, 254, 528);
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
		lblItemDescription.setBounds(10, 63, 114, 14);
		frmRpcoreItemCreator.getContentPane().add(lblItemDescription);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(147, 60, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtDesc);
		
		JLabel lblItemMaterial = new JLabel("Item Texture:");
		lblItemMaterial.setBounds(10, 88, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblItemMaterial);
		
		cbItem = new JComboBox<Object>(Strings.materials.toArray());
		cbItem.setBounds(147, 85, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbItem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 138, 462, 2);
		frmRpcoreItemCreator.getContentPane().add(separator);
		
		JLabel lblRequiredMaterialsTo = new JLabel("Required Materials to Craft Items:");
		lblRequiredMaterialsTo.setBounds(80, 140, 216, 14);
		frmRpcoreItemCreator.getContentPane().add(lblRequiredMaterialsTo);
		
		JLabel lblMaterial = new JLabel("Material 1: ");
		lblMaterial.setBounds(10, 162, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial);
		
		cbMat1 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat1.setBounds(147, 159, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat1);
		
		JLabel lblMaterial_1 = new JLabel("Material 2:");
		lblMaterial_1.setBounds(10, 215, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial_1);
		
		cbMat2 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat2.setBounds(147, 212, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat2);
		
		JLabel lblMaterial_2 = new JLabel("Material 3: ");
		lblMaterial_2.setBounds(10, 268, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial_2);
		
		cbMat3 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat3.setBounds(147, 265, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat3);
		
		JLabel lblMaterial_3 = new JLabel("Material 4:");
		lblMaterial_3.setBounds(10, 324, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial_3);
		
		cbMat4 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat4.setBounds(147, 321, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat4);
		
		JLabel lblMaterial_4 = new JLabel("Material 5:");
		lblMaterial_4.setBounds(10, 380, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblMaterial_4);
		
		cbMat5 = new JComboBox<Object>(Strings.materials.toArray());
		cbMat5.setBounds(147, 377, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbMat5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 434, 735, 2);
		frmRpcoreItemCreator.getContentPane().add(separator_1);
		
		JLabel lblCustomItemName = new JLabel("Custom Item Name:");
		lblCustomItemName.setBounds(10, 187, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(lblCustomItemName);
		
		txtMat1Name = new JTextField();
		txtMat1Name.setBounds(147, 184, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat1Name);
		txtMat1Name.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(351, 165, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(lblAmount);
		
		txtMat1Amnt = new JTextField();
		txtMat1Amnt.setBounds(408, 162, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat1Amnt);
		txtMat1Amnt.setColumns(10);
		
		JLabel label = new JLabel("Custom Item Name:");
		label.setBounds(10, 240, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(label);
		
		txtMat2Name = new JTextField();
		txtMat2Name.setColumns(10);
		txtMat2Name.setBounds(147, 237, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat2Name);
		
		JLabel label_1 = new JLabel("Amount:");
		label_1.setBounds(351, 271, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(label_1);
		
		txtMat3Amnt = new JTextField();
		txtMat3Amnt.setColumns(10);
		txtMat3Amnt.setBounds(408, 268, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat3Amnt);
		
		JLabel label_2 = new JLabel("Custom Item Name:");
		label_2.setBounds(10, 296, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(label_2);
		
		txtMat3Name = new JTextField();
		txtMat3Name.setColumns(10);
		txtMat3Name.setBounds(147, 293, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat3Name);
		
		JLabel label_3 = new JLabel("Amount:");
		label_3.setBounds(351, 218, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(label_3);
		
		txtMat2Amnt = new JTextField();
		txtMat2Amnt.setColumns(10);
		txtMat2Amnt.setBounds(408, 215, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat2Amnt);
		
		JLabel label_4 = new JLabel("Amount:");
		label_4.setBounds(351, 327, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(label_4);
		
		txtMat4Amnt = new JTextField();
		txtMat4Amnt.setColumns(10);
		txtMat4Amnt.setBounds(408, 324, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat4Amnt);
		 
		JLabel label_5 = new JLabel("Custom Item Name:");
		label_5.setBounds(10, 352, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(label_5);
		
		txtMat4Name = new JTextField();
		txtMat4Name.setColumns(10);
		txtMat4Name.setBounds(147, 349, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat4Name);
		
		JLabel label_6 = new JLabel("Custom Item Name:");
		label_6.setBounds(10, 406, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(label_6);
		
		txtMat5Name = new JTextField();
		txtMat5Name.setColumns(10);
		txtMat5Name.setBounds(147, 403, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat5Name);
		
		JLabel label_7 = new JLabel("Amount:");
		label_7.setBounds(351, 383, 77, 14);
		frmRpcoreItemCreator.getContentPane().add(label_7);
		
		txtMat5Amnt = new JTextField();
		txtMat5Amnt.setColumns(10);
		txtMat5Amnt.setBounds(408, 380, 56, 20);
		frmRpcoreItemCreator.getContentPane().add(txtMat5Amnt);
		
		JLabel lblItemInformation = new JLabel("Item Information:");
		lblItemInformation.setBounds(72, 13, 234, 14);
		frmRpcoreItemCreator.getContentPane().add(lblItemInformation);
		
		JLabel lblRequiredWorkstation = new JLabel("Other Information:");
		lblRequiredWorkstation.setBounds(327, 435, 100, 14);
		frmRpcoreItemCreator.getContentPane().add(lblRequiredWorkstation);
		
		JLabel lblWorkstation = new JLabel("Workstation:");
		lblWorkstation.setBounds(10, 461, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblWorkstation);
		
		cbStation = new JComboBox<Object>(Strings.stations);
		cbStation.setBounds(147, 458, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbStation);
		
		JLabel lblSpecialChance = new JLabel("Special Chance (50,25,12)%:");
		lblSpecialChance.setBounds(10, 514, 161, 14);
		frmRpcoreItemCreator.getContentPane().add(lblSpecialChance);
		
		JButton btnCreateItem = new JButton("Create Item");
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{Strings.saveFile();Strings.popItems();Strings.clearForm();}catch(Exception e){e.printStackTrace();}
			}
		});
		btnCreateItem.setBounds(320, 642, 114, 23);
		frmRpcoreItemCreator.getContentPane().add(btnCreateItem);
		
		JLabel lblToolRequired = new JLabel("Tool Required:");
		lblToolRequired.setBounds(10, 486, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblToolRequired);
		
		cbToolReq = new JComboBox<Object>(Strings.tools);
		cbToolReq.setBounds(147, 483, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbToolReq);
		
		JLabel lblSkill = new JLabel("Crafting Skill:");
		lblSkill.setBounds(10, 542, 93, 14);
		frmRpcoreItemCreator.getContentPane().add(lblSkill);
		
		cbSkill = new JComboBox<Object>(Strings.skills);
		cbSkill.setBounds(147, 536, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbSkill);
		
		JLabel lblSkillLevelReq = new JLabel("Crafting Skill Level Req:");
		lblSkillLevelReq.setBounds(10, 567, 149, 14);
		frmRpcoreItemCreator.getContentPane().add(lblSkillLevelReq);
		
		txtSkillLevel = new JTextField();
		txtSkillLevel.setBounds(299, 564, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtSkillLevel);
		txtSkillLevel.setColumns(10);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(frmRpcoreItemCreator,
						"Are you sure you want to delete item: "
								+ listCreated.getSelectedValue().toString()
								+ "?", "Save?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					try {
						Strings.deleteItem(listCreated.getSelectedValue()
								.toString());
						Strings.popItems();
					} catch (Exception e) {
					}
				}
			}
		});
		btnDeleteItem.setBounds(559, 397, 100, 23);
		frmRpcoreItemCreator.getContentPane().add(btnDeleteItem);
		
		JLabel lblItemCetegory = new JLabel("Item Category:");
		lblItemCetegory.setBounds(10, 113, 114, 14);
		frmRpcoreItemCreator.getContentPane().add(lblItemCetegory);
		
		cbCat = new JComboBox<Object>(Strings.category);
		cbCat.setBounds(147, 110, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbCat);
		
		JLabel lblDamageminmax = new JLabel("Damage(Min/Max):");
		lblDamageminmax.setBounds(10, 592, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(lblDamageminmax);
		
		JLabel lblProtectionminmax = new JLabel("Protection(Min/Max):");
		lblProtectionminmax.setBounds(10, 617, 122, 14);
		frmRpcoreItemCreator.getContentPane().add(lblProtectionminmax);
		
		txtDmgMin = new JTextField();
		txtDmgMin.setColumns(10);
		txtDmgMin.setBounds(254, 586, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtDmgMin);
		
		JLabel label_9 = new JLabel("/");
		label_9.setBounds(295, 589, 14, 14);
		frmRpcoreItemCreator.getContentPane().add(label_9);
		
		txtDmgMax = new JTextField();
		txtDmgMax.setColumns(10);
		txtDmgMax.setBounds(299, 586, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtDmgMax);
		
		txtProtMin = new JTextField();
		txtProtMin.setColumns(10);
		txtProtMin.setBounds(254, 611, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtProtMin);
		
		JLabel label_10 = new JLabel("/");
		label_10.setBounds(295, 614, 14, 14);
		frmRpcoreItemCreator.getContentPane().add(label_10);
		
		txtProtMax = new JTextField();
		txtProtMax.setColumns(10);
		txtProtMax.setBounds(299, 611, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtProtMax);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(376, 458, 2, 173);
		frmRpcoreItemCreator.getContentPane().add(separator_2);
		
		JLabel lblRarity = new JLabel("Rarity:");
		lblRarity.setBounds(388, 461, 65, 14);
		frmRpcoreItemCreator.getContentPane().add(lblRarity);
		
		cbRarity = new JComboBox<Object>(Strings.rarity);
		cbRarity.setBounds(542, 458, 194, 20);
		frmRpcoreItemCreator.getContentPane().add(cbRarity);
		
		JLabel lblVendorbuysell = new JLabel("Vendor (Buy/Sell):");
		lblVendorbuysell.setBounds(388, 486, 114, 14);
		frmRpcoreItemCreator.getContentPane().add(lblVendorbuysell);
		
		txtVSell = new JTextField();
		txtVSell.setColumns(10);
		txtVSell.setBounds(694, 480, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtVSell);
		
		JLabel label_11 = new JLabel("/");
		label_11.setBounds(690, 483, 14, 14);
		frmRpcoreItemCreator.getContentPane().add(label_11);
		
		txtVBuy = new JTextField();
		txtVBuy.setColumns(10);
		txtVBuy.setBounds(649, 480, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtVBuy);
		
		JLabel lblTeir = new JLabel("Tier:");
		lblTeir.setBounds(388, 514, 46, 14);
		frmRpcoreItemCreator.getContentPane().add(lblTeir);
		
		cbTier = new JComboBox<Object>(Strings.tier);
		cbTier.setBounds(694, 508, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(cbTier);
		
		JLabel lblSkillToUse = new JLabel("Skill Req 1/Level:");
		lblSkillToUse.setBounds(388, 539, 114, 14);
		frmRpcoreItemCreator.getContentPane().add(lblSkillToUse);
		
		JLabel lblSkillToUse_1 = new JLabel("Skill Req 2/Level:");
		lblSkillToUse_1.setBounds(388, 567, 114, 14);
		frmRpcoreItemCreator.getContentPane().add(lblSkillToUse_1);
		
		txtSkUse2Lvl = new JTextField();
		txtSkUse2Lvl.setColumns(10);
		txtSkUse2Lvl.setBounds(694, 564, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtSkUse2Lvl);
		
		txtSkUse1Lvl = new JTextField();
		txtSkUse1Lvl.setColumns(10);
		txtSkUse1Lvl.setBounds(694, 539, 42, 20);
		frmRpcoreItemCreator.getContentPane().add(txtSkUse1Lvl);
		
		cbSkUse1 = new JComboBox<Object>(Strings.sk);
		cbSkUse1.setBounds(542, 539, 149, 20);
		frmRpcoreItemCreator.getContentPane().add(cbSkUse1);
		
		cbSkUse2 = new JComboBox<Object>(Strings.sk);
		cbSkUse2.setBounds(542, 564, 149, 20);
		frmRpcoreItemCreator.getContentPane().add(cbSkUse2);
		
		cbSp12 = new JComboBox<Object>(Strings.later);
		cbSp12.setBounds(295, 508, 46, 20);
		frmRpcoreItemCreator.getContentPane().add(cbSp12);
		
		cbSp25 = new JComboBox<Object>(Strings.later);
		cbSp25.setBounds(237, 508, 46, 20);
		frmRpcoreItemCreator.getContentPane().add(cbSp25);
		
		cbSp50 = new JComboBox<Object>(Strings.later);
		cbSp50.setBounds(181, 508, 46, 20);
		frmRpcoreItemCreator.getContentPane().add(cbSp50);
		
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
