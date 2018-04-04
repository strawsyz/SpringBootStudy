package com.wisely.highlight_springmvc4.web.ch4_5;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping(value="upload",method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file){
		
		try {
			//将文件写到磁盘
			FileUtils.writeByteArrayToFile(new File("d:/mytemp/upload/"+file.getOriginalFilename()),file.getBytes());
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "wrong";
		}
	}
}
