package xin.itdev.network.gson

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

class ListDefaultAdapter :JsonDeserializer<List<*>>{
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): List<*> {
        return if(null!=json &&json.isJsonArray){
            val newGson = Gson()
            newGson.fromJson(json, typeOfT)
        }else{
            Collections.EMPTY_LIST
        }
    }
}