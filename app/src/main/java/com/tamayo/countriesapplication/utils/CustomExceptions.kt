package com.tamayo.countriesapplication.utils

/**
 * Custom exception classes for handling specific scenarios.
 */
class CustomExceptions {

    /**
     * Exception class for representing a null response.
     *
     * @param message the error message associated with the exception
     */
    class NullResponse(message: String = "Response was null") : Exception(message)

    /**
     * Exception class for representing a failed response.
     *
     * @param message the error message associated with the exception
     */
    class FailResponse(message: String?) : Exception(message)
}