Abbreviations: 
- BC: for backward-compatibility
- DF: different from PC Logo
- CT: new feature in CTLogo

CTLogo is based on expressions. 

A expression is defined as following: 
- A value, including `undefined`, is an expression
- A function call is an expression
- Expressions connected by binary operators is an expression.
- `-:expression` is an expression
- `[:expression]` is an expression
- A block of commands is an expression. 

Values
- An integer is a value
- A float point number is a value
- A string is a value, a string shall be surrounded by single quotation mark, eg `'a string'` (CT)
    - A word (regex: `"\w[\w\d]*`) is regarded as a string (BC)
    - A list is regarded as a string on appropriate position (BC)


Function call: 
- `:fun :expression * n` a function call, where `:fun` is a function name, `n` is the number of (predefined) parameter
- `(:fun :expression * n)` a function call, where `:fun` is a function name, `n` can be the (one of) the acceptable number(s) of parameter(s).


Block of commands
- Surrounded by `{` and `}`  (CT)
- Surrounded by `[` and `]`  (BC)


### Operators

```logo
- 
"
''

+ - * / ^
< > <= >= =
```

Evaluation is greedy


### Names

Names always begin with a colon, then alphanumeral characters. 
