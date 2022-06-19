package config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		String srcFile = "\\config.cfg";
		String gnrtFile = "\\crosshair.cfg";

		String path = System.getProperty("user.dir".toString());

		String strPath = path.concat(srcFile);
		String strOutPath = path.concat(gnrtFile);
		

		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			String line = br.readLine();
			while (line != null) {

				if (line.contains("cl_crosshair"))
					list.add(line.concat("; \n"));
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		list.removeIf(p1 -> p1.contains("bind"));
		list.removeIf(p1 -> p1.contains("maxdist"));
		list.removeIf(p1 -> p1.contains("split"));
		list.removeIf(p1 -> p1.contains("friendly"));
		list.removeIf(p1 -> p1.contains("inaccuracy"));
		list.removeIf(p1 -> p1.contains("cl_crosshair_t"));
		list.removeIf(p1 -> p1.contains("useweaponvalue"));
		list.removeIf(p1 -> p1.contains("cl_crosshairusealpha"));
		list.removeIf(p1 -> p1.contains("outlinethickness"));
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strOutPath))) {
			for (String l : list) {
				bw.write(l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

}
