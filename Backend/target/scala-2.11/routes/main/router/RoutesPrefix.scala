
// @GENERATOR:play-routes-compiler
// @SOURCE:/usr/src/app/conf/routes
// @DATE:Mon Feb 20 07:10:22 UTC 2023


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
