package com.prahlad.rest.dto;

import java.util.List;

public class PageResponseDto<T> 
{

    private List<T> content;
    private int page;
    private int size;
    private int totalElements;
    private int totalPages;

    public PageResponseDto(List<T> content, int page, int size,
                           int totalElements, int totalPages) 
    {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<T> getContent() 
    {
    	return content; 
    }
    public int getPage() 
    {
    	return page; 
    }
    public int getSize() 
    {
    	return size; 
    }
    public int getTotalElements() 
    {
    	return totalElements; 
    }
    public int getTotalPages() 
    {
    	return totalPages; 
    }
}