package com.example.bks.jsonparsing.activity.Respond;


import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;


public class MovieListing {




    @SerializedName("page")
    private Integer page;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_results")
    private Integer totalResults;

    @SerializedName("results")
    private ArrayList<Result> results = new ArrayList<>();

    @SerializedName("dates")
    private Dates dates;

    //return page
    public Integer getPage(){
        return page;
    }

    public void setPage(Integer page){
        this.page = page;
    }

    //return results
    public ArrayList<Result> getResults(){
        return results;
    }

    public void setResults(ArrayList<Result> results){
        this.results = results;
    }

    public Dates getDates(){
        return dates;
    }

    public void setDates(Dates dates){
        this.dates = dates;
    }

    public Integer getTotalPages(){
        return totalPages;
    }

    public void setTotalPages(Integer totalPages){
        this.totalPages = totalPages;
    }

    public Integer getTotalResults(){
        return totalResults;
    }

    public void setTotalResults(Integer totalResults){
        this.totalResults = totalResults;
    }

    protected MovieListing(){

    }
}
