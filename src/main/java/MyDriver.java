import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class MyDriver {
  
    public static void main(String[] args) throws Exception {
        // Check if the number of command line arguments is correct
        // if (args.length != 2) {
        //     System.err.println("Usage: MyDriver <input path> <output path> fghsdfg" + args.length);
        //     System.exit(-1);
        // }

        // Create a new Hadoop job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "My MapReduce Job");

        // Set the main class
        job.setJarByClass(MyDriver.class);

        // Set the Mapper and Reducer classes
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);

        // Set the input and output formats
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        // Set the output key and value classes
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // Set the input and output paths
        TextInputFormat.addInputPath(job, new Path(args[0]));
        TextOutputFormat.setOutputPath(job, new Path(args[1]));

        // Wait for the job to complete
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

