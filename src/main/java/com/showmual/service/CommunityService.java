package com.showmual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.showmual.dao.CommunityDao;
import com.showmual.model.BoardVo;
import com.showmual.model.TotalVo;

@Service("communityService")
@Transactional
public class CommunityService {
    
	@Autowired
	CommunityDao communityDao;
	
	public List<TotalVo> listArticles(){
		List<TotalVo> articleList = communityDao.selectAllArticles();
		return articleList;
	}
	
	public TotalVo viewArticle(int boardNo) {
	    TotalVo board;
	    board = communityDao.selectArticle(boardNo);
        return board;
    }
	
	public void addArticle(BoardVo boardVo) {
		communityDao.insertNewArticle(boardVo);
	}
	
	public void editArticle(BoardVo boardVo) {
	    communityDao.updateArticle(boardVo);
    }
    
    public void removeArticle(int boardNo) {
        communityDao.deleteArticle(boardNo);
    }
}
