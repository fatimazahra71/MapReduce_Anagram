package tp1;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.StringTokenizer;

public class Reduce extends Reducer<Text,Text,Text,Text> {
    Text valuesList= new Text();

    public void reduce(Text key, Iterable<Text> values,Context context)
            throws IOException,InterruptedException {

        String lesAnagrammes="";
        for(Text v :values)
        {
            lesAnagrammes= lesAnagrammes+ v.toString() + "~";
        }
        StringTokenizer token=new StringTokenizer(lesAnagrammes,"~");

        if(token.countTokens()>=2)
        {
            lesAnagrammes=lesAnagrammes.replace("~", ",");
            System.out.println(lesAnagrammes);
            valuesList.set(lesAnagrammes);
            context.write(key, valuesList);
        }

    }

}
