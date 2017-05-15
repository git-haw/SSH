package top.haw358.demo;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.haw358.demo.pojo.User;
import top.haw358.demo.service.UserService;

import java.util.List;

/**
 * Created by haw on 17-5-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})

public class UserServiceTest {
    private static Logger logger = Logger.getLogger(UserServiceTest.class);
    //	private ApplicationContext ac = null;
    @Autowired
    private UserService userService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (UserService) ac.getBean("userService");
//	}

    @Test
    public void test() {
        List<User> userList = userService.getAllUser();
        for(User user:userList){
            System.out.println(user.getUserName());
            logger.info(JSON.toJSONString(user));
        }

    }
}