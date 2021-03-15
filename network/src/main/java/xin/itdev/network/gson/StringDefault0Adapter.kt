package xin.itdev.network.gson

import com.google.gson.*

import java.lang.reflect.Type

/**
 * File descripition:double=>
 *
 * @author Administrator    对返回值为空处理
 * @date 2018/5/21
 */

class StringDefault0Adapter : JsonSerializer<String>, JsonDeserializer<String> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): String? {
        try {
            if (json.asString == "null") {//定义为int类型,如果后台返回""或者null,则返回0
                return ""
            }
        } catch (ignore: Exception) {
        }

        try {
            return json.asString
        } catch (e: NumberFormatException) {
            throw JsonSyntaxException(e)
        }

    }

    override fun serialize(src: String?, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src!!)
    }
}
