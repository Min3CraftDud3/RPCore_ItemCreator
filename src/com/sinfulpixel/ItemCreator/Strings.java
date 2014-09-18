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
	public static String[] tools = {"Knife", "Forge Hammer", "Saw"};
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
		for(String s:materials){
			System.out.println(s);
		}
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
		//Checks
		String cbCheck = "(none)";
		String nullCk = "";
		//Save Operation
		File ItemFile = new File("Items.yml");
		if(ItemFile.exists()){
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(ItemFile);
		    if(itemName != nullCk){
		    	fc.set("ItemFile."+itemName+".Name", itemName);
		    	if(itemDesc != nullCk){fc.set("ItemFile."+itemName+".Desc", itemDesc);}
		    	if(texture != cbCheck){fc.set("ItemFile."+itemName+".Texture", texture);}
		    	if(Mat1 != cbCheck){fc.set("ItemFile."+itemName+".Mat1", Mat1);}
		    	if(Mat1Name != nullCk){fc.set("ItemFile."+itemName+".Mat1Name", Mat1Name);}
		    	if(Mat1Amnt != nullCk){fc.set("ItemFile."+itemName+".Mat1Amnt", Mat1Amnt);}
		    	if(Mat2 != cbCheck){fc.set("ItemFile."+itemName+".Mat2", Mat2);}
		    	if(Mat2Name != nullCk){fc.set("ItemFile."+itemName+".Mat2Name", Mat2Name);}
		    	if(Mat2Amnt != nullCk){fc.set("ItemFile."+itemName+".Mat2Amnt", Mat2Amnt);}
		    	if(Mat3 != cbCheck){fc.set("ItemFile."+itemName+".Mat3", Mat3);}
		    	if(Mat3Name != nullCk){fc.set("ItemFile."+itemName+".Mat3Name", Mat3Name);}
		    	if(Mat3Amnt != nullCk){fc.set("ItemFile."+itemName+".Mat3Amnt", Mat3Amnt);}
		    	if(Mat4 != cbCheck){fc.set("ItemFile."+itemName+".Mat4", Mat4);}
		    	if(Mat4Name != nullCk){fc.set("ItemFile."+itemName+".Mat4Name", Mat4Name);}
		    	if(Mat4Amnt != nullCk){fc.set("ItemFile."+itemName+".Mat4Amnt", Mat4Amnt);}
		    	if(Mat5 != cbCheck){fc.set("ItemFile."+itemName+".Mat5", Mat5);}
		    	if(Mat5Name != nullCk){fc.set("ItemFile."+itemName+".Mat5Name", Mat5Name);}
		    	if(Mat5Amnt != nullCk){fc.set("ItemFile."+itemName+".Mat5Amnt", Mat5Amnt);}
		    	if(chanceH != nullCk){fc.set("ItemFile."+itemName+".ChanceHigh", chanceH);}
		    	if(chanceL != nullCk){fc.set("ItemFile."+itemName+".ChanceLow", chanceL);}
		    	if(station != cbCheck){fc.set("ItemFile."+itemName+".WorkStation", station);}
		    	if(tool != cbCheck){fc.set("ItemFile."+itemName+".Tool", tool);}
		    }
		    fc.save(ItemFile);			
		}
	}
	@SuppressWarnings("unchecked")
	public static void popItems(){
		File itemFile = new File("Items.yml");
		if(itemFile.exists()){
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(itemFile);
		    Set<String> ex = fc.getConfigurationSection("ItemFile").getKeys(false); 
		    String[] s = ex.toArray(new String[ex.size()]);
		    Arrays.sort(s);
		    for(String t:s){
		    	model.addElement(t);
		    }
		}
	}
}
