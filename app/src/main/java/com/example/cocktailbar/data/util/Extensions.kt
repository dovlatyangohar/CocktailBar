package com.example.cocktailbar.data.util

import android.util.Log
import com.example.cocktailbar.core.ActionResult
import com.example.cocktailbar.core.CallException
import com.example.cocktailbar.core.Constants.Companion.ERROR_DATA
import com.example.cocktailbar.core.Constants.Companion.ERROR_NULL_DATA
import org.json.JSONObject
import retrofit2.Response

suspend fun <R> makeApiCall(call: suspend () -> ActionResult<R>) = try {
    call()
} catch (e: Exception) {
    ActionResult.Error(e)
}

fun <Model> analyzeResponse(
    response: Response<Model>
): ActionResult<Model> {
    return when (response.code()) {
        200 -> {
            val responseBody  = response.body()
            Log.i("GOHAR::: responseBody", responseBody.toString())
            responseBody?.let {
                ActionResult.Success(it)
            } ?: ActionResult.Error(CallException(ERROR_NULL_DATA))
        }
        else -> {
            val jObjError = response.errorBody()?.string()?.let { JSONObject(it) }
            if (jObjError?.has("message") == true) {
                val message = jObjError.getString("message")
                ActionResult.Error(CallException(ERROR_DATA, message))
            } else ActionResult.Error(CallException(response.code(), response.message()))

        }
    }

}