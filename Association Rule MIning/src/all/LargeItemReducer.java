package all;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LargeItemReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
	
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context) 
			throws IOException, InterruptedException{
		int noOfOne = 0;
		int totalOnes=0;
		for (IntWritable value : values){
			noOfOne=Integer.bitCount(value.get());
			totalOnes = totalOnes + noOfOne;
		}
	
		context.write(key, new IntWritable(totalOnes));
		
	}

}
