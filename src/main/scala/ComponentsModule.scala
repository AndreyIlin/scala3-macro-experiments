package com.ailin

import scala.quoted.*

trait ComponentsModule:
    def components: List[String]

    inline def collectComponentsFor[T <: ComponentsModule](app: T): List[String] =
        ${ComponentsModule.collectComponentsFor('app)}

object ComponentsModule:
    def collectComponentsFor[T](app: Expr[T])
                               (using q: Quotes, t: Type[T]): Expr[List[String]] =
        import q.reflect.*

        val typeRepr = TypeRepr.of[T]
        val classSymbol = typeRepr.classSymbol.getOrElse(report.throwError("type is not a class"))
        val values = classSymbol.memberFields.filter { field =>
            typeRepr.memberType(field).classSymbol.exists(_ == defn.StringClass)
        }
        val selects = values.map(value => Select(This(classSymbol), value).asExprOf[String])
        Expr.ofList(selects)
