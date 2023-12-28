import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private final static LongWritable one = new LongWritable(1);
    private Text urlText = new Text();

    private final Pattern urlPattern = Pattern.compile("\"GET ([^\"]+)\"");

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        Matcher matcher = urlPattern.matcher(line);

        if (matcher.find()) {
            String url = matcher.group(1);
            urlText.set(url);
            context.write(urlText, one);
        }
    }
}

