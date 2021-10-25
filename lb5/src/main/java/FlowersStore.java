
import flowers.*;
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
        for (int i=0; i<buckets.size(); ++i) {
//        for (FlowerBucket bucket : buckets) {
            if (buckets.get(i).getPrice() <= maxPrice) {
                bucketsOut.add(buckets.get(i));
            }
        }
        return bucketsOut;
    }

    public void addBucket(FlowerBucket bucketNew) {
        buckets.add(bucketNew);
    }
}
