package top.haw358.demo;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import top.haw358.demo.controller.HelloController;
import top.haw358.demo.pojo.User;
import top.haw358.demo.service.UserService;

import java.util.List;

/**
 * Created by haw on 17-5-14.
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
@WebAppConfiguration

public class UserServiceTest {
    private static Logger logger = Logger.getLogger(UserServiceTest.class);
    //	private ApplicationContext ac = null;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

//    @Autowired
//    private UserService userService = null;

    @Autowired
    private HelloController helloController;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (UserService) ac.getBean("userService");
//	}

    @Before
    public void setUp() throws Exception{
//        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Test
//    public void test() {
//        List<User> userList = userService.getAllUser();
//        for(User user:userList){
//            System.out.println(user.getUserName());
//            logger.info(JSON.toJSONString(user));
//        }
//
//    }

    @Test
    public void testShowView() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("showView.do"))
                .andExpect(MockMvcResultMatchers.view().name("demo"))
                .andReturn();
    }
}