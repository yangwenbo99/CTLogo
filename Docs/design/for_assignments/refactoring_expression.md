1. Replace the method `getNextExpression` with the `ExpressionGetter` class

2. Replace long condition with query, for example,
	- `isOperatorToken`
	- `isOperableToken`
		- Problem causing issue #6 is detected in this process

3. Extract code to method 
	- `getUntil`

4. Applying state design pattern 
	We use transition of State classes to model and replace complex state transition. 

5. Factoring out `getOperableState` mathod

6. Simplify it by making the itial state UnaryOperatorState("+")

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
