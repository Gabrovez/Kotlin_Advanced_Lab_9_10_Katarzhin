package example

sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String, val code: Int) : NetworkResult()
    object Loading : NetworkResult()
}
fun handleResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success ->{
            println("Success: ${result.data}")
        }
        is NetworkResult.Error ->{
            println("Error: ${result.code}: ${result.message}")
        }
        NetworkResult.Loading ->{
            println("Loading...")
        }
    }
}
fun main(){
    val success = NetworkResult.Success("Data received")
    val error = NetworkResult.Error("Server is not responding", 500)
    val loading = NetworkResult.Loading

    handleResult(success)
    handleResult(error)
    handleResult(loading)
}