package com.sinfulpixel.ItemCreator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class Strings {
	public static String[] stations = {"Leather Working", "Forge", "Campfire", "Anvil", "Stove", "Inventory", "Carpentry"};
	public static String[] tools = {"Knife", "Forge Hammer", "Saw","(none)","Ingot Mold","Cooking Utensils"};
	public static String[] skills = {"Smithing","Smelting","(none)","Wood Crafting", "Leather Working", "Cooking"};
	public static String[] category = {"Weapon","Armor","Crafting Material","Building Material","(Other)"};
	public static String information = "Author: Brandon H\nCurrent Version: 1.0\nFor use with RP-Core Plugin.";
	public static String[] rarity = {"(none)","Poor","Common","Uncommon","Rare","Epic","Legendary","Artifact","Quest"};
	public static String[] tier = {"1","2","3","4","5","6","7","8","9","10"};
	public static String[] sk = {"Defense","Health","Range","Strength","Farming","Cooking","Woodcutting",
		"Wood Crafting","Leather Working","Smelting","Smithing","Luck","Alchemy","Firemaking","Mining",
		"Cooking","Fishing","(none)"};
	public static String[] later = {"Fuck","You","Melted"};
	public static List<String> materials = new ArrayList<>();
	@SuppressWarnings("rawtypes")
	public static DefaultListModel model = new DefaultListModel();
	
	public static void popMaterials(){
		materials.add("(none)");
		for(Material s :Material.values()){
			materials.add(s.name());
		}
		java.util.Collections.sort(materials);
		Arrays.sort(stations);
		Arrays.sort(tools);
		Arrays.sort(skills);
		Arrays.sort(category);
		Arrays.sort(sk);
	}
	public static void createFile() throws IOException{
		File ItemFile = new File("Items.yml");
		if(!ItemFile.exists()){
			ItemFile.createNewFile();
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(ItemFile);
		    fc.set("ItemFile", "==== [Item File] ====");		    
		    fc.save(ItemFile);			
		}
	}
	public static void saveFile()throws IOException{
		String itemName = ItemCreator.txtName.getText();
		String itemDesc = ItemCreator.txtDesc.getText();
		String texture = ItemCreator.cbItem.getSelectedItem().toString();
		String Mat1 = ItemCreator.cbMat1.getSelectedItem().toString();
		String Mat1Name = ItemCreator.txtMat1Name.getText();
		String Mat1Amnt = ItemCreator.txtMat1Amnt.getText();
		String Mat2 = ItemCreator.cbMat2.getSelectedItem().toString();
		String Mat2Name = ItemCreator.txtMat2Name.getText();
		String Mat2Amnt = ItemCreator.txtMat2Amnt.getText();
		String Mat3 = ItemCreator.cbMat3.getSelectedItem().toString();
		String Mat3Name = ItemCreator.txtMat3Name.getText();
		String Mat3Amnt = ItemCreator.txtMat3Amnt.getText();
		String Mat4 = ItemCreator.cbMat4.getSelectedItem().toString();
		String Mat4Name = ItemCreator.txtMat4Name.getText();
		String Mat4Amnt = ItemCreator.txtMat4Amnt.getText();
		String Mat5 = ItemCreator.cbMat5.getSelectedItem().toString();
		String Mat5Name = ItemCreator.txtMat5Name.getText();
		String Mat5Amnt = ItemCreator.txtMat5Amnt.getText();
		String chance50 = ItemCreator.cbSp50.getSelectedItem().toString();
		String chance25 = ItemCreator.cbSp25.getSelectedItem().toString();
		String chance12 = ItemCreator.cbSp12.getSelectedItem().toString();
		String station = ItemCreator.cbStation.getSelectedItem().toString();
		String tool = ItemCreator.cbToolReq.getSelectedItem().toString();
		String skill = ItemCreator.cbSkill.getSelectedItem().toString();
		String skillLevel = ItemCreator.txtSkillLevel.getText();
		String category = ItemCreator.cbCat.getSelectedItem().toString();
		String dmgMin = ItemCreator.txtDmgMin.getText();
		String dmgMax = ItemCreator.txtDmgMax.getText();
		String protMin = ItemCreator.txtProtMin.getText();
		String protMax = ItemCreator.txtProtMax.getText();
		String rarity = ItemCreator.cbRarity.getSelectedItem().toString();
		String vBuy = ItemCreator.txtVBuy.getText();
		String vSell = ItemCreator.txtVSell.getText();
		String tier = ItemCreator.cbTier.getSelectedItem().toString();
		//
		String skillReq1 = ItemCreator.cbSkUse1.getSelectedItem().toString();
		String skillReq2 = ItemCreator.cbSkUse2.getSelectedItem().toString();
		String skillReq1Lvl = ItemCreator.txtSkUse1Lvl.getText();
		String skillReq2Lvl = ItemCreator.txtSkUse2Lvl.getText();
		
		//Save Operation
		File ItemFile = new File("Items.yml");
		if(ItemFile.exists()){
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(ItemFile);
		    if(!itemName.equals("")){
		    	fc.set("ItemFile."+itemName+".Name", itemName);
		    	if(!itemDesc.equals("")){fc.set("ItemFile."+itemName+".Desc", itemDesc);}
		    	if(!texture.equals("(none)")){fc.set("ItemFile."+itemName+".Texture", texture);}
		    	if(!Mat1.equals("(none)")){fc.set("ItemFile."+itemName+".Mat1", Mat1);}
		    	if(!Mat1Name.equals("")){fc.set("ItemFile."+itemName+".Mat1Name", Mat1Name);}
		    	if(!Mat1Amnt.equals("")){fc.set("ItemFile."+itemName+".Mat1Amnt", Mat1Amnt);}
		    	if(!Mat2.equals("(none)")){fc.set("ItemFile."+itemName+".Mat2", Mat2);}
		    	if(!Mat2Name.equals("")){fc.set("ItemFile."+itemName+".Mat2Name", Mat2Name);}
		    	if(!Mat2Amnt.equals("")){fc.set("ItemFile."+itemName+".Mat2Amnt", Mat2Amnt);}
		    	if(!Mat3.equals("(none)")){fc.set("ItemFile."+itemName+".Mat3", Mat3);}
		    	if(!Mat3Name.equals("")){fc.set("ItemFile."+itemName+".Mat3Name", Mat3Name);}
		    	if(!Mat3Amnt.equals("")){fc.set("ItemFile."+itemName+".Mat3Amnt", Mat3Amnt);}
		    	if(!Mat4.equals("(none)")){fc.set("ItemFile."+itemName+".Mat4", Mat4);}
		    	if(!Mat4Name.equals("")){fc.set("ItemFile."+itemName+".Mat4Name", Mat4Name);}
		    	if(!Mat4Amnt.equals("")){fc.set("ItemFile."+itemName+".Mat4Amnt", Mat4Amnt);}
		    	if(!Mat5.equals("(none)")){fc.set("ItemFile."+itemName+".Mat5", Mat5);}
		    	if(!Mat5Name.equals("")){fc.set("ItemFile."+itemName+".Mat5Name", Mat5Name);}
		    	if(!Mat5Amnt.equals("")){fc.set("ItemFile."+itemName+".Mat5Amnt", Mat5Amnt);}
		    	if(!chance50.equals("")){fc.set("ItemFile."+itemName+".SpecialChance50", chance50);}
		    	if(!chance25.equals("")){fc.set("ItemFile."+itemName+".SpecialChance25", chance25);}
		    	if(!chance12.equals("")){fc.set("ItemFile."+itemName+".SpecialChance12", chance12);}
		    	if(!station.equals("")){fc.set("ItemFile."+itemName+".WorkStation", station);}
		    	if(!tool.equals("")){fc.set("ItemFile."+itemName+".Tool", tool);}
		    	if(!skill.equals("")){fc.set("ItemFile."+itemName+".Skill", skill);}
		    	if(!skillLevel.equals("")){fc.set("ItemFile."+itemName+".SkillLevel", skillLevel);}
		    	if(!category.equals("")){fc.set("ItemFile."+itemName+".Category", category);}
		    	if(!dmgMin.equals("")){fc.set("ItemFile."+itemName+".DmgMin", dmgMin);}
		    	if(!dmgMax.equals("")){fc.set("ItemFile."+itemName+".DmgMax", dmgMax);}
		    	if(!protMin.equals("")){fc.set("ItemFile."+itemName+".ProtMin", protMin);}
		    	if(!protMin.equals("")){fc.set("ItemFile."+itemName+".ProtMax", protMax);}
		    	if(!vBuy.equals("")){fc.set("ItemFile."+itemName+".VendorBuyPrice", vBuy);}
		    	if(!vSell.equals("")){fc.set("ItemFile."+itemName+".VendorSellPrice", vSell);}
		    	if(!rarity.equals("")){fc.set("ItemFile."+itemName+".Rarity", rarity);}
		    	if(!tier.equals("")){fc.set("ItemFile."+itemName+".Tier", tier);}
		    	if(!skillReq1.equals("")){fc.set("ItemFile."+itemName+".SkillReq1", skillReq1);}
		    	if(!skillReq2.equals("")){fc.set("ItemFile."+itemName+".SkillReq2", skillReq2);}
		    	if(!skillReq1Lvl.equals("")){fc.set("ItemFile."+itemName+".SkillReq1Lvl", skillReq1Lvl);}
		    	if(!skillReq2Lvl.equals("")){fc.set("ItemFile."+itemName+".SkillReq2Lvl", skillReq2Lvl);}
		    }
		    fc.save(ItemFile);			
		}
	}
	@SuppressWarnings("unchecked")
	public static void popItems(){
		File itemFile = new File("Items.yml");
		if(itemFile.exists()){
			model.clear();
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(itemFile);
		    try{Set<String> ex = fc.getConfigurationSection("ItemFile").getKeys(false); 
		    String[] s = ex.toArray(new String[ex.size()]);
		    Arrays.sort(s);
		    for(String t:s){
		    	model.addElement(t);
		    }
		    }catch(Exception e){}
		}
	}
	public static void popForm(String s){
		File itemFile = new File("Items.yml");
		if(itemFile.exists()){
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(itemFile);
		    if(fc.contains("ItemFile."+s)){
		    	String itemName = fc.getString("ItemFile."+s+".Name");
		    	ItemCreator.txtName.setText(itemName);
				if(fc.contains("ItemFile."+s+".Desc")){
		    	String itemDesc = fc.getString("ItemFile."+s+".Desc");
		    	if(!itemDesc.equals("") && itemDesc != null){ItemCreator.txtDesc.setText(itemDesc);}
				}
				if(fc.contains("ItemFile."+s+".Texture")){
				String texture = fc.getString("ItemFile."+s+".Texture");
				if(!texture.equals("") && texture != null){ItemCreator.cbItem.setSelectedItem(texture);}
				}
				if(fc.contains("ItemFile."+s+".Mat1")){
				String Mat1 = fc.getString("ItemFile."+s+".Mat1");
				String Mat1Name = fc.getString("ItemFile."+s+".Mat1Name");
				String Mat1Amnt = fc.getString("ItemFile."+s+".Mat1Amnt");
				if(!Mat1.equals("") && Mat1 != null){ItemCreator.cbMat1.setSelectedItem(Mat1);}
				if(!Mat1Name.equals("") && Mat1Name != null){ItemCreator.txtMat1Name.setText(Mat1Name);}
				if(!Mat1Amnt.equals("") && Mat1Amnt != null){ItemCreator.txtMat1Amnt.setText(Mat1Amnt);}
				}
				if(fc.contains("ItemFile."+s+".Mat2")){
				String Mat2 = fc.getString("ItemFile."+s+".Mat2");
				String Mat2Name = fc.getString("ItemFile."+s+".Mat2Name");
				String Mat2Amnt = fc.getString("ItemFile."+s+".Mat2Amnt");
				if(!Mat2.equals("") && Mat2 != null){ItemCreator.cbMat2.setSelectedItem(Mat2);}
				if(!Mat2Name.equals("") && Mat2Name != null){ItemCreator.txtMat2Name.setText(Mat2Name);}
				if(!Mat2Amnt.equals("") && Mat2Amnt != null){ItemCreator.txtMat2Amnt.setText(Mat2Amnt);}
				}
				if(fc.contains("ItemFile."+s+".Mat3")){
				String Mat3 = fc.getString("ItemFile."+s+".Mat3");
				String Mat3Name = fc.getString("ItemFile."+s+".Mat3Name");
				String Mat3Amnt = fc.getString("ItemFile."+s+".Mat3Amnt");
				if(!Mat3.equals("") && Mat3 != null){ItemCreator.cbMat3.setSelectedItem(Mat3);}
				if(!Mat3Name.equals("") && Mat3Name != null){ItemCreator.txtMat3Name.setText(Mat3Name);}
				if(!Mat3Amnt.equals("") && Mat3Amnt != null){ItemCreator.txtMat3Amnt.setText(Mat3Amnt);}
				}
				if(fc.contains("ItemFile."+s+".Mat4")){
				String Mat4 = fc.getString("ItemFile."+s+".Mat4");
				String Mat4Name = fc.getString("ItemFile."+s+".Mat4Name");
				String Mat4Amnt = fc.getString("ItemFile."+s+".Mat4Amnt");
				if(!Mat4.equals("") && Mat4 != null){ItemCreator.cbMat4.setSelectedItem(Mat4);}
				if(!Mat4Name.equals("") && Mat4Name != null){ItemCreator.txtMat4Name.setText(Mat4Name);}
				if(!Mat4Amnt.equals("") && Mat4Amnt != null){ItemCreator.txtMat4Amnt.setText(Mat4Amnt);}
				}
				if(fc.contains("ItemFile."+s+".Mat5")){
				String Mat5 = fc.getString("ItemFile."+s+".Mat5");
				String Mat5Name = fc.getString("ItemFile."+s+".Mat5Name");
				String Mat5Amnt = fc.getString("ItemFile."+s+".Mat5Amnt");
				if(!Mat5.equals("") && Mat5 != null){ItemCreator.cbMat5.setSelectedItem(Mat5);}
				if(!Mat5Name.equals("") && Mat5Name != null){ItemCreator.txtMat5Name.setText(Mat5Name);}
				if(!Mat5Amnt.equals("") && Mat5Amnt != null){ItemCreator.txtMat5Amnt.setText(Mat5Amnt);}
				}
				if(fc.contains("ItemFile."+s+".SpecialChance50")){
				String chance50 = fc.getString("ItemFile."+s+".SpecialChance50");
				if(!chance50.equals("") && chance50 != null){ItemCreator.cbSp50.setSelectedItem(chance50);}
				}
				if(fc.contains("ItemFile."+s+".SpecialChance25")){
				String chance25 = fc.getString("ItemFile."+s+".SpecialChance25");
				if(!chance25.equals("") && chance25 != null){ItemCreator.cbSp25.setSelectedItem(chance25);}
				}
				if(fc.contains("ItemFile."+s+".SpecialChance12")){
					String chance12 = fc.getString("ItemFile."+s+".SpecialChance12");
					if(!chance12.equals("") && chance12 != null){ItemCreator.cbSp12.setSelectedItem(chance12);}
					}
				if(fc.contains("ItemFile."+s+".WorkStation")){
				String station = fc.getString("ItemFile."+s+".WorkStation");
				if(!station.equals("") && station != null){ItemCreator.cbStation.setSelectedItem(station);}
				}
				if(fc.contains("ItemFile."+s+".Tool")){
				String tool = fc.getString("ItemFile."+s+".Tool");
				if(!tool.equals("") && tool != null){ItemCreator.cbToolReq.setSelectedItem(tool);}
				}	
				if(fc.contains("ItemFile."+s+".Skill")){
					String skill = fc.getString("ItemFile."+s+".Skill");
					if(!skill.equals("") && skill != null){ItemCreator.cbSkill.setSelectedItem(skill);}
				}
				if(fc.contains("ItemFile."+s+".SkillLevel")){
					String skillLevel = fc.getString("ItemFile."+s+".SkillLevel");
					if(!skillLevel.equals("") && skillLevel != null){ItemCreator.txtSkillLevel.setText(skillLevel);}
				}
				if(fc.contains("ItemFile."+s+".Category")){
					String category = fc.getString("ItemFile."+s+".Category");
					if(!category.equals("") && category != null){ItemCreator.cbCat.setSelectedItem(category);}
				}
				if(fc.contains("ItemFile."+s+".DmgMin")){
					String dmgMin = fc.getString("ItemFile."+s+".DmgMin");
					if(!dmgMin.equals("") && dmgMin != null){ItemCreator.txtDmgMin.setText(dmgMin);}
				}
				if(fc.contains("ItemFile."+s+".DmgMax")){
					String dmgMax = fc.getString("ItemFile."+s+".DmgMax");
					if(!dmgMax.equals("") && dmgMax != null){ItemCreator.txtDmgMax.setText(dmgMax);}
				}
				if(fc.contains("ItemFile."+s+".ProtMin")){
					String protMin = fc.getString("ItemFile."+s+".ProtMin");
					if(!protMin.equals("") && protMin != null){ItemCreator.txtProtMin.setText(protMin);}
				}
				if(fc.contains("ItemFile."+s+".ProtMax")){
					String protMax = fc.getString("ItemFile."+s+".ProtMax");
					if(!protMax.equals("") && protMax != null){ItemCreator.txtProtMax.setText(protMax);}
				}
				if(fc.contains("ItemFile."+s+".Rarity")){
					String rarity = fc.getString("ItemFile."+s+".Rarity");
					if(!rarity.equals("") && rarity != null){ItemCreator.cbRarity.setSelectedItem(rarity);}
				}
				if(fc.contains("ItemFile."+s+".VendorBuyPrice")){
					String vBuy = fc.getString("ItemFile."+s+".VendorBuyPrice");
					if(!vBuy.equals("") && vBuy != null){ItemCreator.txtVBuy.setText(vBuy);}
				}
				if(fc.contains("ItemFile."+s+".VendorSellPrice")){
					String vSell = fc.getString("ItemFile."+s+".VendorSellPrice");
					if(!vSell.equals("") && vSell != null){ItemCreator.txtVSell.setText(vSell);}
				}
				if(fc.contains("ItemFile."+s+".Tier")){
					String tier = fc.getString("ItemFile."+s+".Tier");
					if(!tier.equals("") && tier != null){ItemCreator.cbTier.setSelectedItem(tier);}
				} 
				if(fc.contains("ItemFile."+s+".SkillReq1")){
					String skillReq1 = fc.getString("ItemFile."+s+".SkillReq1");
					if(!skillReq1.equals("") && skillReq1 != null){ItemCreator.cbSkUse1.setSelectedItem(skillReq1);}
				}
				if(fc.contains("ItemFile."+s+".SkillReq1Lvl")){
					String skillReq1Lvl = fc.getString("ItemFile."+s+".SkillReq1Lvl");
					if(!skillReq1Lvl.equals("") && skillReq1Lvl != null){ItemCreator.txtSkUse1Lvl.setText(skillReq1Lvl);}
				}
				if(fc.contains("ItemFile."+s+".SkillReq2")){
					String skillReq2 = fc.getString("ItemFile."+s+".SkillReq2");
					if(!skillReq2.equals("") && skillReq2 != null){ItemCreator.cbSkUse2.setSelectedItem(skillReq2);}
				}
				if(fc.contains("ItemFile."+s+".SkillReq1Lvl")){
					String skillReq1Lv2 = fc.getString("ItemFile."+s+".SkillReq2Lvl");
					if(!skillReq1Lv2.equals("") && skillReq1Lv2 != null){ItemCreator.txtSkUse2Lvl.setText(skillReq1Lv2);}
				}
				
		    }
		}
	}
	public static void clearForm(){
		ItemCreator.cbMat1.setSelectedIndex(0);
		ItemCreator.cbItem.setSelectedIndex(0);
		ItemCreator.cbMat2.setSelectedIndex(0);
		ItemCreator.cbMat3.setSelectedIndex(0);
		ItemCreator.cbMat4.setSelectedIndex(0);
		ItemCreator.cbMat5.setSelectedIndex(0);
		ItemCreator.cbStation.setSelectedIndex(0);
		ItemCreator.cbToolReq.setSelectedIndex(0);
		ItemCreator.cbSkill.setSelectedIndex(0);
		ItemCreator.cbCat.setSelectedIndex(0);
		ItemCreator.txtDesc.setText(null);
		ItemCreator.cbSp50.setSelectedIndex(0);
		ItemCreator.cbSp25.setSelectedIndex(0);
		ItemCreator.cbSp12.setSelectedIndex(0);
		ItemCreator.txtName.setText(null);
		ItemCreator.txtMat1Amnt.setText(null);
		ItemCreator.txtMat1Name.setText(null);
		ItemCreator.txtMat2Amnt.setText(null);
		ItemCreator.txtMat2Name.setText(null);
		ItemCreator.txtMat3Amnt.setText(null);
		ItemCreator.txtMat3Name.setText(null);
		ItemCreator.txtMat4Amnt.setText(null);
		ItemCreator.txtMat4Name.setText(null);
		ItemCreator.txtMat5Amnt.setText(null);
		ItemCreator.txtMat5Name.setText(null);	
		ItemCreator.txtSkillLevel.setText(null);
		ItemCreator.txtDmgMin.setText(null);
		ItemCreator.txtDmgMax.setText(null);
		ItemCreator.txtProtMin.setText(null);
		ItemCreator.txtProtMax.setText(null);
		ItemCreator.txtVBuy.setText(null);
		ItemCreator.txtVSell.setText(null);
		ItemCreator.cbRarity.setSelectedIndex(0);
		ItemCreator.cbTier.setSelectedIndex(0);
		ItemCreator.cbSkUse1.setSelectedIndex(0);
		ItemCreator.cbSkUse2.setSelectedIndex(0);
		ItemCreator.txtSkUse1Lvl.setText(null);
		ItemCreator.txtSkUse2Lvl.setText(null);
	}
	public static void deleteItem(String s)throws IOException{
		File itemFile = new File("Items.yml");
		if(itemFile.exists()){
			model.clear();
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(itemFile);
		    if(fc.contains("ItemFile."+s)){
		    	fc.set("ItemFile."+s, null);
		    	fc.save(itemFile);
		    }
		}
	}
}
