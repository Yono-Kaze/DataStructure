package com.datastructure.unit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 
 *<p>Description:文件类相关操作<p>	
 * @author Administrator
 * @version 2020-11-7
 *
 */
public class FileOperation {
	
	private static final String BASEPATH = "classpath*:";
	
	/**
	 * 读取文件为filename中的内容，并将包含的所有词语放进words中
	 * @return
	 * 
	 */
	public static boolean readFile(String fileName, ArrayList<String> words) throws FileNotFoundException {
		
		if(fileName == null || words == null) {
			System.out.println("fileName is null or words is null");
			return false;	
		}
		
		//文件读取
		Scanner scanner;
		try {
			String is = FileOperation.class.getClass().getResource("/" + fileName)
					.getFile().toString();
			File file = new File(is);
			if(file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				scanner = new Scanner(new BufferedInputStream(fis), "UTF8");
				scanner.useLocale(Locale.ENGLISH);
			}else {
				return false;
			}
		} catch (IOException e) {
			System.out.println("cannot open" + fileName);
			return false;
		}
		
		if(scanner.hasNextLine()) {
			String contents = scanner.useDelimiter("\\A").next();
			int start = firstCharacterIndex(contents, 0);
			
			for (int i = start + 1; i <= contents.length(); ) {
				if(i == contents.length() || !Character.isLetter(contents.charAt(i))) {
					String word = contents.substring(start, i).toLowerCase();
					words.add(word);
					start = firstCharacterIndex(contents, i);
					i = start + 1;
				}else {
					i++;
				}
			}
		}
		return true;		
	}

	/**
	 * 寻找字符串s中，congstart的位置开始的第一个字母字符的位置
	 * @param s
	 * @param start
	 * @return
	 */
	private static int firstCharacterIndex(String s, int start) {
		
		for (int i = start; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i))) {
				return i;
			}
		}
		return s.length();
	}
	
}
