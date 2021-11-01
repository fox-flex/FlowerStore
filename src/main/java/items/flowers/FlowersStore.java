package items.flowers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter @Setter @ToString
public class FlowersStore {
    private ArrayList<FlowerBucket> buckets = new ArrayList<>();

    public FlowersStore() {}

    public FlowersStore(ArrayList<FlowerBucket> buckets) {
        this.buckets.addAll(buckets);
    }

    public ArrayList<FlowerBucket> search(int maxPrice) {
        ArrayList<FlowerBucket> bucketsOut = new ArrayList<>();
        for (FlowerBucket bucket : buckets) {
            if (bucket.getPrice() <= maxPrice) {
                bucketsOut.add(bucket);
            }
        }
        return bucketsOut;
    }

    public void addBucket(FlowerBucket bucketNew) {
        buckets.add(bucketNew);
    }
}
