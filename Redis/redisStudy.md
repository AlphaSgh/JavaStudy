```bash
keys *
flushdb
flushall
set name ssgh
set age 10
get name
move name 1
exists name
expire name 10
type name
set key1 ssgh
append key1 hello
strlen name

set views 0
incr views
decr views 
incrby views 10
decrby views 10

set key1 "ssdhggjggha"
getrange key1 0 3  ###[0,3]
getrange key1 0 -1

set key2 abcdef
setrange key2 3 aaa

setex key3 30 hello
setnx mykey redis ##如果mykey不存在创建mykey

mset k1 v1 k2 v2 k3 v3
mget k1 k2 k3

mset user:1:name "ssgh" user:1:age 20
mget user:1:name user:1:age

getset db redis ##如果不存在就设置
```

```shell
```

