package com.test.search.controller;

import com.test.search.common.BaseResponse;
import com.test.search.common.ResultUtils;
import com.test.search.manager.SearchFacade;
import com.test.search.model.dto.search.SearchRequest;
import com.test.search.model.vo.SearchVO;
import com.test.search.service.PictureService;
import com.test.search.service.PostService;
import com.test.search.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 图片接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/search")
@Slf4j
@CrossOrigin
public class SearchController {

    @Resource
    private UserService userService;

    @Resource
    private PostService postService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SearchFacade searchFacade;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacade.searchAll(searchRequest, request));
    }

}
