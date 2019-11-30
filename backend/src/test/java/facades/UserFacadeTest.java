package facades;

import entities.User;
import java.util.ArrayList;
import java.util.List;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class UserFacadeTest {

    private static EntityManagerFactory emf;
    private static UserFacade facade;

    private User user1 = new User("lars", "larsDK@mail.dk", "test123");
    private User user2 = new User("tom", "tomDK@mail.dk", "test123");
    private User user3 = new User("abu", "abuDK@mail.dk", "test123");
    private User user4 = new User("freddy", "freddyDK@mail.dk", "test123");

    public UserFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
//        emf = EMF_Creator.createEntityManagerFactory(
//                "pu",
//                "jdbc:mysql://localhost:3307/startcode_test",
//                "dev",
//                "ax2",
//                EMF_Creator.Strategy.CREATE);
//        facade = UserFacade.getUserFacade(emf);
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);

    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = UserFacade.getUserFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            //
            //GOTTA FIX THE SETUP FIGURE OUT 
            //
            em.getTransaction().begin();
            em.createQuery("delete from User").executeUpdate();
            //em.createQuery("delete from Role").executeUpdate();
//            em.createNamedQuery("DELETE FROM User").executeUpdate();
//            em.createNamedQuery("Role.deleteAllRows").executeUpdate();
//            em.createNamedQuery("CustomRecipe.deleteAll").executeUpdate();
            //em.persist(new RenameMe("Some txt", "More text"));
            //em.persist(new RenameMe("aaa", "bbb"));
            em.persist(user1);
            em.persist(user2);
            em.persist(user3);
            em.persist(user4);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void countUserTest() {
        assertEquals(4, facade.getAmount(), "Expects a amout of users added");
    }

    @Test
    public void finUserTest() {
        User user = facade.getUser("lars");
        assertEquals(user.getUserName(), "lars");
    }
    
  @Test
    public void checkListAreEqualTest(){
        List <User> users = facade.getAllUsers();
        List <User> m = new ArrayList();
        m.add(user1);
        m.add(user2);
        m.add(user3);
        m.add(user4);
        
        assertNotNull(users);
        assertNotNull(m);
        assertEquals(users.size(), m.size());
    }
    
    /*
    // -- code to change and use for user
    // also use for other code
    */
    /**
     * This method check if it is possible to get a members information by only typing their name
     */
    /*
    @Test
    public void getMemberByNameTest(){
        List <GroupMember> member = facade.getMemberByName(m3.getName());
        assertNotNull(member);
        assertEquals(member.get(0).getName(), "Ahmed");
        assertEquals(member.get(0).getColor(), "Rød");
    }
    
    
    @Test
    public void addMemberTest(){
        String name = "Caroline";
        String color = "Grøn";
        GroupMember member = facade.addMember(name, color);
        assertEquals(6, facade.getMemberCount());
        
        
    }
    */

}
