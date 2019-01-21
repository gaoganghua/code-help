package com.code.help.swagger;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swagger")
@Api(value = "swagger测试类|用来测试swagger注解的控制器",description = "没有")
public class TestController {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="根据id获取用户json", notes="返回用户的json")
    @ApiImplicitParam(paramType="query", name = "id", value = "用户编号", required = true, dataType = "Integer")
    public String get(@RequestParam(required = true) Integer id){
        return JSON.toJSONString(new User(id, "test"));
    }
    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="根据id获取用户json", notes="返回用户的json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "score", value = "用户分数", required = true, dataType = "double")
    })
    @ApiResponse(code = 200, message = "ok", response = User.class)
    public String get(@RequestParam(required = true) double score, @RequestBody(required = true)User user){
        if(score>60){
            user.setName(user.getName()+"-ok");
        }else{
            user.setName(user.getName()+"-fail");
        }
        return JSON.toJSONString(user);
    }
}
