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
