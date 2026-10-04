package com.xxlionxx.prometey.di

import com.xxlionxx.prometey.data.remote.LocalImageDataUrlProvider
import com.xxlionxx.prometey.data.remote.api.OpenAIApi
import com.xxlionxx.prometey.domain.repository.SecureStorageRepository
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.xxlionxx.prometey.data.remote.api.GeminiApi
import java.util.concurrent.TimeUnit
import java.io.IOException

private const val OPENAI_BASE_URL = "https://api.openai.com/"
private const val OPENAI_API_KEY = "openai_api_key"

private const val GEMINI_BASE_URL =
    "https://generativelanguage.googleapis.com/"

private const val GEMINI_API_KEY =
    "gemini_api_key"

val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        val secureStorageRepository =
            get<SecureStorageRepository>()

        OkHttpClient.Builder()
            .addInterceptor { chain ->

                val apiKey = runBlocking {
                    secureStorageRepository.get(OPENAI_API_KEY)
                        ?.trim()
                }

                if (apiKey.isNullOrBlank()) {
                    throw IOException(
                        "OpenAI API key is not configured"
                    )
                }

                val request = chain.request()
                    .newBuilder()
                    .addHeader(
                        "Authorization",
                        "Bearer $apiKey"
                    )
                    .addHeader(
                        "Content-Type",
                        "application/json"
                    )
                    .build()

                chain.proceed(request)
            }
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(OPENAI_BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    single<OpenAIApi> {
        get<Retrofit>().create(OpenAIApi::class.java)
    }

    single<GeminiApi> {

        val secureStorageRepository =
            get<SecureStorageRepository>()

        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor { chain ->

                val apiKey = runBlocking {
                    secureStorageRepository.get(GEMINI_API_KEY)
                        ?.trim()
                }

                if (apiKey.isNullOrBlank()) {
                    throw IOException(
                        "Gemini API key is not configured"
                    )
                }

                val request = chain.request()
                    .newBuilder()
                    .addHeader(
                        "x-goog-api-key",
                        apiKey
                    )
                    .addHeader(
                        "Content-Type",
                        "application/json"
                    )
                    .build()

                chain.proceed(request)
            }
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()

        Retrofit.Builder()
            .baseUrl(GEMINI_BASE_URL)
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(GeminiApi::class.java)
    }

    single {
        LocalImageDataUrlProvider(
            context = get()
        )
    }
}