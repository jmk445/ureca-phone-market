package com.mycom.myapp.board.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;
import com.mycom.myapp.board.service.BoardService;
import com.mycom.myapp.user.dto.UserDto;

import jakarta.servlet.http.HttpSession;

//controller에서 하는 일 : serarchword여부 가공
@Controller
@RequestMapping("/boards")
public class BoardController {
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	@ResponseBody
	public BoardResultDto listBoard(BoardParamDto boardParamDto) { //param에서 부터 limit, offset을 추출
		BoardResultDto boardResultDto = null;
		//front를 최대한 편하게 해주어야한다.!!
		if(Strings.isEmpty(boardParamDto.getSearchWord())) { 			
			boardResultDto =boardService.listBoard(boardParamDto);
		}else {
			boardResultDto = boardService.listBoardSearchWord(boardParamDto);
		}
		return boardResultDto;
	}
	
	//Controller에서 session에 담긴 현재 조회 사용자의 userSeq를 service에 전달 
	@GetMapping("/detail/{boardId}") 
	@ResponseBody
	public BoardResultDto detailBoard(@PathVariable("boardId") Integer boardId, HttpSession session) { //param에서 부터 limit, offset을 추출
				
		BoardParamDto boardParamDto = new BoardParamDto();
		boardParamDto.setBoardId(boardId);		
		//controller에서 교통정리 즉, service에서 필요한 parameter를 추출해서 전달해주기는 해야한다. 
		int userSeq = ((UserDto)session.getAttribute("userDto")).getUserSeq();
		boardParamDto.setUserSeq(userSeq);
		return boardService.detailBoard(boardParamDto);
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public BoardResultDto insertBoard(BoardDto boardDto, HttpSession session) { //client에서 boardId, userSeq전송 X (update와 다르게)
		
		int userSeq = ((UserDto)session.getAttribute("userDto")).getUserSeq();
		
		boardDto.setUserSeq(userSeq);
		
		return boardService.insertBoard(boardDto);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public BoardResultDto updateBoard(BoardDto boardDto) { //client에서 boardId, userSeq전송 O, userSeq는 수정대상이 X (update와 다르게)
									
		return boardService.updateBoard(boardDto);
	}
	
	@GetMapping("/delete/{boardId}")
	@ResponseBody
	//client에서 boardID 전송 0, -> boardID 자동으로 mapping안되면 null 처리 시도, primitive type 으로 오류 발생 -> 근데 원래는 처음 부터 0으로 안넘어오게 하는게 맞다. 그래서 강사님도 논란이 있다고 함
	public BoardResultDto deleteBoard(@PathVariable("boardId") Integer boardId, HttpSession session) { 		
			return boardService.deleteBoard(boardId);
	}
	
	
}
