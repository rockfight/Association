package all;


import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
//import org.apache.hadoop.util.Tool;
//import org.apache.hadoop.util.ToolRunner;


public class Association  {
	
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration() ;
		Job job = new Job(conf, "ExampleJob") ;
		job.setJarByClass(Association.class) ;
		job.setMapperClass(AndingMapper.class) ;
		job.setReducerClass(LargeItemReducer.class) ;
		job.setOutputKeyClass(Text.class) ;
		job.setOutputValueClass(IntWritable.class) ;
		KeyValueTextInputFormat.addInputPath(job, new Path(args[0])) ;
		TextOutputFormat.setOutputPath(job, new Path(args[1]));
		// Execute the job and wait for it to complete
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}

	