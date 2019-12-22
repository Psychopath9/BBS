package com.bbs.service.chai;

import com.bbs.dao.chai.PostDao;
import com.bbs.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDao dao;
    /**
     * 上传发布的帖子
     * @param user_id
     * @return
     */
     public int saveSubmitPost(int user_id, String post_title, String post_content, int post_top, int post_highli, Timestamp post_time, int view_number, int have_bonus, int post_point, int is_solved){
        return dao.saveSubmitPost(user_id,post_title,post_content,post_top,post_highli,post_time,view_number,have_bonus,post_point,is_solved);
    }
    /**
     * 根据帖子 id返回帖子信息
     * @param post_id
     * @return
     */
    public Post findByPostId(int post_id) {
        return dao.findByPostid(post_id);
    }

    /**
     * 根据时间降序返回所有帖子
     * @return
     */
    public List<Post> findAllByPostTime(){
        return dao.findAllByPostTime();
    }


//    /**
//     * 从传入的 posts列表中挑选出所有的置顶帖
//     * @param posts
//     * @return
//     */
//    public List<Post> selectTop(List<Post> posts) {
//        List<Post> list = new ArrayList<>();
//        posts.forEach(p->{
//            if(p.getPosttop() == 1)
//                list.add(p);
//        });
//        return list;
//    }

    /**
     * 根据浏览数降序返回帖子
     * @return
     */
    public List<Post> findAllByViewnumber(){
        return  dao.findAllByViewnumber();
    }
    /**
     * 更新内容、标题
     * @param
     * @param
     * @return
     */
    public int updatePostContent(int post_id , String post_content,String post_title){
        return dao.updatePostContent(post_id,post_content,post_title);
    }

    /**
     * 删帖
     * @param post_id
     * @return
     */
    public int deleteByPostId(int post_id){
        return dao.deleteByPostId(post_id);

    }
    /**
     * 更新帖子的置顶状态
     * @param post_id
     * @param top
     * @return
     */
    public int updateTop(int post_id,int top) {
        return dao.updateTop(post_id,top);
    }
    /**
     * 更新帖子的加精状态
     * @param post_id
     * @param high
     * @return
     */
    public int updateHighLight(int post_id,int high) {
        return dao.updateHighLight(post_id,high);
    }

    /**
     * 根据帖子标题进行模糊查询
     * @param title
     * @return
     */
    public List<Post> findByTitleLike(String title){
        return  dao.findByTitleLike(title);
    }
    /**
     * 增加帖子的浏览数
     * @param post_id
     * @return
     */
    public int updatePostView(int post_id) {
        return dao.updatePostView(post_id);
    }

    /**
     * 查询所有精华帖子通过帖子发布时间降序
     * @return
     */
    public List<Post> findAllPostHighLi(){
        return dao.findAllPostHighLightOrderByPostTimeDesc();
    }

    /**
     * 根据post_id返回浏览数
     * @param post_id
     * @return
     */

    public int findviewByPostid(int post_id){
        return dao.findviewByPostid(post_id);
    }


}
