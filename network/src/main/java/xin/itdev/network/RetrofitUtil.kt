package xin.itdev.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import xin.itdev.network.gson.*
import java.util.concurrent.TimeUnit

/**
 * Created by jhb on 2020-01-13.
 */
object RetrofitUtil {

    private const val READ_TIMEOUT = 60L
    private const val WRITE_TIMEOUT = 60L
    private const val CONNECT_TIMEOUT = 30L

    private var mRetrofitMap = HashMap<String, Retrofit>()

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(OkHttpInterceptor())
            .build()

    }

    fun getRetrofit(baseUrl:String): Retrofit {
        return if(mRetrofitMap.containsKey(baseUrl)){
            mRetrofitMap[baseUrl] as Retrofit
        } else {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .validateEagerly(true)
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(getClient())
                .build()
                .also { mRetrofitMap[baseUrl] = it }
            mRetrofitMap[baseUrl] as Retrofit
        }

    }

    /**
     * 增加后台返回""和"null"的处理
     * 1.int=>0
     * 2.double=>0.00
     * 3.long=>0L
     *
     * @return
     */
    private fun buildGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .registerTypeAdapter(Int::class.java, IntegerDefault0Adapter())
            .registerTypeAdapter(Int::class.javaPrimitiveType, IntegerDefault0Adapter())
            .registerTypeAdapter(String::class.java, StringDefault0Adapter())
            .registerTypeAdapter(Double::class.java, DoubleDefault0Adapter())
            .registerTypeAdapter(Double::class.javaPrimitiveType, DoubleDefault0Adapter())
            .registerTypeAdapter(Long::class.java, LongDefault0Adapter())
            .registerTypeAdapter(Long::class.javaPrimitiveType, LongDefault0Adapter())
            .registerTypeAdapter(MutableList::class.java, ListDefaultAdapter())
            .registerTypeHierarchyAdapter(
                MutableList::class.java,
                ListDefaultAdapter()
            )
            .create()
    }

    inline fun <reified T> create(baseUrl:String) = getRetrofit(baseUrl).create(T::class.java)

}