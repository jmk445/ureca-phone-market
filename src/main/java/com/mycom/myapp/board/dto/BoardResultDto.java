package com.mycom.myapp.board.dto;


//back에서 client쪽으로
import java.util.List;

public class BoardResultDto { //이제 여기에 client가 필요로 하는 모든 것을 담으려고 한다.
	private String result; // 등록, 수정, 삭제 작업 성공, 실패
	private List<BoardDto> list; //목록 요청에 대한 결과
	private BoardDto dto;//상세 요청에 대한 결과
	private int count; //목록 데이터 건수
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<BoardDto> getList() {
		return list;
	}
	public void setList(List<BoardDto> list) {
		this.list = list;
	}
	public BoardDto getDto() {
		return dto;
	}
	public void setDto(BoardDto dto) {
		this.dto = dto;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "BoardResultDto [result=" + result + ", list=" + list + ", dto=" + dto + ", count=" + count + "]";
	}
	
}
