
call hadoop jar C:\Users\vishn\Desktop\BDA\URL-Access-Frequency-Analysis-with-Hadoop\target\artifactId-1.0-SNAPSHOT.jar MyDriver /input /output3 

call hadoop fs -copyToLocal /output3/part-r-00000 C:\Users\vishn\Desktop\BDA\URL-Access-Frequency-Analysis-with-Hadoop\output\output.txt 

call hadoop fs -rm /output3/*

call hadoop fs -rmdir /output3

call python graph.py