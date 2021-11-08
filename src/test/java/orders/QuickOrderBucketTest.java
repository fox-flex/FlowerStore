package orders;

import delivery.DHLDeliveryStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickOrderBucketTest {
    @Test
    void OrderBucket() {
        Order order = QuickOrderBucket.OrderBucket(QuickOrderBucket.ROSE_BUCKET, 10);
        assertEquals(order.getPrice(), 703., 1e-5);
        order.setFastDelivery(true);
        assertEquals(order.getPrice(), 722.2, 1e-5);
        QuickOrderBucket.setDeliveryStrategy(new DHLDeliveryStrategy());
        order = QuickOrderBucket.OrderBucket(QuickOrderBucket.TULIP_BUCKET, 5, "yellow");
        assertEquals(order.getPrice(), 305.0, 1e-5);
    }
}
