## Open Close Principle

_Modules are open for extension, but closed for modification_. 

`***Manager`s. For example, `FunctionManger` . See its description.

Also see our wiki pages: _How to create new functions_ and _how to create new instructions_.


## Dependency Inversion Principle

- _Low level modules may depend on high level modules_
- _High level modules may not depend on low level modules_
- _Both should depend on abstraction_
- _Abstraction should not depend on details_

Almost everywhere, just give some example lah.

## Interface Segregation Principle

_One should not be forced to depends on the interfaces that they don't use_. 

One may think it is a violation of ISP that some operations on `CTValue` return `CTUndefined`. However, this is not the case. As we are trying our best to make the logic of evaluating expression simple, we apply JavaScript's variable analogue, which means that these `CTValue` are _expected_ to have the _functions_ that return `CTUndefined`. Therefore, logically, they _need_ to depend on these method definitions (which is the _interface_ in the definition of this principle).

## Single Responsibility Principle

_A class should only have one reason to change_. 

Almost everywhere, just give some example lah.

For example, `Turtle` and `GraphicTurtle`.

## Liskov's Substitution Principle

_Objects from sub-class must be capable to substitute their super-class's object_. 

   
## High cohesion and low coupling 

(Not principle, but very important)
