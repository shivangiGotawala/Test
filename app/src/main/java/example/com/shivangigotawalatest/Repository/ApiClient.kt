package example.com.shivangigotawalatest.Repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? = null

    val client: Retrofit
        get() {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            retrofit = Retrofit.Builder()
                    .baseUrl("https://api.androidhive.info")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit as Retrofit
        }
}
