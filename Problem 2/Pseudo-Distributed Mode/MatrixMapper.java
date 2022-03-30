import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MatrixMapper extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		Configuration conf = context.getConfiguration();

		int a = Integer.parseInt(conf.get("a"));
		int c = Integer.parseInt(conf.get("c"));

		String input = value.toString();
		String[] line = input.split(",");
		
		Text outputKey = new Text();
		Text outputValue = new Text();
		
		if (line[0].equals("A")) {
			for (int i = 0; i < c; i++) {
				outputKey.set(line[1] + "," + i);
				outputValue.set("A," + line[2] + "," + line[3]);
				context.write(outputKey, outputValue);
			}
		} else {
			for (int j = 0; j < a; j++) {
				outputKey.set(j + "," + line[2]);
				outputValue.set("B," + line[1] + "," + line[3]);
				context.write(outputKey, outputValue);
			}
		}
	}
}
