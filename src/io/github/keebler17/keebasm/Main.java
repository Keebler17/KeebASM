package io.github.keebler17.keebasm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		File f = new File("input");
		Scanner s = new Scanner(System.in);
		System.out.print("Name your output file: ");
		File out = new File(s.nextLine());
		out.delete();
		out.createNewFile();
		FileOutputStream outStream = new FileOutputStream(out);
		
		BufferedReader in = new BufferedReader(new FileReader(f));
		
		Iterator<String> it = in.lines().iterator();
		
		
		while(it.hasNext()) {
			String line = it.next();
			
			if(line.split(" ").length == 2) {
				InstructionType opcode = InstructionType.valueOf(line.split(" ")[0]);
				byte argument = (byte)(int)Integer.decode(line.split(" ")[1]);
				if(opcode != InstructionType.DB) {
					byte[] arr = {(byte)opcode.ordinal(), argument};
					outStream.write(arr);
				} else {
					byte[] arr = {argument};
					outStream.write(arr);
				}
			} else {
				InstructionType opcode = InstructionType.valueOf(line);
				outStream.write((byte)opcode.ordinal());
				outStream.write(0x69);
			}
			
			
		}
		
		System.out.println("Final output:");
		
		outStream.flush();
		outStream.close();
		
		in.close();
		
		s.close();
		
		FileInputStream finalOut = new FileInputStream(out);
		while(true) {
			int i = finalOut.read();
			if(i == -1) System.exit(0);
			System.out.print("0x" + Integer.toHexString(i) + " ");
		}
	}
}
