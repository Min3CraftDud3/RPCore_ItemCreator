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
	public static String[] tools = {"Knife", "Forge Hammer", "Saw","(none)"};
	public static String[] skills = {"Smithing","Smelting","(none)","Wood Crafting", "Leather Working"};
	public static String information = "Author: Brandon H\nCurrent Version: 1.0\nFor use with RP-Core Plugin.";
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
		String chanceH = ItemCreator.txtHigh.getText();
		String chanceL = ItemCreator.txtLow.getText();
		String station = ItemCreator.cbStation.getSelectedItem().toString();
		String tool = ItemCreator.cbToolReq.getSelectedItem().toString();
		String skill = ItemCreator.cbSkill.getSelectedItem().toString();
		String skillLevel = ItemCreator.txtSkillLevel.getText();
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
		    	if(!chanceH.equals("")){fc.set("ItemFile."+itemName+".ChanceHigh", chanceH);}
		    	if(!chanceL.equals("")){fc.set("ItemFile."+itemName+".ChanceLow", chanceL);}
		    	if(!station.equals("")){fc.set("ItemFile."+itemName+".WorkStation", station);}
		    	if(!tool.equals("")){fc.set("ItemFile."+itemName+".Tool", tool);}
		    	if(!skill.equals("")){fc.set("ItemFile."+itemName+".Skill", skill);}
		    	if(!skillLevel.equals("")){fc.set("ItemFile."+itemName+".SkillLevel", skillLevel);}
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
				if(fc.contains("ItemFile."+s+".ChanceHigh")){
				String chanceH = fc.getString("ItemFile."+s+".ChanceHigh");
				if(!chanceH.equals("") && chanceH != null){ItemCreator.txtHigh.setText(chanceH);}
				}
				if(fc.contains("ItemFile."+s+".ChanceLow")){
				String chanceL = fc.getString("ItemFile."+s+".ChanceLow");
				if(!chanceL.equals("") && chanceL != null){ItemCreator.txtLow.setText(chanceL);}
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
		ItemCreator.txtDesc.setText(null);
		ItemCreator.txtHigh.setText(null);
		ItemCreator.txtLow.setText(null);
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
	}
}
