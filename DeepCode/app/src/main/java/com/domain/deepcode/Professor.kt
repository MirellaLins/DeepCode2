package com.domain.deepcode


val professor = Professor(
    cpf = "8932787438",
    name = "dahdsiuhdsui"
)

data class Professor (
    val id: Int = 0,
    val name: String,
    val cpf: String,
    val telefone: String = ""
)