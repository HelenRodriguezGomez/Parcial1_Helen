class Candidato(val nombre: String) {
    var votosInternet: Int = 0
        private set
    var votosRadio: Int = 0
        private set
    var votosTv: Int = 0
        private set

    // Agregar votos dep. del medio
    fun agregarVoto(medio: String) {
        when (medio.toLowerCase()) {
            "internet" -> votosInternet++
            "radio" -> votosRadio++
            "tv" -> votosTv++
        }
    }

    // Calculo costo de la campaña
    fun calcularCostoCampania(): Int {
        return (votosInternet * 700000) + (votosRadio * 200000) + (votosTv * 600000)
    }

    // Calculo total de votos del candidato
    fun totalVotos(): Int {
        return votosInternet + votosRadio + votosTv
    }

    // Método para vaciar los votos del candidato
    fun vaciarVotos() {
        votosInternet = 0
        votosRadio = 0
        votosTv = 0
    }
}
