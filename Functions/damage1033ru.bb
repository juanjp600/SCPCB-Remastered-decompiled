Function damage1033ru%(arg0%)
    If (((arg0 > $00) And (arg0 < $0F)) <> 0) Then
        bloodloss = (rnd(5.0, 0.0) + bloodloss)
    ElseIf (((arg0 >= $0F) And (arg0 < $1E)) <> 0) Then
        bloodloss = (rnd(10.0, 0.0) + bloodloss)
    ElseIf (((arg0 >= $1E) And (arg0 < $32)) <> 0) Then
        bloodloss = (rnd(15.0, 0.0) + bloodloss)
    ElseIf (arg0 >= $32) Then
        bloodloss = (rnd(20.0, 0.0) + bloodloss)
    EndIf
    lightflash = 0.2
    i_1033ru\Field0 = (i_1033ru\Field0 - arg0)
    If (i_1033ru\Field0 <= $00) Then
        i_1033ru\Field0 = $00
    EndIf
    If (i_1033ru\Field2 = $02) Then
        If (i_1033ru\Field0 > $C8) Then
            i_1033ru\Field0 = $C8
        EndIf
    ElseIf (i_1033ru\Field0 > $64) Then
        i_1033ru\Field0 = $64
    EndIf
    i_1033ru\Field1 = (i_1033ru\Field1 + arg0)
    If (i_1033ru\Field1 <= $00) Then
        i_1033ru\Field1 = $00
    EndIf
    If (i_1033ru\Field2 = $02) Then
        If (i_1033ru\Field1 > $C8) Then
            i_1033ru\Field1 = $C8
        EndIf
    ElseIf (i_1033ru\Field1 > $64) Then
        i_1033ru\Field1 = $64
    EndIf
    If (i_1033ru\Field0 > $00) Then
        playsound_strict(damagesfx1033ru(rand($00, $03)))
    Else
        playsound_strict(deathsfx1033ru)
    EndIf
    Return $00
End Function
