Function checkroomoverlap%(arg0.rooms, arg1.rooms)
    If ((((arg1\Field46 >= arg0\Field49) Or (arg1\Field47 >= arg0\Field50)) Or (arg1\Field48 >= arg0\Field51)) <> 0) Then
        Return $00
    EndIf
    If ((((arg1\Field49 <= arg0\Field46) Or (arg1\Field50 <= arg0\Field47)) Or (arg1\Field51 <= arg0\Field48)) <> 0) Then
        Return $00
    EndIf
    Return $01
    Return $00
End Function
