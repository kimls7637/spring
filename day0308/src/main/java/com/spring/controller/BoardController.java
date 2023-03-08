package com.spring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberVO;
import com.spring.biz.tag.TagService;
import com.spring.biz.tag.TagVO;

@Controller
public class BoardController {

	/////////////////////////////////////// 추가 /////////////////////
	@Autowired
	private BoardService boardService;
	@Autowired
	private TagService tagService;

	///////////////////////////////////////////

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String startApp() {
		System.out.println("board에 있는 main.do() 입장");
		return "main.jsp";
	}

	@RequestMapping(value = "/chat.do", method = RequestMethod.GET)
	public String chat(MemberVO vo) {
		System.out.println("board에 있는 chat.do() 입장  GET");
		return "main.do";
	}
	@RequestMapping(value = "/chat.do", method = RequestMethod.POST)
	public String chat(HttpServletRequest req, HttpServletResponse resp, HttpSession session, MemberVO vo) {
		System.out.println("board에 있는 chat.do() 입장   POST");
		if(req.getHeader("Referer") != null) {
			session.setAttribute("user", vo.getmNickname());
			System.out.println(vo.getmNickname());
			return "redirect:" + req.getHeader("Referer");
		}
		return null;
	}

	@RequestMapping(value = "/commuList.do", method = RequestMethod.GET)
	public String commuList(BoardVO bvo, Model model) {
		System.out.println("board에 있는 commuList.do 입장   GET");
		bvo.setbCate("커뮤니티");
		model.addAttribute("commuList", boardService.selectAll_cate_recent(bvo));
		return "commuList.jsp";
	}

	@RequestMapping(value = "/sharingTipList.do", method = RequestMethod.GET)
	public String sharingTipList(BoardVO bvo, Model model) {
		System.out.println("board에 있는 sharingTipList.do 입장   GET");
		bvo.setbCate("꿀팁공유");
		model.addAttribute("commuList", boardService.selectAll_cate_recent(bvo));
		return "sharingTipList.jsp";
	}

	@RequestMapping(value = "/noticeList.do", method = RequestMethod.GET)
	public String noticeList(BoardVO bvo, Model model) {
		System.out.println("board에 있는 noticeList.do 입장   GET");
		bvo.setbCate("공지사항");
		model.addAttribute("commuList", boardService.selectAll_cate_recent(bvo));
		return "noticeList.jsp";
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard(BoardVO bvo,Model model) {
		System.out.println("board에 있는 insertBoard.do 입장   GET");
		model.addAttribute("bCate", bvo.getbCate());
		
		return "insertBoard.jsp";
	}

	@RequestMapping(value = "/insertInsta.do", method = RequestMethod.POST)
	public String insertInstaBoard(BoardVO vo) {
		// 이미지 업로드
		MultipartFile uploadFile=vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			System.out.println("이미지 업로드 확인");
			String fileName=uploadFile.getOriginalFilename();
			System.out.println("파일 이름 : "+fileName);

			// 사용자의 로컬PC에 저장된 이미지를 업로드한것이기때문에,
			// 서버(프로젝트)에서 해당 이미지를 별도 관리하기위해 데이터를 복사해서 저장해야함!
			try {
				uploadFile.transferTo(new File("C:\\eclipse\\workspaces2\\day0308\\src\\main\\webapp\\images\\"+fileName));
				System.out.println("냥냥");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("시작");
		Test3 selTest = new Test3();
		selTest.crawl(vo);
		System.out.println("끝");

		return "redirect:main.do";
	}

	//---------------나의게시글---------------
	@RequestMapping(value="/myBoard.do", method=RequestMethod.GET) 
	public String myboard(BoardVO bvo,MemberVO vo,Model model) {
		System.out.println("board에 있는 sharingTipList.do 입장   GET");
		bvo.setbCate("꿀팁공유");
		model.addAttribute("myBoardList", boardService.selectAll_cate_recent(bvo));
		return "myBoard.jsp"; 
	}


	//---------------최신순---------------
	@RequestMapping(value="/recent.do", method=RequestMethod.GET) 
	public String recent(BoardVO bvo,MemberVO vo,Model model) {
		System.out.println("board에 있는 hit.do 입장   GET");
		model.addAttribute("commuList", boardService.selectAll_cate_recent(bvo));
		if(bvo.getbCate().equals("커뮤니티")) {
			return "commuList.jsp";
		}
		else if(bvo.getbCate().equals("공지사항")) {
			return "noticeList.jsp";
		}
		return "sharingTipList.jsp";
	}

	//---------------최신순---------------
	@RequestMapping(value="/hit.do", method=RequestMethod.GET) 
	public String hit(BoardVO bvo,MemberVO vo,Model model) {
		System.out.println("board에 있는 hit.do 입장   GET");
		model.addAttribute("commuList", boardService.selectAll_cate_hits(bvo));
		if(bvo.getbCate().equals("커뮤니티")) {
			return "commuList.jsp";
		}
		return "sharingTipList.jsp";
	}



	////////////////////////////////////// 추가//////////////////////////////////////
	// 입력한 게시글,tag + 리스트 출력//////////////////////////////
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardVO bvo, TagVO tvo, Model model) {
		System.out.println("BoardController에 있는 insertBoard.do 입장  POST");
		boardService.insertBoard(bvo);

		//최근게시물 셀렉원
		bvo=boardService.selectTag(bvo);	
		tvo.setTbnum(bvo.getbNum());

		// 태그 등록
		String tagcontent = (String) tvo.getTcontent();
		String[] tag = tagcontent.split(",");
		for (int i = 1; i < tag.length; i++) {
			if (i == tag.length) {
				break;
			}
			tvo.setTcontent(tag[i]);
			tagService.insertTag(tvo);
		}
		if(bvo.getbCate().equals("꿀팁공유")) {
			return "redirect:sharingTipList.do";
		}
		return "redirect:commuList.do";
	}

	/////////////////////////// 게시물 상세보기 이동///////////////////////
	@RequestMapping(value = "/commuDetail.do", method = RequestMethod.GET)
	public String selectOneBoard(BoardVO vo, TagVO tvo, Model model) {
		System.out.println("BoardController에 있는 commuDetail.do 입장  GET");

		model.addAttribute("commuList", boardService.selectOneBoard(vo));
		boardService.updateBoard(vo);
		// model.addAttribute("datas", boardService.selectAll_Tag(vo));

		return "commuDetail.jsp";
	}


	//////////////////////////////////////////////// 추가/////////////////////////////////
	// 해시태그 찾기
	@RequestMapping(value = "/searchTag.do")
	public String searchTag(BoardVO bvo, Model model, HttpServletRequest request) {
		System.out.println("searchTag() 입장");
		// 파라미터에있는 값을 bid에 세팅

		// 멤버변수 tcontent가 없기때문에 값을 추가해줌
		String tagcontent = request.getParameter("태그값 name");
		System.out.println("searchTag()의 로그: " + tagcontent);
		bvo.setbContent(tagcontent);

		// model.addAttribute(tagcontent, boardService.tag의 전체 출력);
		// model.addAttribute("datas", boardService.selectAllTag(vo));
		return "commuList.do";
	}
	////////////////////////////////////////////////////////////////////////////////
	
	

}