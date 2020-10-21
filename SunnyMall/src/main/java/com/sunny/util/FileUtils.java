package com.sunny.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

public class FileUtils {

	//파일 업로드
	public static String uploadFile(String uploadPath,String originName,byte[] fileData) throws Exception{
		UUID uuid=UUID.randomUUID();
		String savedName = uuid.toString() + "-" + originName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		
		String formatName = originName.substring(originName.lastIndexOf(".")+1);
		String uploadFileName = null;
		
		if(MediaUtils.getMediaType(formatName) != null) {
			uploadFileName = makeThumbNail(uploadPath,savedName);
		}else {
			uploadFileName = makeIcon(uploadPath,savedName);
		}
		return uploadFileName;
	}
	//썸네일작업
	public static String makeThumbNail(String uploadPath,String fileName) throws IOException {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,120);
		
		String thumbNailName = uploadPath+File.separator + "s_"+fileName;
		File newFile = new File(thumbNailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(),newFile);
		
		return thumbNailName.substring(uploadPath.length()).replace(File.separatorChar,'/');
	}
	//이미지파일이 아닐경우 아이콘 생성
	private static String makeIcon(String uploadPath, String fileName) throws Exception{
		String iconName = uploadPath + File.separator + fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar,'/');
		
	}
	//이미지 파일 삭제
	public static void deleteFile(String uploadPath,String fileName) {
		String origin=fileName.substring(2);
		
		new File(uploadPath+origin.replace('/', File.separatorChar)).delete();
		new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
	}
	//파일 불러오기
	public static ResponseEntity<byte[]> getFile(String uploadPath, String fileName) throws Exception{
		
		InputStream in = null;
		byte[] fileData = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType type = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(type);
			
			in = new FileInputStream(uploadPath + fileName);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers, HttpStatus.OK);
		
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
		
	}
	
	
	
	
	
	
}
