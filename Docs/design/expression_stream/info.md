We use transition of State classes to model and replace complex state transition. 

(If you don't have PlantUML plug-in for markdown, please visit <plantuml.com>.

@startuml
hide empty description

[*] -> UnaryOperator
[*] -> Operable
[*] -> OpenParenthesis

Operable -> BinaryOperator
Operable -> CloseParenthesis

BinaryOperator --> Operable
BinaryOperator --> UnaryOperator
BinaryOperator --> OpenParenthesis

UnaryOperator --> Operable
UnaryOperator --> UnaryOperator
UnaryOperator --> OpenParenthesis

OpenParenthesis --> Operable
OpenParenthesis --> OpenParenthesis
OpenParenthesis --> UnaryOperator

CloseParenthesis --> CloseParenthesis
CloseParenthesis --> BinaryOperator
@enduml
