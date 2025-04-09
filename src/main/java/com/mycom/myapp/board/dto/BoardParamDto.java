package com.mycom.myapp.board.dto;


//client가 back쪽으로

// client 가 server에 요청하는 게시글 관련 전달하는 파라미터
// Controller에서 개별적인 파라미터를 사용할 수도 있지만, Dto로 자동으로 처리하는게 더 유지 보수에 편리
public class BoardParamDto {
	//목록
	private int limit;
	private int offset;
	private String searchWord;
	
	//상세
	private int boardId;
	private int userSeq;
	
	//생성자 대신 setter 사용
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	@Override
	public String toString() {
		return "BoardParamDto [limit=" + limit + ", offset=" + offset + ", searchWord=" + searchWord + ", boardId="
				+ boardId + ", userSeq=" + userSeq + "]";
	}
}
