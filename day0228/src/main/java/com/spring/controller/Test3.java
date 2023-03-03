package com.spring.controller;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.spring.biz.board.BoardVO;
 
public class Test3 {
 
    // WebDriver
    private WebDriver driver;
    
    // Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Program Files\\chromedriver.exe";
    
    // URL
    private String base_url;
    
    private WebElement webElement;
    
    public Test3() {
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.instagram.com/";
    }
 
    public void crawl(BoardVO vo) {
 
    	System.out.println("전달받은아이디" + vo.getWriter());
    	System.out.println("전달받은비밀번호" + vo.getTitle());
    	System.out.println("전달받은콘텐츠" + vo.getContent());
    	System.out.println("전달받은파일" + vo.getUploadFile().getOriginalFilename());
    	
        try {
            driver.get(base_url);

            // 아이디, 비밀번호 입력
            Thread.sleep(2000);
            List<WebElement> ls = driver.findElements(By.cssSelector("._aa4b"));
//          ls.get(0).sendKeys("kimls0829o@gmail.com");
//          ls.get(1).sendKeys("zhfldk123");
            ls.get(0).sendKeys(vo.getWriter());
            ls.get(1).sendKeys(vo.getTitle());
            Thread.sleep(2000);
            
            // 로그인버튼 클릭
            ls = driver.findElements(By.cssSelector("._acap"));
            ls.get(0).click();
            Thread.sleep(5000);
            
            // 게시글작성버튼 클릭
            ls = driver.findElements(By.cssSelector(".x1i10hfl"));  
            ls.get(7).click();
            Thread.sleep(3000);
            
            // 파일첨부
            ls = driver.findElements(By.cssSelector("._ac69"));
//          String filePath = "C:\\Users\\young\\Desktop\\금강.png";
            String filePath = "C:\\eclipse\\workspaces2\\day0228\\src\\main\\webapp\\images\\" + vo.getUploadFile().getOriginalFilename();
            ls.get(0).sendKeys(filePath);
            Thread.sleep(2000);
            
            // 다음버튼 클릭
            ls = driver.findElements(By.cssSelector("._acan._acao._acas._aj1-"));
            ls.get(ls.size()-4).click();
            Thread.sleep(2000);
            
            // 다음버튼 클릭
            ls = driver.findElements(By.cssSelector("._acan._acao._acas._aj1-"));
            ls.get(ls.size()-13).click();
            Thread.sleep(2000);
            
            // 글 작성
            ls = driver.findElements(By.cssSelector(".xw2csxc"));
//          ls.get(2).sendKeys("안녕");
            ls.get(2).sendKeys(vo.getContent());
            Thread.sleep(2000);
            
            // 공유버튼 클릭
            ls = driver.findElements(By.cssSelector("._acan._acao._acas._aj1-"));
            ls.get(ls.size()-1).click();
            Thread.sleep(2000);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}