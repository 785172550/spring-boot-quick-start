package Kenneth.dao;

import Kenneth.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Created by Administrator on 2017/2/26.
 *
 */
public interface PostRepository extends JpaRepository<Post, Long> {


    /**
     *  it just a test for update. the sql is works!
     * @param id
     * @param title
     * @param content
     * @return
     */
    @Query(value = "update post p set p.title =?2 , p.content =?3 where p.id =?1", nativeQuery = true)
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    int updateUserById(@Param("id") Long id,
                       @Param("title") String title,
                       @Param("content") String content);
}
