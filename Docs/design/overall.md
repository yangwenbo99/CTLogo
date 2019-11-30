## Desc

The following classes/interfaces are used nearly everywhere, which need
very careful design

- `Screen`
- `CTValue`
- `CTValuable`
- `ConfigReader`

The following has cross-module reference: 
- `CTVariableManager`

## Main modules

@startuml

skinparam linetype ortho

package ctlogo.processing {
    interface TokenStream  {
        + pushBack(parameter)
        + pushFront(parameter)
        + getBack() : String
        + popBack() : String
        + getNextLine() : List<String> 
        + getRow() : int
        + getColumn() : int
        + etc.()
    }
}

package ctlogo.execute {
    class ExpressionUtility {
        + {static} isInteger(s : String) : Boolean
        + {static} isFloat(s : String) : Boolean
        + {static} isString(s : String) : Boolean
        + {static} isFunctionName(s : String) : Boolean
        + {static} isVariableName(s : String) : Boolean
        + {static} isBinaryOperator(s : String) : Boolean
        + {static} isUnaryOperator(s : String) : Boolean
    }
    interface Expression {
        + evaluate() : CTValue
    }

    interface ExpressionStream {
        + getNextExpression() : Expression  // Evaluate [ ] to value list, {} to block
        + getNextBlock() : List<Expression> // for {} and []
        + getNextString() : Expression   // variable, literal or function result, [] to string
    }

    class ExpressionEvaluator {
        + ExpressionEvaluator(s : String) 
        + ExpressionEvaluator(s : InStream)
        + ExpressionEvaluator(s : TokenStream)
        + execute()
        + getNextExpressionValue() : CTValue // evaluate [] to CTList
        + getNextString() : CTString
        + getNextBlock() : List<Function>   // evaluate [ ] to block
        + getNextLiteralValue()    // evaluate [] to string
        # getNextFunction() : Function
    }

    class FunctionGetter {
        // This is the factory of Function objects
        + register(name : String, command: Class)
        + getFunction(functionName : String, 
            ts : TokenStream) : Function
        + etc.()
    }

    FunctionGetter -> FunctionGetter

    interface Function {
        // a factory method looks like Function(TokenStream) shall be used
        // a factory method looks like Function(is_in_TokenStream) shall also be used
        + execute(context : Context)
        + getDefaultParameterNumber() : int
        + getMinParameterNumber() : int
        + getMaxParameterNumber() : int
    }

    interface Context {
        - parentContext : Context
        + getInputStream() : InStream
        + getOutputStream() : OutStream
        + getScreen() : ctlogo.graphic.Screen
        + getVariableManager() : ctlogo.data.VariableManager
        + getValue(token : String) : ctlogo.data.CTValue
            // getValue method turn a token to CTValue. the token may be 
            // literal or variable name 
        + getNextValue() : CTValue
    }

    ExpressionEvaluator --> FunctionGetter
    ExpressionEvaluator -- Function 
    ExpressionEvaluator -- Context

    FunctionGetter --> Function
    Function --> Context

    Expression <|.. Function
    Expression <|.. LiteralExpression
    LiteralExpression <|.. ListLiteralExpression
    Expression <|.. VariableExpression
    Expression <|.. UnaryOperation
    Expression <|.. BinaryOperation

    ExpressionStream -- Expression
}

FunctionGetter --> TokenStream
ExpressionEvaluator --> TokenStream
Function --> TokenStream

ctlogo.data.VariableManager <- Function 
ctlogo.data.CTValue <- Function 

package ctlogo.graphic {
    interface Screen {
        + drawLine(x1 : double, y1 : double, x2 : double, y2 : double)
        + drawRectangle(x1 : double, y1 : double, x2 : double, y2 : double)
        + drawEllipse(cx : double, cy : double, a : double, b : double)
        + drawBlaBla()
        + clean() 
        + setWidth(w : double)
        + setHeight(h : double)
    }

    interface VectorShape {
        + draw ()
    }

    interface ScreenPainter {
        + paint(Graphics g) : void
    }

    class VectorScreenPainter {
        // used for JFrame
        + paint(Graphics g) : void
    }

    class VectorScreen {
        // this has limited "PE" support 
        + getShapeList() : Iterable<VectorShape>
    }

    class Tutle {
        + getX()
        + getY()
        + setX()
        + setY()
        + setXY()
    }

    class TutleManager {
        + newTutle(idx : int, t : Tutle)
        + getTutle(idx) 
    }

    TutleManager --> Tutle

    Screen <|.. VectorScreen

    VectorScreen -- VectorShape

    ScreenPainter <|.. VectorScreenPainter  

    VectorShape <- VectorScreenPainter
    VectorScreen <- VectorScreenPainter
}



Context --> Screen
Function --> Screen


ctlogo.processing -[hidden]- ctlogo.data
ctlogo.data -[hidden]- ctlogo.execute

@enduml

## Exceptions

@startuml
package ctlogo.exception {
    Exception <|. CTException 

    class CTException {
    }

    class CTSyntaxException {
        + getRow() : int
        + getColumn() : int
    }

    class CTLogicException {
    }

    class CTArgumentException {
    }

    class CTDataException {
    }

    class CTConversionNotSupportedException {
    }

    class CTUserException {
    }

    CTException <|-- CTSyntaxException
    CTException <|-- CTLogicException
    CTLogicException <|-- CTArgumentException
    CTLogicException <|-- CTDataException
    CTDataException <|-- CTConversionNotSupportedException
    CTException <|-- CTUserException

    note as N1 
        There may also be many other exceptions.
        If an exception is used among different packages, it shuld be 
        defined here, otherwise, it should be defined in the specified 
        package.
    end note 

    N1 -[hidden]- CTException
}
@enduml

## Data

@startuml
package ctlogo.data {
    note as N1d
        There may also be many other Datatypes. they should be defined
        in this package. 
    end note 

    N1d -[hidden]- CTValue

    interface CTValue {
        + equals(other: CTValue) : CTBoolean
        + compareTo(other: CTValue) : CTInteger
        + toString() : String
        + getTypeName() 
    }

    class CTBoolean {
    }

    class CTInteger {
    }

    class CTUndefined {
    }

    CTValue <|.. CTBoolean 
    CTValue <|.. CTInteger
    CTValue <|.. CTUndefined

    class CTVariable {
        + getValue() : CTValue
        + setValue(v : CTValue)
    }

    CTVariable -> CTValue

    class CTVariableManager {
        + isDefined(name : String) : Boolean
        + getVariable(name : String) : CTVariable
        + setVariable(name : String, CTVariable)
        + parse(content : String) : CTVariable
        + convert(original : CTValue, type : String)
        + convert(original : CTValue, type : Class<CTValue>)
        + create(type : String, value : Object) : CTValue
    }

    CTVariableManager -> CTVariableManager

    CTVariableManager --> CTVariable
    CTVariableManager --> CTValue

}
@enduml


## Config

@startuml

package ctlogo.config {
    note as NConfigReader 
        This is a very simple but important singleton or static class.
        This class can be used in many places.
        Once written, this will not ba changed.
    end note

    class ConfigReader {
        + getConfig(name: String) : String
    }

    ConfigReader -> ConfigReader


    NConfigReader -[hidden]- ConfigReader
}
@enduml


The correlations due to throwing exception are not drawn.


## Logo objects

An object may be 

- a value
- a user-defined object
- a command
