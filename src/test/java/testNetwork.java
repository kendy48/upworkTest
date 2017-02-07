import com.upwork.test.exception.NetworkException;
import com.upwork.test.exception.NetworkInitializationException;
import com.upwork.test.exception.NetworkInvalidValueException;
import com.upwork.test.exception.NetworkOutOfRangeException;
import com.upwork.test.main.Network;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kendy on 06/02/17.
 */
public class testNetwork {

    @Test(expected = NetworkInitializationException.class)
    public void createInvalidNetwork1() throws NetworkException{
        new Network(0);
    }

    @Test(expected = NetworkInitializationException.class)
    public void createInvalidNetwork2() throws NetworkException{
        new Network(-1);
    }

    @Test(expected = NetworkOutOfRangeException.class)
    public void createInvalidElement1() throws NetworkException{
        Network network = new Network(5);
        network.connect(1, 8);
    }

    @Test(expected = NetworkInvalidValueException.class)
    public void createInvalidElement2() throws NetworkException{
        Network network = new Network(5);
        network.connect(1, -3);
    }

    @Test
    public void createValidQuery1() throws NetworkException{
        Network network = new Network(10);
        network.connect(1, 2);
        network.connect(1, 9);
        network.connect(9, 3);
        network.connect(9, 7);
        network.connect(3, 4);
        network.connect(3, 5);
        network.connect(3, 6);
        network.connect(7, 6);
        network.connect(7, 8);
        network.connect(5, 8);
        assertEquals(network.query(1,8), true);
    }

    @Test
    public void createInvalidQuery1() throws NetworkException{
        Network network = new Network(20);
        //Node 1
        network.connect(1, 2);
        network.connect(1, 9);
        network.connect(9, 3);
        network.connect(9, 7);
        network.connect(3, 4);
        network.connect(3, 5);
        network.connect(3, 6);
        network.connect(7, 6);
        network.connect(7, 8);
        network.connect(5, 8);
        assertEquals(network.query(1,5), true);
        assertEquals(network.query(2,8), true);
        assertEquals(network.query(1,5), true);
        assertEquals(network.query(7,3), true);


        //Node 2
        network.connect(11, 12);
        network.connect(11, 19);
        network.connect(19, 13);
        network.connect(19, 17);
        network.connect(13, 14);
        network.connect(13, 15);
        network.connect(13, 16);
        network.connect(17, 16);
        network.connect(17, 18);
        network.connect(15, 18);
        assertEquals(network.query(11,15), true);
        assertEquals(network.query(12,18), true);
        assertEquals(network.query(11,15), true);
        assertEquals(network.query(17,13), true);

        //Cross Nodes
        assertEquals(network.query(1,15), false);
        assertEquals(network.query(2,18), false);
        assertEquals(network.query(11,5), false);
        assertEquals(network.query(17,3), false);
    }
}
