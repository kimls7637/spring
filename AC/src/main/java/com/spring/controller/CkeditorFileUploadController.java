package com.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

@Controller
public class CkeditorFileUploadController {

	@PostMapping("/fileupload.do")
    public void fileUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile, MultipartFile upload) throws Exception{
        
        OutputStream out = null;
        PrintWriter printWriter = null;
        
        //인코딩
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        try{
            
            //파일 이름 가져오기
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();
           
            
            //이미지 경로 생성
            String path = request.getSession().getServletContext().getRealPath("./upload");
            System.out.println(path);
            String ckUploadPath = path + "\\" + fileName;
            System.out.println(ckUploadPath);
            File folder = new File(path);
            
            //해당 디렉토리 확인
            if(!folder.exists()){
                try{
                    folder.mkdirs(); // 폴더 생성
                }catch(Exception e){
                    e.getStackTrace();
                }
            }
            
            out = new FileOutputStream(new File(ckUploadPath));
            out.write(bytes);
            out.flush(); // outputStram에 저장된 데이터를 전송하고 초기화
            
            printWriter = response.getWriter();
//            printWriter.println("./upload/"+fileName);
            
            JsonObject json = new JsonObject();
            json.addProperty("uploaded", 1);
            json.addProperty("fileName", fileName);
            json.addProperty("url", "./upload/"+fileName);
            
            printWriter.println(json);
            
            printWriter.flush();
            
        }catch(IOException e){
            e.printStackTrace();
        } finally {
        	out.close();
        	printWriter.close();
         }



//	public String fileUpload(HttpServletRequest request, HttpServletResponse response,
//			MultipartHttpServletRequest multiFile) throws IOException {
//		//Json 객체 생성
//		JsonObject json = new JsonObject();
//		// Json 객체를 출력하기 위해 PrintWriter 생성
//		PrintWriter printWriter = null;
//		OutputStream out = null;
//		//파일을 가져오기 위해 MultipartHttpServletRequest 의 getFile 메서드 사용
//		MultipartFile file = multiFile.getFile("webapp/upload");
//		System.out.println("으갸갸ㅑ갸갸갸갸갸갸ㅑ");
//		System.out.println(file);
//		//파일이 비어있지 않고(비어 있다면 null 반환)
//		if (file != null) {
//			// 파일 사이즈가 0보다 크고, 파일이름이 공백이 아닐때
//			if (file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
//				if (file.getContentType().toLowerCase().startsWith("image/")) {
//
//					try {
//						//파일 이름 설정
//						String fileName = file.getName();
//						//바이트 타입설정
//						byte[] bytes;
//						//파일을 바이트 타입으로 변경
//						bytes = file.getBytes();
//						//파일이 실제로 저장되는 경로 
//						String uploadPath = request.getSession().getServletContext().getRealPath("/resources/ckimage/");
//						//저장되는 파일에 경로 설정
//						File uploadFile = new File(uploadPath);
//						if (!uploadFile.exists()) {
//							uploadFile.mkdirs();
//						}
//						//파일이름을 랜덤하게 생성
//						fileName = UUID.randomUUID().toString();
//						//업로드 경로 + 파일이름을 줘서  데이터를 서버에 전송
//						uploadPath = uploadPath + "/" + fileName;
//						out = new FileOutputStream(new File(uploadPath));
//						out.write(bytes);
//						
//						//클라이언트에 이벤트 추가
//						printWriter = response.getWriter();
//						response.setContentType("text/html");
//						
//						//파일이 연결되는 Url 주소 설정
//						String fileUrl = request.getContextPath() + "/resources/ckimage/" + fileName;
//						
//						//생성된 jason 객체를 이용해 파일 업로드 + 이름 + 주소를 CkEditor에 전송
//						json.addProperty("uploaded", 1);
//						json.addProperty("fileName", fileName);
//						json.addProperty("url", fileUrl);
//						printWriter.println(json);
//					} catch (IOException e) {
//						e.printStackTrace();
//					} finally {
//						if(out !=null) {
//							out.close();
//						}
//						if(printWriter != null) {
//							printWriter.close();
//						}
//					}
//				}
//			}
//		}
//		System.out.println("으갸갸ㅑ갸갸갸갸갸갸ㅑ");
//			return null;
//	}
	}
}