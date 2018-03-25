package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	/*public BoardServiceImpl(BoardDao boardDao) { //BoardServiceImpl 생성자를 통한  BoardDao, BoardServiceImpl 객체 생성
		System.out.println("===> BoardServiceImpl 객체 생성");
		this.boardDao=boardDao;
	}*/
	
	public void insertBoard(BoardVo vo) {
		/*if(vo.getSeq()==0) {
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다."); //예외 처리에 던지기
		}*/
		boardDao.insertBoard(vo);
	}
	
	public void updateBoard(BoardVo vo) {
		boardDao.updateBoard(vo);
	}
	
	public void deleteBoard(BoardVo vo) {
		boardDao.deleteBoard(vo);
	}
	
	public BoardVo getBoard(BoardVo vo) {
		return boardDao.getBoard(vo);
	}
	
	public List<BoardVo> getBoardList(BoardVo vo) {
		return boardDao.getBoardList(vo);
	}
}
