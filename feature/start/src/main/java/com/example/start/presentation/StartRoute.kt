sealed class StartRoute(val route: String) {
    object Welcome : StartRoute("welcome")
    object Familiarity : StartRoute("familiarity")
    object Instruments : StartRoute("instruments")
    object Experience : StartRoute("experience")
    object Topics : StartRoute("topics")
    object Confidence : StartRoute("confidence")
    object Result : StartRoute("result")

    override fun toString(): String = route
}
