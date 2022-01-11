package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.Models.Article
import com.androiddevs.mvvmnewsapp.Models.NewsResponse
import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import retrofit2.Response

class NewsRepository (
    val db : ArticleDatabase
        )
{
    suspend fun getBreakingNews( country : String , pageNumber : Int) : Response<NewsResponse> {
        return RetrofitInstance.api.getBreakingNews()
    }

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}