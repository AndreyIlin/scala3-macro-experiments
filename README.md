### Experiments with macros in scala 3

Current macro is a **POC** that collects instances of a specific type (in current implementation `String`s) into a list,
given an application built with traits containing those instances.

Helpful resources for learning scala 3 macros:

* https://github.com/lampepfl/dotty-macro-examples
* https://softwaremill.com/scala-3-macros-tips-and-tricks/

_TODOs_:
* Find a way to force a user to always use a macro method instead of building a list manually. Maybe through some
  implicit
  (given). As far as I can see that's not possible at the moment, because macro cannot mutate context AST,
  like adding some given instances to an application passed as a parameter to a macro. Maybe it will be possible in the
  future, say through an explicit tree typechecking. 🤷‍
* Examine self type annotation to determine which traits should be considered for search for a specific type instances
  also consider using an inheritance instead.
* Use some real-world examples