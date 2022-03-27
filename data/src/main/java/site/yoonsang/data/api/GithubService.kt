package site.yoonsang.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import site.yoonsang.data.model.ResponseSearchedRepos

interface GithubService {

    @GET("/search/repositories")
    fun getSearchedRepos(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): ResponseSearchedRepos
}