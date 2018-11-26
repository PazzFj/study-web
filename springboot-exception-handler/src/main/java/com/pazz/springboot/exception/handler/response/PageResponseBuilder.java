package com.pazz.springboot.exception.handler.response;

import lombok.Data;

/**
 * @author 彭坚
 * @create 2018/8/23 21:21
 * @see PageResponseBuilder 分页的建造者模式
 */
@Data
public class PageResponseBuilder extends ResponseBuilder {

    /**
     * 总数
     */
    private long totalCount;

    public final PageResponseBuilder setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public static PageResponseBuilder create() {
        return new PageResponseBuilder();
    }

    /**
     * 功能描述: 建造者模式 PageResponse
     *
     * @author 彭坚
     * @date 2018/8/23 21:33
     * @since V1.0.0
     */
    public PageResponse bulid() {
        PageResponse pageResponse = new PageResponse();
        super.build(pageResponse);
        pageResponse.setTotalCount(this.totalCount);
        return pageResponse;
    }

    /**
     * 功能描述: 建造者模式 PageResponse
     *
     * @author 彭坚
     * @date 2018/8/23 21:30
     * @since V1.0.0
     */
    public PageResponse buildSuccess(Object result, long totalCount) {
        this.setTotalCount(totalCount);
        return (PageResponse) super.builderSuccess(result);
    }

}
