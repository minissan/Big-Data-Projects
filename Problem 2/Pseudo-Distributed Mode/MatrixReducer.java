import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MatrixReducer extends Reducer<Text, Text, Text, Text> {
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

		String[] value;
		HashMap<Integer, Float> hashA = new HashMap<Integer, Float>();
		HashMap<Integer, Float> hashB = new HashMap<Integer, Float>();

		for (Text val : values) {
			
			value = val.toString().split(",");
			
			if (value[0].equals("A")) {
				hashA.put(Integer.parseInt(value[1]), Float.parseFloat(value[2]));
			} else {
				hashB.put(Integer.parseInt(value[1]), Float.parseFloat(value[2]));
			}
		}
		int b = Integer.parseInt(context.getConfiguration().get("b"));
		float result = 0.0f;
		float A, B;

		for (int k = 0; k < b; k++) {

			A = hashA.containsKey(k) ? hashA.get(k) : 0.0f;
			B = hashB.containsKey(k) ? hashB.get(k) : 0.0f;
			result += A * B;
		}
		if (result != 0.0f) {
			context.write(null, new Text(key.toString() + "," + Float.toString(result)));
		}
	}
}
