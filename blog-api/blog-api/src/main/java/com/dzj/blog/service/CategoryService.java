package com.dzj.blog.service;

import com.dzj.blog.vo.CategoryVo;
import com.dzj.blog.vo.Result;

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result categoryDetailById(Long id);
}
