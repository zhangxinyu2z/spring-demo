import com.z2xinyu.mvc.mybatis.dao.ItemsMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Arnoer
 * @since 2022/10/8 14:48
 */
//@RunWith(value = SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ItemsMapperTest {
//
//    @Autowired
//    private ItemsMapper itemsMapper;

    @Test
    public void selectAll() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsMapper bean = classPathXmlApplicationContext.getBean(ItemsMapper.class);
        bean.selectAll();
    }
}