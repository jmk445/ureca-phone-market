package com.mycom.myapp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;

@Mapper
public interface BoardDao {
	List<BoardDto> listBoard(BoardParamDto boardParamDto);// limit,offset 사용
	int listBoardTotalCount(); // 

	List<BoardDto> listBoardSearchWord(BoardParamDto boardParamDto);//limit, offset, searchWord 사용
	int listBoardSearchWordTotalCount(BoardParamDto boardParamDto);//searchWord 사용

	//상세
	BoardDto detailBoard(BoardParamDto boardParamDto); //boardId 사용
	
	
	int insertBoard(BoardDto boardDto);
	int updateBoard(BoardDto boardDto);
	int deleteBoard(int boardId);
}
