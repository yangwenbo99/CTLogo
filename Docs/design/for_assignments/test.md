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
