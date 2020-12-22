package tp1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Arrays;

public class Map extends Mapper<LongWritable,Text,Text,Text> {
    Text originalWord= new Text();
    Text sortedWord= new Text();
    public void map(LongWritable key, Text value, Context context)
            throws IOException,InterruptedException {

        String word = value.toString();
        char [] charArray=word.toCharArray();
        Arrays.sort(charArray);

        String s= new String(charArray);

        originalWord.set(word);
        sortedWord.set(s);
        context.write(sortedWord,originalWord);
    }

}
