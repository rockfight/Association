package all;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AndingMapper extends Mapper<Text,Text,Text,IntWritable>{

	@Override
	public void map(Text key, Text value, Context context) 
			throws IOException, InterruptedException {
		//String a = key.toString();
		String b = value.toString();
		String value1 = b.substring(0,3);
		String value2 = b.substring(4,7);
		int result = Integer.parseInt(value1) & Integer.parseInt(value2);
		context.write(key, new IntWritable(result));
	}
}
