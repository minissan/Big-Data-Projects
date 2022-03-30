The project performs 2 problems both in Standalone mode & pseudo-cluster mode. Problem 1 is word-count problem and Problem 2 is matrix-vector multiplication problem.

Matrix input format: `"<A>,<row num>,<col num>,<element>"` and Vector input format: `"<B>,<row num>,<col num>,<element>"`.

`Matrix Dimension: 1000 * 1000` ,
`Vector Dimension: 1000 * 1`

Matrix and vector has same input file: input.txt

The output and the time comparison have been verified by a serial algorithm. Hadoop map-reduced algorithm & serial algorithm exceuted the same output. 


Serial algorithm's execution time: 1569 ms

Hadoop job counters:

Total time spent by all maps in occupied slots (ms)=4498.
Total time spent by all reduces in occupied slots (ms)=3618.
Total time spent by all map tasks (ms)=4498.
Total time spent by all reduced tasks (ms)=3618.
Total vcore-miliseconds taken by all map tasks=4498.
Total vcore-miliseconds taken by all reduce tasks=3618.
Total megabyte-miliseconds taken by all map tasks=4605952.
Total megabyte-miliseconds taken by all reduce tasks=3704832.

Hadoop map-reduced algorithm execution time is longer than serial algorithm
