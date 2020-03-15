package com.lambda2.course2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

public class demo {
    public static void main(String[] args) {
        try(Stream<String> stream1= Files.lines(Paths.get("files/page1.txt"));
            Stream<String> stream2= Files.lines(Paths.get("files/page2.txt"))) {
           /* System.out.println("Stream 1 : " + stream1.count());
            System.out.println("Stream 2 : " + stream2.count());*/

            Stream<Stream<String>> streamOfStreams = Stream.of(stream1, stream2);
            Stream<String> streamOfLines = streamOfStreams.flatMap(Function.identity());


            //System.out.println("#lines " + streamOfLines.count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
