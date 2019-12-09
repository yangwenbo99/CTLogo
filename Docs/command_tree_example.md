`sin :x + ((cos :y) * 4)`

@startuml

object PlusOperator
object SinFunction
object CosFunction
object MultiplyOperator
object "VariableExpression" as X
X : name = 'x'

object ":y : VariableExpression" as Y
Y : name = 'y'

object "LiteralOperator" as Four

Four : value = 4

PlusOperator --> SinFunction
SinFunction --> X
PlusOperator --> MultiplyOperator
MultiplyOperator --> CosFunction
CosFunction --> Y
MultiplyOperator --> Four 


@enduml
