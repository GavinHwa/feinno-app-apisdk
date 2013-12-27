package thirdparty;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpengsq
 * Date: 13-9-27
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
public class JsonSerializableClass implements Serializable {
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 主要用来写log，做测试
     * @return
     * @throws SnsException
     */
    public String toJson() throws SnsException {
        try {
            return  mapper.writeValueAsString(this);
        } catch (IOException e) {
            throw new SnsException("Parse To Json Error!",e);
        }
    }

    /**
     * 主要用来写log，做测试
     * @param json
     * @return
     */
    public JsonSerializableClass fromJson(String json){
        ObjectReader reader = mapper.readerForUpdating(this);
        try {
            reader.readValue(json);
        } catch (IOException e) {
            //String hardly throw an IOException
        }
        return this;
    }
}
