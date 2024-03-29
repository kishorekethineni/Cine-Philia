package com.example.cinephilia;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public class BloggerApi {

   // public static final String key = "AIzaSyAVgAw1TDa-mZzcr18-3FKXAKAXEIyubM0";
   public static final String key = "AIzaSyDGEFZDZwFSXJdwABAoIEi8EwfaNmVpmTA";
    public static final String url = "https://www.googleapis.com/blogger/v3/blogs/5561046056388002330/posts/";

    public static PostService postService = null;

    public static PostService getService()
    {
        if(postService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService {
        @GET
        Call<PostList> getPostList(@Url String url);
    }


}
