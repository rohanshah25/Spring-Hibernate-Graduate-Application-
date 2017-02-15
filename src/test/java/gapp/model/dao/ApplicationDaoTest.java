/*package gapp.model.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")


public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    ApplicationDao applicationDao;
    
    
   

    @Test
    public void listApplication()
    {
        assert applicationDao.listApplication().size() == 1;
    }
    
    @Test
    public void listSubmited()
    {
        assert applicationDao.listSubmitted().size() == 1;
    }
    
}*/