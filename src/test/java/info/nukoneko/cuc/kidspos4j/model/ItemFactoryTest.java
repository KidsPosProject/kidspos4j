package info.nukoneko.cuc.kidspos4j.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemFactoryTest {
    @Before
    public void setUp() throws Exception {
        ItemFactory.getInstance().truncate();
    }

    @After
    public void tearDown() throws Exception {
        ItemFactory.getInstance().truncate();
    }

    @Test
    public void getInstance() throws Exception {
        // insert
//        assert ItemFactory.getInstance() != null;
    }
}