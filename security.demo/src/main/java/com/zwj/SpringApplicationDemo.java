package com.zwj;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringApplicationDemo {

	public static void main(String[] args) {
      SpringApplication.run(SpringApplicationDemo.class, args);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello spring  security";
	}
	  
	@RequestMapping(value = "/testDownload", method = RequestMethod.GET)
	public void Download(HttpServletResponse res) throws UnsupportedEncodingException {
		OutputStream os = null;
		BufferedInputStream bis = null;
	   
		try {
			String fileName = "Git&GitHub.pdf";
			res.setHeader("content-type", "application/octet-stream");
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			byte[] buff = new byte[1024];
			os = res.getOutputStream();
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("Static/" + fileName);
			bis = new BufferedInputStream(inputStream);
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("success");
	}
	
	@RequestMapping(value = "/testDownload2", method = RequestMethod.GET)
	public String  Download2(HttpServletResponse response , HttpServletRequest request) throws FileNotFoundException {
		if (request != null) {
			return "success";
		}
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(), "static/");
        if (!upload.exists()) upload.mkdirs();
        String uploadPath = upload + "\\";
        File  file = new File(uploadPath + "中文.pdf");
		System.out.println(file.toString()); 
        
		OutputStream out = null;
		BufferedInputStream bin = null;
	   
		try {
			String fileName = "中文.pdf";
		
			response.setHeader("content-type", "application/octet-stream");
			response.setContentType("application/octet-stream");
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("Static/" + fileName);
			bin = new BufferedInputStream(in);
			
			out = response.getOutputStream();
			
			byte[] buff = new byte[1024];
		    
			int length=0;
			//int i = bin.read(buff);
			while ( (length=bin.read(buff))> 0 ) {
				out.write(buff, 0, buff.length);
				out.flush();
			//	i = bin.read(buff);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if ( bin != null) {
				try {
					bin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("success");
	return "success";
	}


}
