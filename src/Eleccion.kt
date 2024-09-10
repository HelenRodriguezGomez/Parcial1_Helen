class Eleccion(val candidatos: List<Candidato>) {

    // Votar por un candidato con validación de índice y medio
    fun votarPorCandidato(candidatoIndex: Int, medio: String) {
        if (candidatoIndex !in candidatos.indices) {
            println("Error: Índice de candidato fuera de rango. Intente nuevamente.")
            return
        }

        val mediosValidos = listOf("internet", "radio", "tv")
        if (medio.toLowerCase() !in mediosValidos) {
            println("Error: Medio de votación no válido. Solo se permite 'Internet', 'Radio' o 'TV'.")
            return
        }

        candidatos[candidatoIndex].agregarVoto(medio)
    }

    // Vaciar las urnas
    fun vaciarUrnas() {
        candidatos.forEach {
            it.vaciarVotos()
        }
        println("Todas las urnas han sido vaciadas.")
    }

    // total de votos
    fun totalVotos(): Int {
        return candidatos.sumOf { it.totalVotos() }
    }

    // Obtener porcentaje de votos para cada candidato
    fun porcentajeVotos(candidatoIndex: Int): Double {
        val totalVotos = totalVotos()
        if (totalVotos == 0) {
            println("Error: No hay votos registrados para calcular el porcentaje.")
            return 0.0
        }

        if (candidatoIndex !in candidatos.indices) {
            println("Error: Índice de candidato fuera de rango. Intente nuevamente.")
            return 0.0
        }

        val votosCandidato = candidatos[candidatoIndex].totalVotos()
        return (votosCandidato.toDouble() / totalVotos) * 100
    }

    // costo promedio de campaña con validación de votos
    fun costoPromedioCampania(): Double {
        val totalCosto = candidatos.sumOf { it.calcularCostoCampania() }
        val totalVotos = totalVotos()
        if (totalVotos == 0) {
            println("Error: No se puede calcular el costo promedio ya que no hay votos registrados.")
            return 0.0
        }

        return totalCosto.toDouble() / totalVotos
    }

    //  ganador
    fun candidatoGanador(): Candidato? {
        if (totalVotos() == 0) {
            println("Error: No hay votos para determinar un ganador.")
            return null
        }

        return candidatos.maxByOrNull { it.totalVotos() }
    }
}
