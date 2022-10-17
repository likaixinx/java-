package com.jgs.pojo;

/**
 * @ClassName: com.jgs.pojo.Page
 * @author: likaixin
 * @create: 2022年10月17日 12:10
 * @description:
 */
public class Page {
    private Long total;//获取总条数
    private Integer pages;//获取总页数
    private Integer pageNum;//获取当前页
    private Integer pageSize;//获取每页显示条数
    private boolean isFirstPage;//获取是否第一页
    private boolean isLastPage;//获取是否是最后一页

    public Page() {
    }

    public Page(Long total, Integer pages, Integer pageNum, Integer pageSize, boolean isFirstPage, boolean isLastPage) {
        this.total = total;
        this.pages = pages;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", pages=" + pages +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", isFirstPage=" + isFirstPage +
                ", isLastPage=" + isLastPage +
                '}';
    }
}
