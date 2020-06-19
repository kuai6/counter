# the Counter service 

### About this service 
This service increments internal value per each http get request with Redis as backend storage. 

### Example

```
$ curl "http://127.0.0.1:8080/api/v1/"
{"id":1}
$ curl "http://127.0.0.1:8080/api/v1/"
{"id":2}
```

### Apache benchmark testing
This service tested on my laptop:  
 Intel(R) Core(TM) i7-9750H CPU @ 2.60GHz 6 Cores 12 threads  
 16 GB RAM  
 NVMe SSD  
 
```
ab -n 1000000 -c 12 http://127.0.0.1:8080/api/v1/
This is ApacheBench, Version 2.3 <$Revision: 1807734 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 127.0.0.1 (be patient)
Completed 100000 requests
Completed 200000 requests
Completed 300000 requests
Completed 400000 requests
Completed 500000 requests
Completed 600000 requests
Completed 700000 requests
Completed 800000 requests
Completed 900000 requests
Completed 1000000 requests
Finished 1000000 requests


Server Software:        
Server Hostname:        127.0.0.1
Server Port:            8080

Document Path:          /api/v1/
Document Length:        14 bytes

Concurrency Level:      12
Time taken for tests:   99.889 seconds
Complete requests:      1000000
Failed requests:        0
Total transferred:      119000000 bytes
HTML transferred:       14000000 bytes
Requests per second:    10011.16 [#/sec] (mean)
Time per request:       1.199 [ms] (mean)
Time per request:       0.100 [ms] (mean, across all concurrent requests)
Transfer rate:          1163.41 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       4
Processing:     0    1   0.4      1      42
Waiting:        0    1   0.4      1      42
Total:          1    1   0.4      1      43

Percentage of the requests served within a certain time (ms)
  50%      1
  66%      1
  75%      1
  80%      1
  90%      2
  95%      2
  98%      2
  99%      2
 100%     43 (longest request)

```