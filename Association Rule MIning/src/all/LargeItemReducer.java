package all;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LargeItemReducer extends Reducer<Text,IntWritable,Text,Text> {
	
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context) 
			throws IOException, InterruptedException{
		int noOfOne = 0;
		for (IntWritable value : values){
			
		}
		
	}

}
