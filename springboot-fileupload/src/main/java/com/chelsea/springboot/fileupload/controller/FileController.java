package com.chelsea.springboot.fileupload.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chelsea.springboot.fileupload.util.FileUtil;

@Controller
public class FileController {

	@Value("${uploadpath}")
	private String uploadpath;

	@RequestMapping(value = "/to-upload-img", method = RequestMethod.GET)
	public String toUploadImg() {
		// 跳转到 templates 目录下的 uploadimg.html
		return "uploadimg";
	}

	// 处理文件上传
	@RequestMapping(value = "/upload-img", method = RequestMethod.POST)
	@ResponseBody
	public String uploadImg(@RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		try {
			FileUtil.uploadFile(file.getBytes(), uploadpath, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "uploadimg success";
	}

}
