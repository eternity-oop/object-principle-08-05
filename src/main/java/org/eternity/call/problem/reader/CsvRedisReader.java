package org.eternity.call.problem.reader;

import org.eternity.call.problem.calls.Call;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;
import java.util.List;

public class CsvRedisReader extends CsvReader {
    private String key;
    private JedisPool jedisPool;

    public CsvRedisReader(String key, JedisPool jedisPool) {
        super(null);
        this.key = key;
        this.jedisPool = jedisPool;
    }

    @Override
    public List<Call> read() {
        List<String> lines = readKey(key);
        return super.parse(lines);
    }

    private List<String> readKey(String path) {
        try(Jedis jedis = jedisPool.getResource()) {
            String json = jedis.get(path);
            return Arrays.stream(json.split("\\n")).toList();
        }
    }
}
