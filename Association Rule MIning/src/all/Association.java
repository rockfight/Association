package all;

import org.apache.hadoop.io.IntWritable;


public class Association {

	public static void main(String[] args) {
		AndEr ander = new AndEr();
		IntWritable int1 = new IntWritable(7);
		IntWritable int2 = new IntWritable(9);
		ander.map(int1,int2);

	}

}
