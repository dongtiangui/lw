package com.lw.controller;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.google.common.collect.Lists;
import com.lw.base.ResultSupport;
import com.lw.utils.ApplicationUtil;
import com.lw.utils.FTPUtil;
@Controller
@RequestMapping(value = "/file")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@RequestMapping(value = "/fileUpload")
	@ResponseBody
	public ResultSupport uploadFileBackAddress(
			@RequestParam("upload") MultipartFile multipartFile,HttpServletRequest request)
			throws IllegalStateException, IOException {
		Subject subject = SecurityUtils.getSubject();
		ResultSupport res = new ResultSupport();
        res.setUploaded(0);
        if (multipartFile == null || multipartFile.isEmpty())
            return res;
        String fileName = multipartFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()
                .replaceAll("-", "")
                .concat(fileName.substring(fileName.lastIndexOf(".")));
        try {
            String path = ApplicationUtil.IMAGE_URL;
            File filepath = new File(path, newFileName);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            multipartFile.transferTo(filepath);
            if (FTPUtil.uploadFile(Lists.newArrayList(filepath),(String)subject.getPrincipal())) {
				filepath.delete();
			};
            res.setUploaded(1);
            res.setFileName(fileName);
            res.setUrl(ApplicationUtil.FTP_URL+(String)subject.getPrincipal()+"/"+newFileName);
            return res;
        } catch (IOException ex) {
            logger.error("上传图片异常", ex);
        }
        return res;
	}
}
