package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.service.MailService;

//@EnableAsync : 비동기방식 처리가 가능하도록 설정

@Controller
@EnableAsync
public class MailController {
	
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Inject
	private MailService mailService;
	
	// http://localhost:8088/controller/send
	@RequestMapping(value = "/send",method = RequestMethod.GET)
	public void sendMail() throws Exception {
		logger.info(" sendMail() 호출 ");
		
//		mailService.sendMail(받는 메일주소, 제목, 내용);
		//mailService.sendMail("jgt8731@kakao.com", "메일전송 테스트 메일", " 테스트 메일 내용12345 ");
		
		//mailService.preConfigSendMail("테스트 메일 내용 22222");
		//mailService.preConfigSendMail("<img src='https://ssl.pstatic.net/melona/libs/1481/1481325/db8d575126b50d1d8f70_20240311170213571.jpg'>");
		
		// 메일에 일반 텍스트가 아닌 정보를 전송(이미지/HTML)

		// 전송할 데이터설정
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html><head></head><body>");
		sb.append(" <h1> 안녕하세요 아이티윌 입니다. </h1> ");
		sb.append(" <img src='https://ssl.pstatic.net/melona/libs/1481/1481325/db8d575126b50d1d8f70_20240311170213571.jpg'>");
		sb.append("</body></html>");
		
		mailService.sendMail("needsoju7@gmail.com", "html 테스트", sb.toString());
		
		
	}
	
	
	
}
