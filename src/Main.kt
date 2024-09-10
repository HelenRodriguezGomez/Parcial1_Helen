fun main() {
    // Inicializa los candidatos
    val candidato1 = Candidato("Candidato A")
    val candidato2 = Candidato("Candidato B")
    val candidato3 = Candidato("Candidato C")

// instancia
    val eleccion = Eleccion(listOf(candidato1, candidato2, candidato3))

    // Medios validos de votacion
    val mediosValidos = mapOf(
        1 to "Internet",
        2 to "Radio",
        3 to "TV"
    )

    var opcion: Int
    do {
        println("\n=== Elecciones Municipales de Premier ===")
        println("\n=== Bienvenido, seleccione una opcion ===")
        println("1. Votar por un candidato")
        println("2. Calcular el costo de campaña de un candidato")
        println("3. Vaciar urnas")
        println("4. Conocer el número total de votos")
        println("5. Porcentaje de votos por candidato")
        println("6. Costo promedio de campaña")
        println("7. Conocer el candidato ganador")
        println("0. Salir")
        print("Seleccione una opción: ")
        opcion = readLine()?.toIntOrNull() ?: -1

        when (opcion) {
            1 -> {
                println("\n=== Votar por un candidato ===")
                println("0: Candidato A, 1: Candidato B, 2: Candidato C")
                print("Seleccione el candidato (0-2): ")
                val candidatoIndex = readLine()?.toIntOrNull() ?: -1

                if (candidatoIndex !in 0..2) {
                    println("Error: Índice de candidato fuera de rango.")
                } else {
                    println("Seleccione el medio de votación:")
                    mediosValidos.forEach { (key, medio) ->
                        println("$key: $medio")
                    }
                    print("Seleccione un medio (1-3): ")
                    val medioIndex = readLine()?.toIntOrNull() ?: -1

                    val medioSeleccionado = mediosValidos[medioIndex]

                    if (medioSeleccionado != null) {
                        eleccion.votarPorCandidato(candidatoIndex, medioSeleccionado)
                    } else {
                        println("Error: Opción de medio de votación no válida.")
                    }
                }
            }
            2 -> {
                println("\n=== Calcular el costo de campaña ===")
                println("0: Candidato A, 1: Candidato B, 2: Candidato C")
                print("Seleccione el candidato (0-2): ")
                val candidatoIndex = readLine()?.toIntOrNull() ?: -1
                if (candidatoIndex in 0..2) {
                    val costo = eleccion.candidatos[candidatoIndex].calcularCostoCampania()
                    println("Costo de campaña del candidato: $$costo")
                } else {
                    println("Error: Índice de candidato fuera de rango.")
                }
            }
            3 -> {
                println("\n=== Vaciar urnas ===")
                eleccion.vaciarUrnas()
            }
            4 -> {
                println("\n=== Número total de votos ===")
                val totalVotos = eleccion.totalVotos()
                println("Total de votos: $totalVotos")
            }
            5 -> {
                println("\n=== Porcentaje de votos por candidato ===")
                println("0: Candidato A, 1: Candidato B, 2: Candidato C")
                print("Seleccione el candidato (0-2): ")
                val candidatoIndex = readLine()?.toIntOrNull() ?: -1
                val porcentaje = eleccion.porcentajeVotos(candidatoIndex)
                if (porcentaje != 0.0) {
                    println("Porcentaje de votos del candidato: $porcentaje%")
                }
            }
            6 -> {
                println("\n=== Costo promedio de campaña ===")
                val costoPromedio = eleccion.costoPromedioCampania()
                if (costoPromedio != 0.0) {
                    println("El costo promedio de campaña es: $$costoPromedio")
                }
            }
            7 -> {
                println("\n=== Candidato ganador ===")
                val ganador = eleccion.candidatoGanador()
                if (ganador != null) {
                    println("El candidato ganador es: ${ganador.nombre}")
                }
            }
            0 -> println("Saliendo del sistema...")
            else -> println("Opción no válida. Intente nuevamente.")
        }
    } while (opcion != 0)
}
