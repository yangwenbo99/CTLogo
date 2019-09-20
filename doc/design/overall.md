## Desc

The following classes/interfaces are used nearly everywhere, which needs
very careful design
- `Screen`
- `CTValue`
- `CTValuable`
- `ConfigReader`

The following has cross-module reference: 
- `CTVariableManager`

## Main modules

@startuml

package ctlogo.processing {
    interface Tokenizer {
    }

    interface TokenStream {
        + pushBack(parameter)
        + pushFront(parameter)
        + getBack() : String
        + popBack() : String
        + etc.()
    }

    TokenStream --> Tokenizer
}

package ctlogo.execute {
    class CommandExecutor {
    }

    class CommandGetter {
        + register(name : String, command: Class)
        + getCommand(command : String, 
            ts : TokenStream) : Command
        + etc.()
    }

    CommandGetter -> CommandGetter

    interface Command {
        // a factory method looks like Command(TokenStream) shall be used
        + execute(context : Context)
    }

    interface Context {
        - parentContext : Context
        + getInputStream() : InStream
        + getOutputStream() : OutStream
        + getScreen() : ctlogo.graphic.Screen
        + getValuableManager() : ctlogo.data.VariableManager
        + getValue(token : String) : ctlogo.data.CTValue
            // getValue method turn a token to CTValue. the token may be 
            // literal or variable name 
    }

    CommandExecutor --> CommandGetter
    CommandExecutor --> Command 

    CommandGetter --> Command
    Command --> Context
}

CommandExecutor --> TokenStream
Command --> TokenStream

ctlogo.data.VariableManager <- Command 
ctlogo.data.CTValue <- Command 

package ctlogo.graphic {
    interface Screen {
        + drawLine(x1 : double, y1 : double, x2 : double, y2 : double)
        + drawRectangle(x1 : double, y1 : double, x2 : double, y2 : double)
        + drawEllipse(cx : double, cy : double, a : double, b : double)
        + drawBlaBla()
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

    Screen <|.. VectorScreen

    VectorScreen -- VectorShape

    ScreenPainter <|.. VectorScreenPainter  

    VectorShape <- VectorScreenPainter
    VectorScreen <- VectorScreenPainter
}



Context --> Screen
Command --> Screen


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


