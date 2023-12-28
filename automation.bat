call hadoop jar C:/hadoop/share/hadoop/mapreduce/bda.jar /input /output3 

call hadoop fs -copyToLocal /output3/part-r-00000 C:\Users\vishn\Desktop\BDA\MaliciousURL_Tally\output\output.txt 

call hadoop fs -rm /output3/*

call hadoop fs -rmdir /output3

call python graph.py