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

				if (line.contains("cl_crosshair_drawoutline "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshairalpha "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshaircolor "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshaircolor_b "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshaircolor_g "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshaircolor_r "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshairdot "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshairgap "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshairsize "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshairstyle "))
					list.add(line.concat("; "));
				if (line.contains("cl_crosshairthickness "))
					list.add(line);
				if (line.contains("cl_crosshair_sniper_width "))
					list.add(line.concat("; "));
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strOutPath))) {
			for (String l : list) {
				bw.write(l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
