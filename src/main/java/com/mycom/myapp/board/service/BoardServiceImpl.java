package com.mycom.myapp.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.board.dao.BoardDao;
import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;


@Service
public class BoardServiceImpl implements BoardService{

	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao=boardDao;
	}
	
	//list의 service에서 하는 것 : 예외처리 가공 , resultDto 가공(boardDto의 list에서 resultDto로 가공 return)
	@Override
	public BoardResultDto listBoard(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		//예외 처리
		//처리과정 중 오류 발생??? -> 되게 다양한 방법이 존재. 
		//우리는 service에서 try catch로 처리
		// 1. 직접 제어 -> 사용
		// 2. spring framework에 처리 의뢰:/error 를 매핑하는 것
		
		try {
			//BoardController는 BoardSErvice의 listBoard() 1회 호출
			//BoardService 는 BoardDao의 listBoard()와 listBoardTotalCount() 2개 호출
			List<BoardDto> list = boardDao.listBoard(boardParamDto);			
			boardResultDto.setList(list);
			boardResultDto.setCount(boardDao.listBoardTotalCount());
			boardResultDto.setResult("success");
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			List<BoardDto> list = boardDao.listBoardSearchWord(boardParamDto);			
			boardResultDto.setList(list);
			boardResultDto.setCount(boardDao.listBoardSearchWordTotalCount(boardParamDto));;
			boardResultDto.setResult("success");
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
	}
	
	
	//detail의 service에서하는 것 게시글 상세 정보 + 조회수 처리 
	@Override
	public BoardResultDto detailBoard(BoardParamDto boardParamDto) {
				
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			//조회수 처리
			
			//게시글 상세 정보
			BoardDto boardDto = boardDao.detailBoard(boardParamDto);
			
			System.out.println(boardDto.getUserSeq() + " " + boardParamDto.getUserSeq());
			//sameUser처리
			if(boardDto.getUserSeq() == boardParamDto.getUserSeq()) {
				boardDto.setSameUser(true);
			}else {
				boardDto.setSameUser(false);
			}
			
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult("success");
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
		
	}
	
	@Override
	public BoardResultDto insertBoard(BoardDto boardDto) {
		
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			int ret = boardDao.insertBoard(boardDto);
			
			if(ret == 1) boardResultDto.setResult("success");
			else boardResultDto.setResult("fail");
						
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
		
	}

	@Override
	public BoardResultDto updateBoard(BoardDto boardDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			int ret = boardDao.updateBoard(boardDto);
			
			if(ret == 1) boardResultDto.setResult("success");
			else boardResultDto.setResult("fail");						
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto deleteBoard(int boardId) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			int ret = boardDao.deleteBoard(boardId);			
			if(ret == 1) boardResultDto.setResult("success");
			else boardResultDto.setResult("fail");		
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult("fail");
		}
		
		return boardResultDto;
				
	}
	
}
