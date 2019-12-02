We have applied many design patterns, the followings are only some typical examples. 
We must emphasis that we are not using these patterns to show-off our knowledge, not merely using them to fulfil the requirement of the course. We are using them to keep our program of _higher quality_.

- Singleton
    - Most managers
    - Most build-in functions and instructions
- Factory
    - factory method
        - `Function` creates `Expression` corresponding to it. 
        - So as `Instruction`
- Command
    - Typical: `Expression`, which supports `execute()`
    - Not so typical: `VectorShape`
- Composite and decorator: 
    - `Expression`
