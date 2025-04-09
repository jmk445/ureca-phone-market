package com.mycom.myapp.board.service;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;

public interface BoardService {
	
	BoardResultDto listBoard(BoardParamDto boardParamDto); 
	BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto);
	BoardResultDto detailBoard(BoardParamDto boardParamDto);
	BoardResultDto insertBoard(BoardDto boardDto);
	BoardResultDto updateBoard(BoardDto boardDto);
	BoardResultDto deleteBoard(int boardId);
}
