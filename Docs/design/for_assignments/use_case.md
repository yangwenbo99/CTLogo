@startuml
left to right direction

:User:

rectangle CTLogo {
    (Execute command) as EC
    (Execute drawing command) as Drawing
    (Execute printing command) as Printing
    (Execute calculation commands) as Calculation

    (Change window size) as CWS

    (Parse input) as Parse
    (Generate command tree) as GenComT
    (Execute command tree) as ExeComT
}

User --> EC

EC ..> Parse : <<include>>
EC ..> GenComT : <<include>>
EC ..> ExeComT : <<include>>

EC <|- Drawing
EC <|- Printing
EC <|- Calculation
User --> CWS


@enduml
