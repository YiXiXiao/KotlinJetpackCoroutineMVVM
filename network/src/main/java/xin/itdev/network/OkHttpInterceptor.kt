package xin.itdev.network

import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import xin.itdev.base.utils.log
import java.nio.charset.Charset
import kotlin.text.Charsets.UTF_8

class OkHttpInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Content-Type", "application/json;charset=UTF-8")

        val request = builder.build()
        val startTime = System.currentTimeMillis()
        val response = chain.proceed(request)
        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        val mediaType = response.body!!.contentType()
        val content = response.body!!.string()
        Logger.wtf("----------Request Start----------------")
        (
            """
                url:${request.url}
                method : ${request.method}
                headers : ${request.headers}
                HttpStatus : ${response.code}
                request-body:
                """.trimIndent() + getParams(
                request.body
            )
        ).log()
        "response: $content".log()
        Logger.wtf("----------Request End:" + duration + "毫秒----------")

        return response.newBuilder()
            .body(ResponseBody.create(mediaType, content))
            .build()
    }

    private fun getParams(body: RequestBody?): String? {
        return if (body != null) {
            val buffer = Buffer()
            try {
                body.writeTo(buffer)
                var charset = Charset.forName("UTF-8")
                val contentType = body.contentType()
                if (contentType != null) {
                    charset = contentType.charset(UTF_8)
                }
                buffer.readString(charset!!)
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        } else {
            ""
        }
    }
}