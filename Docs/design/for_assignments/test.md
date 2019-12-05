## Interpackage 

@startuml
rectangle ctlogo.data
rectangle ctlogo.function
rectangle ctlogo.execute_main
rectangle ctlogo.execute.expression

ctlogo.execute_main --> ctlogo.data
ctlogo.execute.expression --> ctlogo.data
ctlogo.function --> ctlogo.data
ctlogo.function --> ctlogo.execute.expression
ctlogo.execute_main --> ctlogo.execute.expression
@enduml


## ctlogo.function

Testing hierarchy 

@startuml
rectangle SinFunction
rectangle CosFunction
rectangle ForwardFunction
rectangle BackFunction
rectangle AbstractFunction
' rectangle Function
rectangle BasicFunctionExpression
rectangle FunctionManager
rectangle MakeFuction
rectangle PrintFunction
rectangle BuildInFunctionRegistrator

SinFunction --> AbstractFunction
CosFunction --> AbstractFunction
ForwardFunction --> AbstractFunction
BackFunction --> AbstractFunction
' AbstractFunction --> Function
AbstractFunction - BasicFunctionExpression
' FunctionManager --> Function
MakeFuction --> AbstractFunction
PrintFunction --> AbstractFunction
BuildInFunctionRegistrator --> SinFunction 
BuildInFunctionRegistrator --> CosFunction
BuildInFunctionRegistrator --> ForwardFunction
BuildInFunctionRegistrator --> BackFunction
BuildInFunctionRegistrator --> MakeFuction
BuildInFunctionRegistrator --> PrintFunction
BuildInFunctionRegistrator -> FunctionManager
@enduml


## ctlogo.data

Testing hierarchy 

@startuml
skinparam linetype ortho
rectangle TypeMarker #PapayaWhip 
rectangle TypeConversionDirection #LightYellow 
rectangle CTValue #LightYellow 
rectangle CTValueConverter #HoneyDew 
rectangle CTValueConverterManager #Azure 
' rectangle CTValue_default 
rectangle AbstractCTValue #Aquamarine 
rectangle CTUndefined #Lavender 
rectangle CTString #Lavender 
rectangle AbstractNumericalCTValue #Lavender 
rectangle CTDouble #Thistle 
rectangle CTBoolean #Thistle 
rectangle CTInteger_other #Thistle 
rectangle xxxConverter #Gainsboro 

rectangle CTBoolean_logical #Azure
rectangle CTInteger_arithmetics #LightBlue 

rectangle CTVariable #HoneyDew 
rectangle AbstractVariableManager  #Azure 
rectangle LocalVariableManager #Aquamarine 
rectangle GlobalVariableManager #Aquamarine 

CTValue --> TypeMarker
AbstractCTValue --> CTValue
CTUndefined --> AbstractCTValue
CTString --> AbstractCTValue
AbstractNumericalCTValue --> AbstractCTValue
CTDouble --> AbstractNumericalCTValue
CTInteger_other --> AbstractNumericalCTValue
CTBoolean --> AbstractNumericalCTValue

TypeConversionDirection --> TypeMarker
CTValueConverter --> TypeConversionDirection
xxxConverter --> CTValueConverter
xxxConverter --> CTValue
CTValueConverter --> CTValue

CTVariable --> CTValue
CTValueConverterManager --> CTValue
CTValueConverterManager --> CTValueConverter
AbstractVariableManager --> CTValue
AbstractVariableManager --> CTVariable
LocalVariableManager --> AbstractVariableManager
GlobalVariableManager --> AbstractVariableManager
' CTValue_default --> CTBoolean
' CTValue_default --> CTUndefined
AbstractCTValue --> CTValueConverterManager
AbstractVariableManager ..> CTInteger_other 

AbstractCTValue --> CTBoolean_logical
CTBoolean_logical --> CTValue

AbstractNumericalCTValue --> CTInteger_arithmetics
CTInteger_arithmetics --> AbstractCTValue

CTInteger_other --> CTDouble

AbstractNumericalCTValue ..> CTString

@enduml


## Expression

@startuml
skinparam linetype ortho

rectangle ctlogo.execute.expression {
	rectangle binary_expressions
	rectangle unary_expressions
	rectangle variable_expressions
	rectangle literal_expressions
	rectangle ExpressionManager
	rectangle instruction_expressions #GreenYellow 
}

rectangle function_expressions #MistyRose 

rectangle rpn #Azure

rectangle BasicExpressionHelper

rectangle ExpressionStream

rectangle util

ExpressionManager --> binary_expressions
ExpressionManager --> unary_expressions

rpn --> binary_expressions
rpn --> unary_expressions
rpn --> variable_expressions
rpn --> literal_expressions
rpn --> function_expressions
rpn --> instruction_expressions

ExpressionStream --> rpn
ExpressionStream --> BasicExpressionHelper

unary_expressions ..> literal_expressions
binary_expressions ..> literal_expressions


@enduml

### Unary operators

@startuml
rectangle PositiveOperator
rectangle NegativeOperator
rectangle AbstractUnaryOperator

PositiveOperator --> AbstractUnaryOperator
NegativeOperator --> AbstractUnaryOperator

@enduml

### Binary operators

@startuml
rectangle PlusOperator
rectangle MinusOperator
rectangle AbstractBinaryOperator
rectangle other #HoneyDew 

PlusOperator --> AbstractBinaryOperator
MinusOperator --> AbstractBinaryOperator
other --> AbstractBinaryOperator

@enduml
