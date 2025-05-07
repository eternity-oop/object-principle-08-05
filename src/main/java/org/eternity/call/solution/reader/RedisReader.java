package org.eternity.call.solution.reader;

import org.eternity.call.solution.calls.AbstractReader;
import org.eternity.call.solution.calls.Parser;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;
import java.util.List;

public class RedisReader extends AbstractReader {
    private JedisPool jedisPool;

    public RedisReader(String path, Parser parser, JedisPool jedisPool) {
        super(path, parser);
        this.jedisPool = jedisPool;
    }

    @Override
    protected List<String> readLines(String path) {
        try(Jedis jedis = jedisPool.getResource()) {
            String json = jedis.get(path);
            return Arrays.stream(json.split("\\n")).toList();
        }
    }
}
