package sec04.brd01;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public List<ArticleVO> listArticles(){
		List<ArticlesVO> articlesList= boardDAO.selectAllArticles();
		return articlesList;
	}
}
