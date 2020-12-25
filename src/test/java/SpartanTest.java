import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SpartanTest {

@Test
@Order(3)
@DisplayName("1.Bolum")
@AfterAll
    public void spartan1(){
        System.out.println("Merhaba spartan1");


        assertThat(3,is(not(4)));
        assertThat("Ahmet",is("Ahmet"));
        assertThat("Ahmet",is(equalTo("Ahmet")));
        assertThat("Ahmet",equalTo("Ahmet"));

    List<Integer> list= Arrays.asList(34,23,767,45);

    assertThat(list, hasSize(4));
    assertThat(list, not(hasItems(34,23)));





    }
@Test
@Order(2)
@DisplayName("2.Bolum")
    public void spartan2(){
        System.out.println("Merhaba spartan2");
    }
@Test
@Order(1)
@DisplayName("3.Bolum")
    public void spartan3(){
        System.out.println("Merhaba spartan3");
    }
}
