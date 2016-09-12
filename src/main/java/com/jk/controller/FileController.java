package com.jk.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jk.model.Attachment;

@Controller
@RequestMapping("/fileController")
public class FileController extends BaseController implements ServletContextAware {

	private static final Logger logger = Logger.getLogger(FileController.class);
	
	private ServletContext servletContext;
	
	@RequestMapping("/upload")
	public void upload(@RequestParam("file") CommonsMultipartFile file, HttpServletResponse response) {
		if(!file.isEmpty()) {
            //获取本地存储路径
            String path = this.servletContext.getRealPath("/upload/");
            logger.info(path);
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            logger.info(fileType);
            File file2 = new File(path, new Date().getTime() + fileType);
            Attachment attachment = new Attachment();
            attachment.setId(UUID.randomUUID().toString());
            attachment.setOldName(fileName);
            attachment.setNewName(file2.getName());
            attachment.setUrl(path + file2.getName());
            try {
                //将上传的文件写入到新建的文件中
                file.getFileItem().write(file2);
                super.writeJson(attachment, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
          
        }
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	@RequestMapping("/uploadFile")
	public void uploadFile(@RequestParam MultipartFile file, HttpServletResponse response, HttpServletRequest request) {
		InputStream is = null;
		BufferedInputStream bis = null;
		ByteArrayOutputStream baos = null;
		RandomAccessFile raf = null;
		try {
			if (null != file) {
				String folderPath = this.servletContext.getRealPath("/upload/");
	            logger.info(folderPath);
	            String fileName = file.getOriginalFilename();
	            String fileType = fileName.substring(fileName.lastIndexOf("."));
	            logger.info(fileType);
	            File file2 = new File(folderPath, new Date().getTime() + fileType);
				// 获取输入流
				is = file.getInputStream();
//				String uploadFileName = FileUtil.uploadFile(is, fileName, folderPath);
//				bis = new BufferedInputStream(new FileInputStream(folderPath+uploadFileName));
				bis = new BufferedInputStream(is);
				baos = new ByteArrayOutputStream();
				byte[] buff = new byte[1024*8];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					baos.write(buff, 0, bytesRead);
				}
				byte[] fileBytes = baos.toByteArray();
				System.out.println("===========" + fileBytes.length);
				String guid = request.getParameter("guid");
				System.out.println("**********" + guid);
				int chunck = Integer.parseInt(request.getParameter("chunk"));
				int chunks = Integer.parseInt(request.getParameter("chunks"));
				int chunkSize = Integer.parseInt(request.getParameter("chunkSize"));
				long totalSize = Long.parseLong(request.getParameter("size"));
				File newFile = new File(folderPath+guid+fileType);
//				synchronized (this) {
//					if (!newFile.exists()) {
//						createFile(newFile, totalSize);
//					}
//				}
					raf = new RandomAccessFile(newFile, "rw");
//					System.out.println(chunck+"---:---"+chunck * chunkSize);
					raf.seek((long)chunck * chunkSize);
					raf.write(fileBytes, 0, fileBytes.length);
				// 获取上传的文件名
				
//				// 获取上传的文件路径
//				String folderPath = "d:/uploadImage";//getRealPath("/uploadImage", request);
//				// 上传文件
//				String uploadFileName = FileUtil.uploadFile(is, fileName, folderPath);
//				// 向客户端输出信息
//				String uploadedImagePath = "/uploadImage/"+uploadFileName;
//				outJson(uploadedImagePath, response);
//				String uploadedImagePath = FtpUtil.uploadFile("/uploadImage/", fileName, is);
//				outJson(SystemConstants.FILE_SERVER_URL+uploadedImagePath, response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != bis) {
				try {
					bis.close();
					bis = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != baos) {
				try {
					baos.close();
					baos = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (raf != null) {
				try {
					raf.close();
					raf = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
