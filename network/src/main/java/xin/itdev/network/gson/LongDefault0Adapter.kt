package xin.itdev.network.gson

import com.google.gson.*

import java.lang.reflect.Type

/**
 * File descripition:long=>
 *
 * @author Administrator    对返回值为空处理
 * @date 2018/5/21
 */

class LongDefault0Adapter : JsonSerializer<Long>, JsonDeserializer<Long> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Long? {
        try {
            if (json.asString == "" || json.asString == "null") {//定义为long类型,如果后台返回""或者null,则返回0
                return 0L
            }
        } catch (ignore: Exception) {
        }

        try {
            return json.asLong
        } catch (e: NumberFormatException) {
            throw JsonSyntaxException(e)
        }

    }

    override fun serialize(src: Long?, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src!!)
    }
}
