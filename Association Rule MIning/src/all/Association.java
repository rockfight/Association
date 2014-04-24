package all;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;


public class Association {

	public static void main(String[] args) throws Exception{
		if (args.length != 2){
			System.err.println("Usuage: <Input Path> <Output Path>");
			System.exit(-1);
		}
		Job job= new Job();
		job.setJarByClass(Association.class);
		job.setJobName("Association");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileInputFormat.addInputPath(job, new Path (args[1]));
		
		job.setMapperClass(AndingMapper.class);
		job.setReducerClass(LargeItemReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true) ? 0:1);
		

	}

}
