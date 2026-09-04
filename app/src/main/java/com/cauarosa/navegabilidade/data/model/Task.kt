package com.cauarosa.navegabilidade.data.model

// TODO: resolver Parcelize

data class Task(
    val id: String,
    val description: String,
    val status: Status = Status.TODO
)