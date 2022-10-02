package repsitory;

import data.Article;
import infra.Container;
import service.ArticleService;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private int articleId =1;
    private List<Article> store= new ArrayList<>();

    public int write(String title, String body, String author) {

        articleId +=1;

        Article article = new Article(articleId,title,body,author);
        store.add(article);
        return articleId;
    }

    public Article getArticleById(int id) {
        for (Article article : store){
            if(article.getId()==id){
                return article;
            }
        }
        return null;
    }


    public void delete (Article article){
        store.remove(article);

    }

    public List<Article> getArticles() {
        return store;

    }
}

