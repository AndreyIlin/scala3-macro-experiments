package com.ailin

import scala.quoted.{Expr, Quotes}

@main def hello =
    val app = new ComponentsModule with Component1 with Component2 {
        override def components = collectComponentsFor(this)
    }
    println(app.components)


trait Component1 { self: ComponentsModule =>
    val component1: String = "I'm the component 1"
}
trait Component2 { self: ComponentsModule =>
    val component2: String = "I'm the component 2"
}






