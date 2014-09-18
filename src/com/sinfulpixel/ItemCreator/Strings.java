package com.sinfulpixel.ItemCreator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class Strings {
	public static String[] stations = {"Leather Working", "Forge", "Campfire", "Anvil", "Stove", "Inventory", "Carpentry"};
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
}
