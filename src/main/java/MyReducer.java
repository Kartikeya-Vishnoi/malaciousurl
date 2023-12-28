import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    private LongWritable result = new LongWritable();

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {
        long sum = 0;

        // Sum up the counts for the same URL
        for (LongWritable value : values) {
            sum += value.get();
        }

        // Emit the result for the URL
        result.set(sum);
        context.write(key, result);
    }
}
