package com.tamayo.countriesapplication.utils

/**
 * Represents the different states of a UI operation.
 *
 * @param T the type of data associated with the UI state
 */
sealed interface UIState<out T> {

    /**
     * Represents the loading state of a UI operation.
     */
    object LOADING : UIState<Nothing>

    /**
     * Represents the error state of a UI operation.
     *
     * @property error the exception associated with the error state
     */
    data class ERROR(val error: Exception) : UIState<Nothing>

    /**
     * Represents the success state of a UI operation.
     *
     * @property data the data associated with the success state
     */
    data class SUCCESS<T>(val data: T) : UIState<T>
}