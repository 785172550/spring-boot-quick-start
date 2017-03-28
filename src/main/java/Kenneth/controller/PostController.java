package Kenneth.controller;

import Kenneth.dao.PostRepository;
import Kenneth.model.Post;
import Kenneth.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/2/26.
 *
 */

@Controller
public class PostController {

    // org.slf4j.Logger 的日志
    private static Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public PostRepository postRepository;

    @GetMapping(value = "/")
    public String index(Model model) {
        //model.addAttribute("posts",postRepository.findAll());
        return "index";
    }

//    @ResponseBody
//    @GetMapping(value = "/posts/createPage")
//    public String createPage() {
//        return "create";
//    }

    // add post
    @PostMapping(value = "/post")
    @ResponseBody
    public Object createPost(@RequestParam("title") String title,
                             @RequestParam("content") String content) {
        Post post = new Post(title, content);
        postRepository.save(post);
        return postOne(post.getId());
    }

    // delete post
    @DeleteMapping(value = "/post/{id}")
    @ResponseBody
    public Object deletePostById(@PathVariable("id") Long id) {
        postRepository.delete(id);
        return new Result.Builder<Post>().setStatus(201).setMsg("成功删除").build();
    }

    //edit post
    @PutMapping(value = "/post/{id}")
    @ResponseBody
    public Object editPostById(@PathVariable Long id,
                               @RequestParam("title") String title,
                               @RequestParam("content") String content){
        Post post = postRepository.findOne(id);
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);
//          int i = postRepository.updateUserById(id,title,content);

        return new Result.Builder<Post>().setStatus(202).setMsg("成功修改")
                .setContent(postRepository.findOne(id))
                .build();
    }

    // query post
    @GetMapping(value = "/post/{id}")
    @ResponseBody
    public Object postOne(@PathVariable("id") long id) {
        return new Result.Builder<Post>().setStatus(200).setMsg("成功查询")
                .setContent(postRepository.findOne(id))
                .build();
    }

    @RequestMapping("/posts")
    @ResponseBody
    public Object listAll(){
        return new Result.Builder<List<Post>>().setStatus(202).setContent(postRepository.findAll())
                .build();

    }

}
