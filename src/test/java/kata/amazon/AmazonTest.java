package kata.amazon;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AmazonTest {

    @Test
    public void testBoughtItemsGetDispatchedToCustomer() throws Exception {
        Item item = new Item();
        Customer customer = new Customer();
        RecordingWarehouse recordingWarehouse = new RecordingWarehouse();
        Amazon amazon = new Amazon(recordingWarehouse);

        amazon.buy(customer, item);

        assertThat(recordingWarehouse.getRecordedDispatchedCustomer(), is(customer));
        assertThat(recordingWarehouse.getRecordedDispatchedItem(), is(item));
    }

    @Test
    public void testBoughtItemsGetDispatchedToCustomerImproved() throws Exception {
        Item item = new Item();
        Customer customer = new Customer();
        Warehouse warehouse = mock(Warehouse.class);
        Amazon amazon = new Amazon(warehouse);

        amazon.buy(customer, item);

        verify(warehouse).dispatch(customer, item);
    }

}